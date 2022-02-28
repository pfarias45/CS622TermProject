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
			
			// create instance of userInput to ask/return user input
			AskInput userInput= new AskInput(reader);
		
			// account check
			String isAdmin = userInput.askPath(acctCheckScript);
			
			// if admin
			if(isAdmin.equals("1")) {
				
				// check password
				userInput.askPswd();
				
				// ask for path
				String adminPath = userInput.askPath(adminScript);
				
				// do dmin task
				if(adminPath.equals("1")) SearchDatabase.listResumeCount();
				else if (adminPath.equals("2")) SearchDatabase.listUsers();
				else if(adminPath.equals("3")) {
					String username = userInput.askItem(adminScript2);
					SearchDatabase.listResumeNames(username);
				}
				else if (adminPath.equals("4")) {
					ArrayList<String> searchArr = userInput.askContentArr(adminScript3);
					String username = searchArr.get(0);
					String resumeName = searchArr.get(1);
					SearchDatabase.listResumeContent(username, resumeName);
				}
				
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

				// create resume obj
				Resume resume = new Resume(contact, summary, experiencesArr, educationArr, skills);
				
				// create user obj if needed
				String username = ((Contact)contact).getEmail();
				Thread createUser = new Thread(new User(username));
				createUser.start();
				
				// set time of log in
				ManipulateDatabase.updateLoginDate(username);
				
				// ask and add resume name, must be unique to user 
				String resumeName = userInput.askRName(rNameScript, username);
				
				// add to user object, set resume name
				resume.setResumeName(resumeName);
				
				// update database with new resume
				ManipulateDatabase.updateResumesTable(resume);
				
				// Email, download or both 
				String pdfPath = userInput.askPath(pdfPathScript);
				
				// generate threads
				Thread pdfDownload = new Thread(new PDFDownload(resume));
				Thread pdfEmail = new Thread(new PDFEmail(resume, username));
				
				// start threads accordingly
				if(pdfPath.equals("1")) pdfEmail.start();
				else if(pdfPath.equals("2")) pdfDownload.start();
				else if(pdfPath.equals("3")) {
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



