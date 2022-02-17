package resume;

import java.util.ArrayList;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class holds data for contact section of resume
 * 
 * Heading: CONTACT
 * Subheading1: Name | Email
 */

public class Contact extends Section {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	
	public Contact(ArrayList<String> contactArr) {
		// use super class
		heading = "CONTACT";
		name = contactArr.get(0);
		email = contactArr.get(1);
		subheading1 = name + " | " + email;
	}
	
	/**
	 * Desc: Method returns user's email
	 * Param:
	 * Return: String user's email
	*/
	public String getEmail() {
		return email;
	}

}
