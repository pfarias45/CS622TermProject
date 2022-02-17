package userInput.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;

import run.*;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class tests AskInput class
 */
public class AskInputTest extends ReadScript {

	Scanner testReader = new Scanner(System.in);
	AskInput testAsk = new AskInput(testReader);
	
	/**
	 * Desc: Method tests whether the input is split correctly
	 */
	@Test
	public void testSplitInput() {
		String input = "Sample 1. Sample 2. . Sample 3. ";
		ArrayList<String> inputArr = testAsk.splitInput(input, summaryScript);
		assertEquals(3, inputArr.size());
	}

}