package eiu.cit.netprog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CountCharacters2 {

	public static void main(String[] args) throws IOException {
		String path = "Data\\";
		String name = "TheFile.txt";
		//int count = 0;
		StringBuilder sb = new StringBuilder();
		Reader reader =new InputStreamReader(new FileInputStream(new File(path+name)),"UTF-8");
		Writer writer =new OutputStreamWriter(new FileOutputStream(new File(path+"123.txt")),"UTF-8");
		
		int r;
		while ((r = reader.read()) !=-1) {
		//	count++;
			writer.write((char)r);
			
		};
		reader.close();
		writer.close();
		//System.out.println(" "+ count);
	}

}
