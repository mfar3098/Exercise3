import java.net.*;
import java.io.*;

public class Server {
	public static void main(String[] args) throws IOException{
		ServerSocket serverSocket = null;
		
		try {
			int portNo = 4225;
			serverSocket = new ServerSocket(portNo);
			
			String text1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum";
			System.out.println("Waiting for request");
			
			int length = text1.length();
			
			while(true) {
				Socket clientSocket = serverSocket.accept();
				DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
				outputStream.writeUTF("There are "+length + " words.");
				clientSocket.close();
			}
		}catch (IOException ioe) {
			if(serverSocket != null)
				serverSocket.close();
			ioe.printStackTrace();
		}
	}

}
