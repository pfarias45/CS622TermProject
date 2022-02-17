package accounts;

import database.*;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class stores data for admin acct
 */
public class Admin extends ManipulateDatabase {

	private static final String pswd = "admin";
	
	public Admin() {
	}
	
	public String getPswd() {
		return pswd;
	}
	
	/**
	 * Desc: Method prints usernames found in database (.dat file)
	 * Param: 
	 * Return: 
	*/
	public void printUsernames() {
		accessDatabase();
	}
}
		
		
	