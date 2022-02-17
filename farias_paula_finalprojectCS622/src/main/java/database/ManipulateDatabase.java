package database;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import accounts.*;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class makes changes to database (JSON file)
 */
public abstract class ManipulateDatabase {
	
	/**
	 * Desc: Method saves most recent user data
	 * Param: User acct
	 * Return: 
	*/
	public static void updateDatabase(Account<User> newUser) {
		
		  try (ObjectOutputStream outfile = new ObjectOutputStream(new 
	                FileOutputStream("Data.dat"));){
		      outfile.writeObject(newUser);
		      outfile.close();
		 }
		  catch (FileNotFoundException ex)
	     {
	         System.out.println("FileNotFoundException"); 
	         ex.printStackTrace();   
	     }

	     catch (IOException ex)
	     {
	         System.out.println("IOException");
	         ex.printStackTrace();    
	     }    
	}
		

		
		
	/**
	 * Desc: Method accesses most recent user data. Protected so that only subclasses can access (i.e. admin class)
	 * Param: 
	 * Return: 
	*/
	protected static void accessDatabase() {
		
		try(ObjectInputStream infile = new ObjectInputStream(new 
                FileInputStream("Data.dat"));)  {
			
			while(true){
				System.out.println(infile.readObject());
				    } 	
			}
		
		catch (EOFException e){
	    }
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
			
	}


}
	