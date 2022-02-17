package run;

import java.util.*;

import accounts.*;
import database.*;
import pdf.*;
import resume.*;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class runs program through main method
 */

public class Main extends ReadScript {

	/**
	 * Desc: Method runs program
	 * Param: String arr of args
	 * Return: 
	*/
	public static void main(String[] args) { 
		try {
			
			// create scanner obj
			Scanner reader = new Scanner(System.in);
			
			// create admin obj
			Account<Admin> adminAcct = new Account<Admin>(new Admin());
			
			// create instance of userInput to ask/return user input
			AskInput userInput= new AskInput(reader);
		
			// account check
			String isAdmin = userInput.askAcct();
			
			// if admin, print out list of users
			if(isAdmin.equals("Y")) {
				userInput.doAdminTask(adminAcct);
			}
			
			// if not admin, proceed to create resume
			else {
			
				// welcome user
				userInput.printOverview();
				
				// ask user for contact and create section obj
				ArrayList<String> contactArr = userInput.askContentArr(contactScript);
				Section contact = new Contact(contactArr);
			
				// ask user for summary and create section obj
				ArrayList<String> summaryArr = userInput.askContentArr(summaryScript);
				Section summary = new Summary(summaryArr);
			
				// ask user about each experience and create arr of sect objs
				ArrayList<Section> experiencesArr = userInput.askObjArr("Experience");
				
				// ask user about each education and create arr of sect objs
				ArrayList<Section> educationArr = userInput.askObjArr("Education");
				
				// ask user for skills and create section obj
				ArrayList<String> skillsArr = userInput.askContentArr(skillsScript);
				Section skills = new Skills(skillsArr);

				// ask resume name
				String resumeName = userInput.askResumeName(rNameScript);
				
				// create resume obj
				Resume resume = new Resume(resumeName, contact, summary, experiencesArr, educationArr, skills);
				
				// create user obj
				String username = ((Contact)contact).getEmail();
				Account<User> user = new Account<User>(new User(username, resume));
				
				// save user in .dat file
				ManipulateDatabase.updateDatabase(user);
			
				// Email, download or both 
				String pdfPath = userInput.askPDFPath(pdfPathScript);
				
				// generate threads
				Thread pdfDownload = new Thread(new PDFDownload(resume));
				Thread pdfEmail = new Thread(new PDFEmail(resume, username));
				
				// start threads accordingly
				if(pdfPath.equals("E")) pdfEmail.start();
				if(pdfPath.equals("D")) pdfDownload.start();
				if(pdfPath.equals("B")) {
					pdfEmail.start();
					pdfDownload.start();
				}
			}
	
			// close scanner
			reader.close();
		}
		catch(Exception e) {
	         e.printStackTrace();
	    }
	}

	
}



