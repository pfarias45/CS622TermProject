package run;

import org.json.simple.*;
import org.json.simple.parser.*;
import java.io.FileReader;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class reads and stores script data from JSON file
 */
public abstract class ReadScript {
	
	// scripts
	protected static String overviewScript;
	protected static String contactScript;
	protected static String summaryScript;
	protected static String numScript;
	protected static String titleEmpScript;
	protected static String dutiesScript;
	protected static String startScript;
	protected static String endScript;
	protected static String errorScript;
	protected static String degSchoScript;
	protected static String rNameScript;
	protected static String acctCheckScript;
	protected static String adminMeunScript;
	protected static String passwordScript;
	protected static String pdfPathScript;
	protected static String skillsScript;
	
	/**
	 * Desc: Method reads JSON file
	 * Param: String arr of args
	 * Return: 
	*/
	public static void readFile() {
		try {
			
			// create JSON object
			JSONParser parser = new JSONParser();
			FileReader file = new FileReader("RBScript.json");
			Object script = parser.parse(file);
			JSONObject askReader = (JSONObject)script;

			// convert JSON items to string
			overviewScript = (String)askReader.get("OverviewScript");
			contactScript = (String)askReader.get("ContactScript");
			summaryScript = (String)askReader.get("SummaryScript");
			numScript = (String)askReader.get("NumScript");
			titleEmpScript = (String)askReader.get("TitleEmpScript");
			dutiesScript = (String)askReader.get("DutiesScript");
			startScript = (String)askReader.get("StartScript");
			endScript = (String)askReader.get("EndScript");
			errorScript = (String)askReader.get("ErrorScript");
			rNameScript = (String)askReader.get("RNameScript");
			degSchoScript = (String)askReader.get("DegSchoScript");
			acctCheckScript = (String)askReader.get("AcctCheckScript"); 
			adminMeunScript= (String)askReader.get("AdminMenuScript"); 
			passwordScript = (String)askReader.get("PasswordScript");
			pdfPathScript = (String)askReader.get("PDFPathScript");
			skillsScript = (String)askReader.get("SkillsScript");
					
			// close file
			file.close();
		}
		catch(Exception e) {
	         e.printStackTrace();
	    }
	}


}