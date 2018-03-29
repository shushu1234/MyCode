package com.liuyao;// $Id$

import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

public class MultiPortEcho
{
  private int ports[];
  private ByteBuffer echoBuffer = ByteBuffer.allocate( 1024 );

  public MultiPortEcho( int ports[] ) throws IOException {
    this.ports = ports;

    go();
  }

  private void go() throws IOException {
    // 创建一个新的selector
    Selector selector = Selector.open();

    // Open a listener on each port, and register each one
    // with the selector
    for (int i=0; i<ports.length; ++i) {
//      为每个连接创建一个ServerSocketChannel
      ServerSocketChannel ssc = ServerSocketChannel.open();
//      将ServerSocketChannel设置为非阻塞的
      ssc.configureBlocking( false );

//      绑定到指定端口上
      ServerSocket ss = ssc.socket();
      InetSocketAddress address = new InetSocketAddress( ports[i] );
      ss.bind( address );

//      将新打开的SelectionKey注册到Selector上，第一个参数是这个Selector，
//      第二个参数为OP_ACCEPT表示我们要监听accept事件，也就是在新的连接建立时
//      发生的事件，这是适用于ServerSocketChannel的唯一事件类型，返回值SelectionKey
//      表示这个通道在此Selector上的这个注册，当某个Selector通知你某个传入事件的时，他是
//      通过对应的SelectionKey来进行的，SelectionKey还可以用于取消通道的注册
      SelectionKey key = ssc.register( selector, SelectionKey.OP_ACCEPT );

      System.out.println( "Going to listen on "+ports[i] );
    }

//    内部循环
    while (true) {
//        调用selector的select方法后，这个方法会阻塞，直到至少有一个已注册的事件发生
//        如果有一个或多个事件发生时,select方法将返回所发生事件的数量
      int num = selector.select();

//      selector.selectedKeys()方法会返回发生了事件的SelectionKey的集合
      Set selectedKeys = selector.selectedKeys();
//      获得SelectionKey集合的迭代器对象
      Iterator it = selectedKeys.iterator();

      while (it.hasNext()) {
//          依次从集合从取出SelectionKey，逐个处理
        SelectionKey key = (SelectionKey)it.next();

//        确定发生的是什么I/O事件 readOps()获取此键的 ready 操作集合。
        if ((key.readyOps() & SelectionKey.OP_ACCEPT)
          == SelectionKey.OP_ACCEPT) {
//          接受新的连接，我们知道这个服务器上有一个传入连接在等待，所以可以安全的接受它
          ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
          SocketChannel sc = ssc.accept();

//          将新连接的SocketChannel配置为非阻塞的
          sc.configureBlocking( false );

//          由于接受这个连接的目的是为了读取来自套接字的数据，所以我们还必须将SocketChannel注册到Selector上
          // Add the new connection to the selector
          SelectionKey newKey = sc.register( selector, SelectionKey.OP_READ );
//          删除处理过的SelectionKey
          it.remove();

          System.out.println( "Got connection from "+sc );
//          当来自一个套接字的数据到达时,它会触发一个I/O事件,这回导致在主循环中调用Selector.select
//            并返回一个或多个I/O事件
        } else if ((key.readyOps() & SelectionKey.OP_READ)
          == SelectionKey.OP_READ) {
          // Read the data
          SocketChannel sc = (SocketChannel)key.channel();

          // Echo data
          int bytesEchoed = 0;
          while (true) {
            echoBuffer.clear();

            int r = sc.read( echoBuffer );

            if (r<=0) {
              break;
            }

            echoBuffer.flip();

            sc.write( echoBuffer );
            bytesEchoed += r;
          }

          System.out.println( "Echoed "+bytesEchoed+" from "+sc );

          it.remove();
        }

      }

//System.out.println( "going to clear" );
//      selectedKeys.clear();
//System.out.println( "cleared" );
    }
  }

  static public void main( String args[] ) throws Exception {
    if (args.length<=0) {
      System.err.println( "Usage: java MultiPortEcho port [port port ...]" );
      System.exit( 1 );
    }

    int ports[] = new int[args.length];

    for (int i=0; i<args.length; ++i) {
      ports[i] = Integer.parseInt( args[i] );
    }

    new MultiPortEcho( ports );
  }
}
