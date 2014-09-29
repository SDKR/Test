import java.io.*;
import java.net.*;
import DatabaseLogic.DatabaseConnection;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		//Creates 2 string to hold random stuff
		String clientSentence;
		String capitalizedSentence;
		//Creates a socket to send and recieve messages in port 8888
		ServerSocket welcomeSocket = new ServerSocket(8888);
		DatabaseConnection DC = new DatabaseConnection();
		//While something is true
		while(true)
		{
			//Creates a socket and a buffered reader which recieves some sort of input from somewhere around the internet!
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			//Creates an object of the data which is to be send back to the client, via the connectionSocket
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			//Sets client sentence equals input from client
			clientSentence = inFromClient.readLine();
			//Read if InFromClient is a Query or update
			if(clientSentence.contains("Insert"))
			{
				DC.doUpdate(clientSentence);
			}
			else
			{
				
			}
			//Sysout recieved message
			System.out.println("Received: " + clientSentence);
			//capitalized sentece sets equal recieved message capitalized
			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			//Sends the capitalized message back to client!!
			outToClient.writeBytes(capitalizedSentence);
			//BufferedWriter writer = new BufferedWriter(arg0)
			}
	 }
}
