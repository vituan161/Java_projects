package eiu.cit.netprog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.InetAddress;

public class schoolwork {

	public static void main(String[] args) {
		String path = "Data\\";
		String file = "IPList.txt";
		try {
			Reader reader = new InputStreamReader(new FileInputStream(new File(path+file)));
			int r;
			while ((r = reader.read())!=-1) 
			{
				String local = "";
				while(r != 32) {
					local += String.valueOf((char)r);
				}
				System.out.println(local);
				//InetAddress local = new InetAddress.getByName()
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
