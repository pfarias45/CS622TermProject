package resume;

import java.util.ArrayList;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class holds data for experience section of resume
 * 
 * Heading: EXPERIENCE
 * Subheading1: Title, Start - End
 * Subheading2: Employer
 * ContentList: Duties
 */

public class Experience extends Section {
	
	private static final long serialVersionUID = 1L;
	
	private String title;
	
	public Experience(ArrayList<String> titleEmpArr) {
		// use super class	
		heading = "EXPERIENCE";
		title =  titleEmpArr.get(0);
		subheading2  =  titleEmpArr.get(1); // employer
	}
	
	/**
	 * Desc: Method returns title for experience
	 * Param:
	 * Return: String position title
	 */
	public String getTitle() {
		return title;
	}
	
}

