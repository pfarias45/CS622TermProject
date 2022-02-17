package resume;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class takes all resume sections and makes them into a resume obj with resume name as identifier
 */
public class Resume implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String resumeName;
	private Section contactSection;
	private Section summarySection;
	private ArrayList<Section> sortedExperienceSection;
	private ArrayList<Section> sortedEducationSection;
	private Section skillsSection;
	
	public Resume(String resumeName,Section contact, Section summary,
			ArrayList<Section> experiencesArr,ArrayList<Section> educationArr, Section skills) {
		this.resumeName = resumeName;
		contactSection = contact;
		summarySection = summary;
		skillsSection = skills;
		// ArrayLists for education and experience are sorted based on start date in descending order
		sortedExperienceSection = (ArrayList<Section>) experiencesArr.stream()
	            .sorted(Comparator.comparing(Section::getStartDate).reversed())
	            .collect(Collectors.toList());
		sortedEducationSection = (ArrayList<Section>) educationArr.stream()
	            .sorted(Comparator.comparing(Section::getStartDate).reversed())
	            .collect(Collectors.toList());
	}
	
	/**
	 * Desc: Method returns name of resume
	 * Param:
	 * Return: String resume name
	*/
	public String getResumeName() {
		return resumeName;
	}
	
	/**
	 * Desc: Method returns resume section
	 * Param: String resume name
	 * Return: Section obj
	*/
	public Section getContactSection(String resumeName) {
		return getSection(resumeName, contactSection);
	}
	
	/**
	 * Desc: Method returns resume section
	 * Param: String resume name
	 * Return: Section obj
	*/
	public Section getSummarySection(String resumeName) {
		return getSection(resumeName, summarySection);
	}
	
	/**
	 * Desc: Method returns resume section
	 * Param: String resume name
	 * Return: Section obj
	*/
	public ArrayList<Section> getSortedExpSection(String resumeName) {
		return getSection(resumeName, sortedExperienceSection);
	}
	
	/**
	 * Desc: Method returns resume section
	 * Param: String resume name
	 * Return: Section obj
	*/
	public ArrayList<Section> getSortedEduSection(String resumeName) {
		return getSection(resumeName, sortedEducationSection);
	}
	
	/**
	 * Desc: Method returns resume section
	 * Param: String resume name
	 * Return: Section obj
	*/
	public Section getSkillsection(String resumeName) {
		return getSection(resumeName, skillsSection);
	}
	

	/**
	 * Desc: Method returns requested section if given resume name matches that of the obj
	 * Param: String resume name, section obj
	 * Return: Section obj, null if no match
	*/
	public <T> T getSection(String resumeName, T section) {
		if(this.resumeName.equals(resumeName)) return section;
		else {
			System.out.println("Resume name is invalid.");
			return null;
		}
	}
	
	public String toString()
	   {
	      return "\nresume name = " + resumeName + "\n\nCONTACT\n" + contactSection + "\nSUMMARY\n" +  summarySection
	    		  + "\nEXPERIENCE\n" + sortedExperienceSection + "\n\nEDUCATION\n" + sortedEducationSection +
	    		  "\n\nSKILLS\n" + skillsSection;
	   }
	
	

}
