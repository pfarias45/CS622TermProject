package resume;

import java.util.ArrayList;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class holds data for summary section of resume
 * 
 * Heading: SUMAMRY
 * ContentList: Sentences
 */

public class Summary extends Section {
	
	private static final long serialVersionUID = 1L;
	
	public Summary(ArrayList<String> summaryArr) {
		// use super class
		heading = "SUMMARY";
		contentList = summaryArr;
	}

}
