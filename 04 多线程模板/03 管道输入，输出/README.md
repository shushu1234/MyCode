# 管道的输入输出 #
管道主要用于线程之间的数据传输，而传输的媒介为内存

	PipedWriter out=new PipedWriter();
	PipedReader in=new PipedReader();
	out.contect(in); //对于piped类型，必须要先进行绑定，也就是调用contect()方法，如果没有将输入流与输出流绑定起来的话，将会抛出异常