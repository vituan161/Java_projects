package eiu.cit.netprog;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.*;

import javazoom.jl.player.Player;


public class SourceViewer {

	public static void main(String[] args) {
		try {
			URL u = new URL(args[0]);
			InputStream in = u.openStream();
			//SourceDataLineExp(in);
			radio(in);
			
			//không sử dụng Reader và Writer vì ở program này không cần dùng char chỉ dùng byte
			
			
			//ClipExp(path);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void SourceDataLineExp(InputStream is) {
		//download and hear audio at the same time
		String path = "Data\\Image.txt";
		InputStream in = is;
		
		try {
			FileOutputStream w = new FileOutputStream(new File(path));
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new BufferedInputStream(in));
			AudioFormat AFormat = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class,AFormat);
			SourceDataLine sourceDataLine = (SourceDataLine) AudioSystem.getLine(info);
			
			sourceDataLine.open(AFormat);
			sourceDataLine.start();
			final int BUFFER_SIZE = 8096;
			byte[] bufferBytes = new byte[BUFFER_SIZE];
			int readBytes = -1;
			while ((readBytes = audioStream.read(bufferBytes)) != -1) {
			    sourceDataLine.write(bufferBytes, 0, readBytes);
			    w.write(bufferBytes);
			}
			sourceDataLine.drain();
			sourceDataLine.close();
			audioStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void radio(InputStream in) {
			try {
				Player mp3 = new Player(new BufferedInputStream(in));
				mp3.play();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	
	public static void ClipExp(String path) {
		try {
			InputStream in = new FileInputStream(new File(path));
			InputStream bufferstream = new BufferedInputStream(in);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferstream);
			AudioFormat AFormat = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class,AFormat);
			Clip clipAudio = (Clip) AudioSystem.getLine(info);
			
			
			clipAudio.open(audioStream);
			clipAudio.start();
			Thread.sleep(clipAudio.getMicrosecondLength()/1000);
			clipAudio.close();
			audioStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
