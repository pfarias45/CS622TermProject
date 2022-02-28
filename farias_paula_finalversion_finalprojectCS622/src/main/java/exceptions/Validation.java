package exceptions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import run.ReadScript;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class validates user input
 */
public abstract class Validation extends ReadScript {

	/**
	 * Desc: Method validates email address
	 * Param: String email
	 * Return: Boolean if valid
	*/
	public static boolean validateEmail(String email) {
		try {	
			// pattern
			String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
					+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
			/*
			Restrictions for username:
				-Allows numeric values from 0 to 9
				-Allows uppercase and lowercase letters from a to z
				-Allows underscore “_”, hyphen “-” and dot “.”
				-Dot isn't allowed at the start and end of username
				-Consecutive dots aren't allowed
				-Maximum of 64 characters are allowed
			
			Restrictions for the domain:
				-Must be more than one char
				-Allows numeric values from 0 to 9
				-Allows uppercase and lowercase letters from a to z
				-Hyphen “-” and dot “.” isn't allowed at the start and end of domain
				-No consecutive dots
			*/
			// if email does not match pattern, throw exception
			if(!Pattern.compile(regexPattern).matcher(email).matches()) throw new InvalidEntryException(errorScript + "invalid email.");
			else return true;
		}
		catch (InvalidEntryException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Desc: Method validates arr size
	 * Param: String script, Arr List of input
	 * Return: Boolean if valid
	*/
	public static boolean validateArrSize(String script, ArrayList<String> inputList) {
		try {
			int numItems = 0;
			// set num of items in the input arr based on what's requested of user
			if(script.equals(titleEmpScript) || script.equals(adminScript3) || script.equals(contactScript) || script.equals(degSchoScript)) numItems = 2;
			else if(script.equals(summaryScript) || script.equals(dutiesScript) || script.equals(skillsScript)) numItems = 3;			
			
			// if num of items in arr does not match items requested, throw exception
			if(inputList.size()<numItems) throw new ArraySizeException(errorScript + "items entered are less than " + numItems + ".");
			else if(inputList.size()>numItems) throw new ArraySizeException(errorScript + "items entered are greater than " + numItems + ".");
			else return true;
		}
		catch (ArraySizeException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Desc: Method validates that string is a non-negative integer
	 * Param: String num
	 * Return: Boolean if valid
	*/
	public static boolean validateNum(String numString) {
		try {
			// check that it can be an int
			int num = Integer.parseInt(numString);  
			// if negative int, throw exception
			if(num <=0) throw new InvalidEntryException(errorScript + "invalid number. Do not enter 0 or negative numbers.");
			return true;
		}
		catch(NumberFormatException e) {
			System.out.println(errorScript + "invalid number. You did not enter an integer.");
			return false;
		}
		catch(InvalidEntryException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	
	/**
	 * Desc: Method validates that input matches pswd in admin obj
	 * Param: Admin user, String input
	 * Return: Boolean if valid
	*/
	public static boolean validatePswrd(String input) {
		try {
			if(input.equals("admin")) return true;
			else throw new InvalidEntryException(errorScript + "invalid password.");
		}
		
		catch(InvalidEntryException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Desc: Method validates date format
	 * Param: String input
	 * Return: Boolean if valid
	*/
	public static boolean validateDateFormat(String date) {
		try {
			date.trim();
			DateFormat datePattern = new SimpleDateFormat("yyyy-mm");
			datePattern.setLenient(false);
			datePattern.parse(date);
			return true;
		}
		catch (ParseException e) {
			System.out.println(errorScript + "invalid date format. Please input date as yyyy-mm.");
			return false;
		}	
	}
	
	/**
	 * Desc: Method validates month for date input
	 * Param: String input
	 * Return: Boolean if valid
	*/
	public static boolean validateDateMonth(String date) {
		try {
			date.trim();
			String[] dtArr = date.split("[-]");
			int mo = Integer.parseInt(dtArr[1]);
			if(mo > 12 || mo < 1) throw new InvalidEntryException(errorScript + "invalid month. Please input numbers from 01-12.");
			else return true;
		}
		catch (InvalidEntryException e) {
			System.out.println(e.getMessage());
			return false;	
		}
	}
	
	/**
	 * Desc: Method validates month for date input
	 * Param: String input
	 * Return: Boolean if valid
	*/
	public static boolean validateDateYear(String date) {
		try {
			date.trim();
			String[] dtArr = date.split("[-]");
			int yr = Integer.parseInt(dtArr[0]);
			int currentYr = Calendar.getInstance().get(Calendar.YEAR);
			if(yr > currentYr) throw new InvalidEntryException(errorScript + "invalid year. Please do not enter future years.");
			else return true;
		}
		catch (InvalidEntryException e) {
			System.out.println(e.getMessage());
			return false;	
		}	
	}

	
}