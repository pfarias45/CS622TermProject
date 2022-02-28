package resume;

import java.io.Serializable;
import java.time.YearMonth;
import java.util.*;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class sets basic blueprint for resume sections
 */
public abstract class Section implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// main parts of each section
	protected String heading;
	protected String subheading1;
	protected String subheading2;
	// start date is a Date type because it will be used for sorting
	protected YearMonth startDate;
	protected String endDate;
	protected ArrayList<String> contentList;
	
	/**
	 * Desc: Method returns section heading
	 * Param: 
	 * Return: String heading
	*/
	public String getHeading() {
		return heading;
	}
	
	/**
	 * Desc: Method returns section sub heading 1
	 * Param: 
	 * Return: String sub heading 1
	*/
	public String getSubheading1() {
		return subheading1;
	}
	
	/**
	 * Desc: Method returns section sub heading 2
	 * Param: 
	 * Return: String sub heading 2
	*/
	public String getSubheading2() {
		return subheading2;
	}

	/**
	 * Desc: Method returns start date (education, experience)
	 * Param: 
	 * Return: String start date
	*/
	public YearMonth getStartDate() {
		return startDate;
	}
	
	/**
	 * Desc: Method returns end date (education, experience)
	 * Param: 
	 * Return: String end date
	*/
	public String getEndDate() {
		return endDate;
	}
	
	/**
	 * Desc: Method returns list of contents (summary, experience, skills)
	 * Param: 
	 * Return: String list of contents
	*/
	public ArrayList<String> getContentList() {
		return contentList;
	}
	
	/**
	 * Desc: Method sets list of contents (summary, experience, skills)
	 * Param: Content arr
	 * Return: 
	*/
	public void setContentList(ArrayList<String> contentArr) {
		contentList = contentArr;
	}
	
	/**
	 * Desc: Method sets date (education, experience)
	 * Param: String start, string end dates
	 * Return:
	*/
	public void setDates(String start, String end) {
		startDate = YearMonth.parse(start);
		// set end as present if currently employed
		if(end.toUpperCase().equals("NA")) endDate = "Present"; 
		else endDate = end;
	}
	
	/**
	 * Desc: Method sets value for sub heading 1 (education, experience) since dates are obtained after obj is created
	 * Param: 
	 * Return:
	*/ 
	public void setSubheading1() {
		if(this.heading.equals("EXPERIENCE")) subheading1 = ((Experience)this).getTitle() + ", " + startDate + " to " + endDate;
		if(this.heading.equals("EDUCATION")) subheading1 = ((Education)this).getDegree() + ", " + startDate + " to " + endDate;
	}
	
	public String toString()
	   {
	      return heading + "\nsubheading1 = " + subheading1 + "\nsubheading2 = " + subheading2 +
	    		  "\ncontentList= " + contentList + "\n";
	   }

}
