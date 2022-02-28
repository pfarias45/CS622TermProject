package exceptions;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class creates instance of exception for invalid array
 */
public class ArraySizeException extends Exception {

	private static final long serialVersionUID = 1L;

	public ArraySizeException (String str)  
    {   
    	super(str);  
    }  
}
