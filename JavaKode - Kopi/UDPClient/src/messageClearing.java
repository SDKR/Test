
public class messageClearing {
	public String clearMessage (String message)
	{
		message.length();
		String clearedMessage = "";
		
		String character = message;
		char c = character.charAt(0);
		 
		if (Character.isLetter(c)) { 
			clearedMessage += character;
		   
		} else {
		    
		}
		
		return clearedMessage;
	}

}
