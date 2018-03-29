package com.liuyao;// $Id$

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class CopyFile
{
  static public void main( String args[] ) throws Exception {
    if (args.length<2) {
      System.err.println( "Usage: java CopyFile infile outfile" );
      System.exit( 1 );
    }

    String infile = args[0];
    String outfile = args[1];

//    获得输入输出流
    FileInputStream fin = new FileInputStream( infile );
    FileOutputStream fout = new FileOutputStream( outfile );

//    获得channel
    FileChannel fcin = fin.getChannel();
    FileChannel fcout = fout.getChannel();
//      创建缓冲区
    ByteBuffer buffer = ByteBuffer.allocate( 1024 );

    while (true) {
//        从输入通道读取到缓冲区之前，调用clear，使它可以接受读入的数据
      buffer.clear();
//        读取数据
      int r = fcin.read( buffer );
//        当读到字符为-1时表示读取完毕
      if (r==-1) {
        break;
      }
//        将缓冲区的内容写到输出通道前，调用flip，可以让缓冲区将新的读入数据写到另一个通道
      buffer.flip();
//      输出通道写到缓冲区中
      fcout.write( buffer );
    }
  }
}
