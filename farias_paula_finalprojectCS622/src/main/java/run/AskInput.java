package run;

import java.util.*;

import accounts.*;
import exceptions.*;
import resume.*;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class asks for and returns user input
 */
public class AskInput extends ReadScript {
	
	private Scanner inputReader; 
	
	public AskInput(Scanner reader) {
		inputReader = reader;
		readFile();
	};
	
	/**
	 * Desc: Method asks if user is admin
	 * Param:
	 * Return: String input
	*/
	public String askAcct() {
		boolean validInput;
		String input;
		// do while input is not valid
		do {
			System.out.println(acctCheckScript);
			input = inputReader.nextLine().toUpperCase();
			validInput = Validation.validateYN(input);
		}
		while(validInput != true);
		return input;
	}
	
	/**
	 * Desc: Method asks for admin pswd and performs admin task once pswd is valid
	 * Param: Admin acct
	 * Return:
	*/
	public void doAdminTask(Account<Admin> user) {
		boolean validPswrd;
		String input;
		do {
			System.out.println(passwordScript);
			input = inputReader.nextLine();
			validPswrd = Validation.validatePswrd(user, input);
		}
		while(validPswrd != true);			
		user.getAccount().printUsernames();
	}
	
	/**
	 * Desc: Method prints overview of app to console
	 * Param: 
	 * Return:
	*/
	public void printOverview() {
		System.out.println(overviewScript);
	}
	
	/**
	 * Desc: Method asks user for resume content (contact, summary, title/employer, duties, program/school, skills)
	 * Param: String script
	 * Return: Arr List of input
	*/
	public ArrayList<String> askContentArr(String script) {
		boolean validArr;
		boolean validEmail = true;
		ArrayList<String> inputList;
		// do while input is not valid
		do {
			System.out.println(script);
			String input = inputReader.nextLine();
			// split input into arr
			inputList = splitInput(input, script);
			// check if validArr is valid, returns false if not
			validArr = Validation.validateArrSize(script, inputList);
			// if arr valid on contact section, check email|, return false if email not valid
			if(validArr && script.equals(contactScript)) validEmail = Validation.validateEmail(inputList.get(1));
		}
		while(validArr != true || validEmail != true);
		// return valid arr
		return inputList;	
	}
	
	/**
	 * Desc: Method asks for number of items (position, skills, education) to loop through
	 * Param: String section name
	 * Return: Int num
	*/
	public int askNum(String sectionName) {
		boolean validNum;
		String numString;
		// do while input is not valid
		do {
			System.out.println(numScript + sectionName + ":\n");
			numString = inputReader.nextLine();
			// check if numString is a valid non-negative int
			validNum = Validation.validateNum(numString);
		}
		while(validNum != true);
		int num = Integer.parseInt(numString);
		return num;
	}
	
	/**
	 * Desc: Method asks for for start and end dates of (education, experience)
	 * Param: String section name, String script
	 * Return: String date
	*/
	public String askDate(Section section, String script) {
		boolean validFormat;
		boolean validMonth = false;
		boolean validYear =false;
		String date;
		do {
			System.out.println(script + section.getSubheading2() + ":\n");
			date = inputReader.nextLine();
			if(date.toUpperCase().equals("NA")) {
				validFormat = true;
				validMonth = true;
				validYear = true;
			}
			
			else {
				validFormat = Validation.validateDateFormat(date);
				if (validFormat == true) {
					validMonth = Validation.validateDateMonth(date);
					validYear = Validation.validateDateYear(date);
				}
			}
		}
		while(validFormat != true || validMonth != true || validYear != true);
		return date;
	}
	
	
	/**
	 * Desc: Method asks for all instances (education, experience)
	 * Param: String section name
	 * Return: Arr List of section objs
	*/
	public ArrayList<Section> askObjArr(String sectionName) {
		
		// get num to loop through
		int num = askNum(sectionName);
	
		// counter for loop
		int counter = 0;
		
		// create multi obj arr to save all obj for that section
		ArrayList<Section> objArr = new ArrayList<Section>();

		// ask the same questions about each instance
		while(counter < num) {
			
			counter ++;
			System.out.println("\n" + sectionName + " number " + counter);
			
			// ask details needed to construct section obj
			ArrayList<String> arr = new ArrayList<String>();
			
			// section obj
			Section obj;
			
			// assign correct script based on section name and create section obj
			if(sectionName.equals("Experience")) {
				arr = askContentArr(titleEmpScript);
				obj = new Experience(arr);
			}
			else {
				arr = askContentArr(degSchoScript);
				obj = new Education(arr);
			}
			
			// ask and set dates
			String startDate = askDate(obj, startScript);
			String endDate = askDate(obj, endScript);
			obj.setDates(startDate, endDate);
			
			// set sub heading
			obj.setSubheading1();
			
			// ask for duties if experience
			if(sectionName.equals("Experience")) {
				ArrayList<String> dutiesArr = askContentArr(dutiesScript);
				obj.setContentList(dutiesArr);
			}
			
			// add to obj arr
			objArr.add(obj);
		
		}
		
		// return all instances
		return objArr;
		
	}

	/**
	 * Desc: Method asks user for resume name
	 * Param: String script
	 * Return: String input
	*/
	public String askResumeName(String script) {
		System.out.println(script);
		String input = inputReader.nextLine();
		return input;
	}

	/**
	 * Desc: Method asks user whether they want to email, download or both for PDF
	 * Param: String script
	 * Return: String input
	*/
	public String askPDFPath(String script) {
		boolean validInput;
		String input;
		do {
			System.out.println(script);
			input = inputReader.nextLine();
			validInput = Validation.validatePDFPath(input);
		}
		while(validInput != true);
		return input;
	}
	
	
	/**
	 * Desc: Method splits user input into string array based on specified delimiter
	 * Param: String input, string script
	 * Return: Arr List of input
	*/
	public ArrayList<String> splitInput(String input, String script) {
		
		// determine delimiter based on script printed to console
		String delimiter = "";
		if(script.equals(titleEmpScript) || script.equals(contactScript) ||  script.equals(degSchoScript)) delimiter = "[,]";
		if(script.equals(summaryScript) || script.equals(dutiesScript)  || script.equals(skillsScript)) delimiter = "[.]";
		String[] stArr = input.split(delimiter);
		
		// create arr list from str arr of input
		ArrayList<String> inputList = new ArrayList<String>();
		for(String s: stArr) {
			// trim
			String s1 = s.trim();
			// only add if it's not a blank space
			if(!s1.equals("")) inputList.add(s1);
		}
		return inputList; 
	}


}








