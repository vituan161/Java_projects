package eiu.cit.netprog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class CountCharacters {

	public static void main(String[] args) throws IOException {
		String path = "Data\\";
		String name = "TheFile.txt";
		int count = 0;
		InputStream reader = new FileInputStream(new File(path+name));
		while(reader.read() !=-1) {
			count++;
		}
		System.out.println(count);
	}

}
