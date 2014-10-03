import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientObject 
{
	 public String sendRecieveMessage () throws Exception
	 {
		 String returnedMessage = "";
		 messageClearing MC = new messageClearing();
		 BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			//Creates a similiar method to Scanner, which gets the input of the user, and saves it.
			DatagramSocket clientSocket = new DatagramSocket();
			//The datagramsocket lets you send and recieve packages via the chosen port. In this case, 9876.
			InetAddress IPAddress = InetAddress.getByName("localhost");
			//Gets the InetAddress, by the name localhost. This means that it gets my IP.
			System.out.println(IPAddress);
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[1024];
			//Creates 2 arrays, which are able to hold 1024 bytes, which contains package information
			String sentence = inFromUser.readLine();
			//Creates a string sentence, and sets it equals the input gotten from the bufferedreader
			sendData = sentence.getBytes();
			//Sets sendData equals the bytes of the userinput "Sentence"
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
			//Creates a new object of DatagramPacket sendPacket, containing "sendData", IPAddress and Port
			clientSocket.send(sendPacket);
			//Sends sendpacket via Datagramsocket
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			//Creates an object recievePacket of the type DatagramPacket which recieves data
			clientSocket.receive(receivePacket);
			//Recieve packet via socket
			String modifiedSentence = new String(receivePacket.getData());
			//Creates a new string which is equal the recieved Data. The data gets converted from bytes to something "Real"			
			System.out.println("FROM SERVER:");
			System.out.println(MC.clearMessage(modifiedSentence));
			//Prints out modifiedSentence
			clientSocket.close();
			//Close Socket
		 return returnedMessage;
	 }
}
