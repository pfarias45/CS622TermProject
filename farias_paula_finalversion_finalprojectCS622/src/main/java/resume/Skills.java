package resume;

import java.util.ArrayList;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class holds data for skills section
 * 
 * Heading: SKILLS
 * ContentList: Skills
 */

public class Skills extends Section {
	
	private static final long serialVersionUID = 1L;
	
	public Skills(ArrayList<String> skillsArr) {
		// use super class
		heading = "SKILLS";
		contentList = skillsArr;
	}

}
