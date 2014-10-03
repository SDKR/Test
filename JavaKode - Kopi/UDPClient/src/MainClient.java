import java.io.*; 
import java.net.*;
import java.util.Scanner;

public class MainClient {

	public static void main(String[] args)throws Exception
	{
		ClientObject CO = new ClientObject();
		Scanner scannerInput = new Scanner(System.in);
		
		System.out.println("Hello and welcome to your personal UDP messenger!");
		int counter = 1;
		System.out.println("Press 1 to send a message, press 2 to exit");
		counter = scannerInput.nextInt();
		while (counter == 1)
		{			
			CO.sendRecieveMessage();
			System.out.println("Press 1 to send a message, press 2 to exit");	
			counter = scannerInput.nextInt();
		}
		System.out.println("Goodbye!");
		scannerInput.close();
		
	}
}
