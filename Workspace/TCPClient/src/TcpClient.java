import java.io.*; 
import java.net.*;

public class TcpClient {

	public static void main(String[] args) throws Exception {
		//Creates 2 empty strings
		String sentence;
		String modifiedSentence;
		//Creates an object of buffered reader reading user input
		BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
		//Creates a socket recieving and sending messages at IP localhost and port 8888
		Socket clientSocket = new Socket("localhost", 8888);
		//
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence + "\n");
		modifiedSentence = inFromServer.readLine();
		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close();
	}

}
