package Streams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharFileHandler 
{
	public void writeAndReadCharStream() {
        try {
            // Write to file using character stream
            FileWriter fw = new FileWriter("charfile.txt");
            fw.write("Hello from Character Stream!");
            fw.close();

            // Read from file using character stream
            FileReader fr = new FileReader("charfile.txt");
            int i;
            System.out.println("Character Stream Output:");
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            System.out.println();  // new line after output
            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
