package eiu.cit.netprog;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Inter();
	}

	public static void Inter() {
		InetAddress local;
		try {
			local = InetAddress.getByName("127.0.0.1");
			NetworkInterface ni = NetworkInterface.getByInetAddress(local);

			if (ni == null) {

				System.err.println("That's weird. No local loopback address.");

			} else {

				System.out.println(ni);

			}
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

			while (interfaces.hasMoreElements()) {

				NetworkInterface ni2 = interfaces.nextElement();

				System.out.println(ni2);

			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void Inet() {
		try {

			InetAddress address = InetAddress.getByName("aao.eiu.edu.vn");

			System.out.println(address.getHostName());

		} catch (UnknownHostException ex) {

			System.out.println("Could not find www.oreilly.com");
		}
	}

}
