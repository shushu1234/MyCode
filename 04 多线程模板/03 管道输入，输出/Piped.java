package com.liuyao1;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created By liuyao on 2018/3/5 16:07.
 */

/**
 * 创建printThread，它用来接受main线程的输入，任何main线程的输入
 * 均通过PipedWriter写入，而printThread在另一端通过PipedReader将内容读出并打印
 */
public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out=new PipedWriter();
        PipedReader in=new PipedReader();
//        将输入流和输出流进行连接，否则在使用时会抛出IOException
        out.connect(in);
        Thread printThread=new Thread(new Print(in),"PrintThread");
        printThread.start();
        int receive =0;
        try {
            while ((receive=System.in.read())!=-1){
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }

    static class Print implements Runnable{
        private PipedReader in;
        public  Print(PipedReader in){
            this.in=in;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = in.read())!=-1){
                    System.out.print((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
