package pdf;

import java.util.ArrayList;

import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Text;

import resume.*;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class adds content to PDF based on style specified in PDF Format class
 */
public abstract class PDFSetUp extends PDFFormat {
	
	private static Document doc;
	private static Resume res;
	
	/**
	 * Desc: Method sets data for for the PDF doc and resume content variables
	 * Param: PDF doc from PDFGenerate class
	 * Return: 
	*/ 
	public static void createResume(Document document, Resume resume) {
		doc = document;
		res = resume;
		addAllSections();
	}
	
	
	/**
	 * Desc: Method adds all sections of resume to doc using specific section methods
	 * Param: 
	 * Return: 
	*/ 
	public static void addAllSections() {
		 // get resume specifics
		 String resumeName = res.getResumeName();

		 // create sections
		 createContactSection(res.getContactSection(resumeName));
		 createSumSkillsSection(res.getSummarySection(resumeName));
		 createExpEdSection(res.getSortedExpSection(resumeName));
		 createExpEdSection(res.getSortedEduSection(resumeName));
		 createSumSkillsSection(res.getSkillsection(resumeName));
	}
	
	/**
	 * Desc: Method creates formatted section
	 * Param: Section obj
	 * Return: 
	*/ 
	public static void createContactSection(Section s) {
		 addHeading(s);
		 addSubheading1(s);
	}
	
	/**
	 * Desc: Method creates formatted section
	 * Param: Section obj
	 * Return: 
	*/ 
	public static void createSumSkillsSection(Section s) {
		 addHeading(s);
		 addContentList(s);
	}
	
	/**
	 * Desc: Method creates formatted section
	 * Param: Section obj
	 * Return: 
	*/ 
	public static void createExpEdSection(ArrayList<Section> sArr) {
		 addHeading(sArr.get(0));
		 sArr.forEach((s) -> {
			 addSubheading1(s);
			 addSubheading2(s);
			 if(s.getHeading().equals("EXPERIENCE")) addContentList(s);
		 });	 
	}
	
	/**
	 * Desc: Method adds heading
	 * Param: Section obj
	 * Return: 
	*/ 
	public static void addHeading(Section s) {
		Text heading = formatHeading("heading", s.getHeading());
		doc.add(new Paragraph(heading));
		doc.add(addSeparator());
		doc.add(new Paragraph(""));
	}
	
	/**
	 * Desc: Method adds sub heading 1
	 * Param: Section obj
	 * Return: 
	*/ 
	public static void addSubheading1(Section s) {
		Text subheading1 = formatHeading("subheading1", s.getSubheading1());
		doc.add(new Paragraph(subheading1));
	}
	
	/**
	 * Desc: Method adds sub heading 2
	 * Param: Section obj
	 * Return: 
	*/ 
	public static void addSubheading2(Section s) {
		Text subheading2 = formatHeading("subheading2", s.getSubheading2());
		doc.add(new Paragraph(subheading2));
	}
	
	/**
	 * Desc: Method adds content list
	 * Param: Section obj
	 * Return: 
	*/ 
	public static void addContentList(Section s) {
		List contentList = formatList(s.getContentList());
		doc.add(contentList);
	}

}