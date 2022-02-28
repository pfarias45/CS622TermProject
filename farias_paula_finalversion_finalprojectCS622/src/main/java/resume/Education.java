package resume;

import java.util.ArrayList;


/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class holds data for education section of resume
 * 
 * Heading: EDUCATION
 * Subheading1: Degree, Start - End
 * Subheading2: School
 */

public class Education extends Section {
	
	private static final long serialVersionUID = 1L;
	
	private String degree;
	
	public Education(ArrayList<String> degSchoArr) {
		// use super class	
		heading = "EDUCATION";
		degree = degSchoArr.get(0);
		subheading2  =  degSchoArr.get(1); // school
	}
	
	/**
	 * Desc: Method returns degree for education
	 * Param:
	 * Return: String degree name
	*/
	public String getDegree() {
		return degree;
	}

}

