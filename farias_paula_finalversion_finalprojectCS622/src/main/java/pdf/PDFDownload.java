package pdf;

import resume.Resume;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class sets up thread to download PDF to user's folder
 */
public class PDFDownload implements Runnable {
	
	private Resume resume;
	
	public PDFDownload(Resume resume) {
		this.resume = resume;
	}
	
	@Override
	public void run() {
		 System.out.println("\nDownload in progress...");
		 String home = System.getProperty("user.home");
		 String dest = home + "/Downloads/" + resume.getResumeName() + ".pdf"; 
		 PDFGenerate.generatePDF(null, dest, resume);
		 System.out.println("\nAwesome! PDF was downloaded. Check your downloads folder.");	

	}
	
}
