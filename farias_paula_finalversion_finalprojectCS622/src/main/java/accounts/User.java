package accounts;

import database.ManipulateDatabase;
import database.SearchDatabase;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class stores data for user acct
 */
public class User implements Runnable {

	private String username;

	public User(String username) {
		this.username = username;

	}
		
	@Override
	public void run() {
		createUser(username);
	}
	
	/**
	 * Desc: Method returns username
	 * Param:
	 * Return: String username
	*/
	public String getUsername() {
		return username;
	}

	/**
	 * Desc: Method creates user if it is not in database
	 * Param: String username
	 * Return: 
	*/
	public static void createUser(String username) {
		if(!SearchDatabase.findUser(username)) {
			User user = new User(username);
			// ask settings and set settings
			// update database with new user
			ManipulateDatabase.updateUsersTable(user);
		}
	}
	
}

