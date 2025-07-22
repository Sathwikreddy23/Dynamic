package Streams;

public class Main {

	public static void main(String[] args) 
	{
		
		ByteFileHandler byteHandler = new ByteFileHandler();
        byteHandler.writeAndReadByteStream();

   
        CharFileHandler charHandler = new CharFileHandler();
        charHandler.writeAndReadCharStream();
	}

}
