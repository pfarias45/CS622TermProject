package pdf;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import resume.*;
import java.io.*;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class generates PDF document
 */
public abstract class PDFGenerate extends PDFSetUp {

	/**
	 * Desc: Method generates PDF document
	 * Param: Resume obj, OutputStream (if thread is for email), String destination (if thread is for download)
	 * Return:
	*/
	public static synchronized void generatePDF(OutputStream os, String dest, Resume resume) {
		try {
			PdfWriter pdfWriter;
			if(os != null) pdfWriter = new PdfWriter(os);
			else pdfWriter = new PdfWriter(dest);	
			PdfDocument pdf = new PdfDocument(pdfWriter);
			Document doc = new Document(pdf);
			createResume(doc, resume);
			doc.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("\nPDF not downloaded.");
			e.printStackTrace();
		}
		
	}
}
	