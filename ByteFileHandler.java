package Streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteFileHandler 
{
	public void writeAndReadByteStream() {
        try {
            // Write to file using byte stream
            FileOutputStream fos = new FileOutputStream("bytefile.txt");
            String data = "Hello from Byte Stream!";
            fos.write(data.getBytes());
            fos.close();

            // Read from file using byte stream
            FileInputStream fis = new FileInputStream("bytefile.txt");
            int i;
            System.out.println("Byte Stream Output:");
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println("\n");  // new line after output
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
