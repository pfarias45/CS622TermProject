package exceptions;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class creates instance of exception for invalid entry
 */
public class InvalidEntryException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidEntryException (String str)  
	{   
		super(str);  
	}  
}

