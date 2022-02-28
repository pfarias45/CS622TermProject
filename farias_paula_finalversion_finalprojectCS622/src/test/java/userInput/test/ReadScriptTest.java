package userInput.test;

import static org.junit.Assert.*;

import org.junit.Test;

import run.ReadScript;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class tests ReadScript class
 */
public class ReadScriptTest extends ReadScript {

	String s = "\nWelcome to ResumeBuilder! If admin, enter Y. Otherwise, enter N to begin creating your resume:\n";
	
	/**
	 * Desc: Method tests whether the file is being read correctly
	 */
	@Test
	public void testReadFile() {
		ReadScript.readFile();
		assertEquals(s, acctCheckScript);
	}

}
