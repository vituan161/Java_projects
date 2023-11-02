package eiu.cit.netprog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;

public class SourceViewer {

	public static void main(String[] args) {
		try {
			URL u = new URL(args[0]);
			InputStream in = u.openStream();
			FileOutputStream w = new FileOutputStream(new File("Data\\Image.txt"));
			//không sử dụng Reader và Writer vì ở program này không cần dùng char chỉ dùng byte
			int r;
			int count=0;
			while((r=in.read())!=-1) {
				w.write(r);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
