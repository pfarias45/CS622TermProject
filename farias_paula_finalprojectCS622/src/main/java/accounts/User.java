package accounts;

import java.io.Serializable;

import resume.Resume;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class stores data for user acct
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private Resume resume;
	
	public User(String username, Resume resume) {
		this.username = username;
		this.resume = resume;
	}
	
	
	/**
	 * Desc: Method gets resume
	 * Param: 
	 * Return: Resume obj
	*/
	public Resume getResume() {
		return resume;
	}
	
	public String toString()
	   {
	      return "\nusername = " + username + resume;
	   }

	
}
