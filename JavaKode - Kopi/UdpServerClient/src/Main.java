import java.io.*; 
import java.net.*;
//Imports every methods from Java.net, and Java.io. I guess the methods used below, comes from here.
public class Main {

	public static void main(String[] args) throws Exception
	//Creates main method, and surronding it with an exception
	{
		DatagramSocket serverSocket = new DatagramSocket(9876);
		//The datagramsocket lets you send and recieve packages via the chosen port. In this case, 9876.
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		//Creates 2 arrays, which are able to hold 1024 bytes, which contains package information
		while(true)
		//While something returns true:
		{
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			//Creates an object of the method Datagram packet, which checks if the packet is recieved correctly.
			serverSocket.receive(receivePacket);
			//Methods checks if the serversocket recieves the packages krav fra recievePacket.
			String sentence = new String( receivePacket. getData());
			//Creates a string which contains the data contained by the package
			System.out.println("RECEIVED: " + sentence);
			//Prints "Recieved and sentence containing data conserning the package
			InetAddress IPAddress = receivePacket.getAddress();
			//Creates a method which gets the IPaddress of the package recieved!!!
			int port = receivePacket.getPort();
			//Creates an Int which contains the port to which the package is sent
			String capitalizedSentence = sentence.toUpperCase();
			//Creates a string which gets the sentence and capatalize sentence
			sendData = capitalizedSentence.getBytes(); 
			//Sets "sendData" to the capitalizedSentence which has been converted to bytes.
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			//Sends a packet containing sendData (Bytes), gets the length of the bytes, and sends it to IPAddress via "port"
			serverSocket.send(sendPacket);
			//Sends the final package via serversocket "sendPacket".
			
		}
	}
}
