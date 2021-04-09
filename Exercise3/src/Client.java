import java.net.*;
import java.io.*;

public class Client {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket(InetAddress.getLocalHost(), 4225);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String text = bufferedReader.readLine();
			System.out.println(text);
			
			bufferedReader.close();
			socket.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
