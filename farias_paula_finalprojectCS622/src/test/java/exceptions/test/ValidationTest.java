package exceptions.test;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

import accounts.Account;
import accounts.Admin;
import exceptions.*;
import run.ReadScript;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class tests Validation class
 */
public class ValidationTest extends ReadScript {

	/**
	 * Desc: Method tests email validation
	 */
	@Test
	public void testValidateEmail() {
		String email1 = "username@.com";
		boolean validation1 = Validation.validateEmail(email1);
		String email2 = "@domain.com";
		boolean validation2 = Validation.validateEmail(email2);
		String email3 = "username@domain";
		boolean validation3 = Validation.validateEmail(email3);	
		String email4 = "username@domain.com";
		boolean validation4 = Validation.validateEmail(email4);
		
		assertEquals("false", String.valueOf(validation1));
		assertEquals("false", String.valueOf(validation2));
		assertEquals("false", String.valueOf(validation3));
		assertEquals("true", String.valueOf(validation4));
	}

	/**
	 * Desc: Method tests arr validation
	 */
	@Test
	public void testValidateArrSize() {
		ReadScript.readFile();
		
		ArrayList<String> input1 = new ArrayList<>(Arrays.asList("a"));
		ArrayList<String> input2 = new ArrayList<>(Arrays.asList("a", "b"));
		ArrayList<String> input3 = new ArrayList<>(Arrays.asList("a", "b", "c"));
		
		boolean validation1 = Validation.validateArrSize(contactScript, input1);
		boolean validation2 = Validation.validateArrSize(contactScript, input2);
		boolean validation3 = Validation.validateArrSize(dutiesScript,input2);
		boolean validation4 = Validation.validateArrSize(dutiesScript,input3);
		
		assertEquals("false", String.valueOf(validation1));
		assertEquals("true", String.valueOf(validation2));
		assertEquals("false", String.valueOf(validation3));
		assertEquals("true", String.valueOf(validation4));
		
	}

	/**
	 * Desc: Method tests num validation
	 */
	@Test
	public void testValidateNum() {
		String num1 = "-1";
		String num2 = "a";
		String num3 = "2";
		
		boolean validation1 = Validation.validateNum(num1);
		boolean validation2 = Validation.validateNum(num2);
		boolean validation3 = Validation.validateNum(num3);
		
		assertEquals("false", String.valueOf(validation1));
		assertEquals("false", String.valueOf(validation2));
		assertEquals("true", String.valueOf(validation3));
	}
	
	/**
	 * Desc: Method tests validation for YN and E, D, B
	 */
	@Test
	public void testValidateYN() {
		String input1 = "Y";
		String input2 = "N";
		String input3 = "a";
		String input4 = "1";
		
		boolean validation1 = Validation.validateYN(input1);
		boolean validation2 = Validation.validateYN(input2);
		boolean validation3 = Validation.validateYN(input3);
		boolean validation4 = Validation.validateYN(input4);
		
		assertEquals("true", String.valueOf(validation1));
		assertEquals("true", String.valueOf(validation2));
		assertEquals("false", String.valueOf(validation3));
		assertEquals("false", String.valueOf(validation4));		
	
	}
	
	/**
	 * Desc: Method tests pswd validation
	 */
	@Test
	public void testValidatePswrd() {
		
		Account<Admin> admin = new Account<Admin>(new Admin());
		
		String input1 = "admin";
		String input2 = "a";
		String input3 = "1";
		
		boolean validation1 = Validation.validatePswrd(admin, input1);
		boolean validation2 = Validation.validatePswrd(admin, input2);
		boolean validation3 = Validation.validatePswrd(admin, input3);
		
		assertEquals("true", String.valueOf(validation1));
		assertEquals("false", String.valueOf(validation2));
		assertEquals("false", String.valueOf(validation3));		
	
	}
	
	/**
	 * Desc: Method tests date validation
	*/
	@Test
	public void testValidateDateFormat() {
		
		String input1 = "2020-02";
		String input2 = "02-2020";
		String input3 = "2020/02";
		String input4 = "2020/2";
		
		boolean validation1 = Validation.validateDateFormat(input1);
		boolean validation2 = Validation.validateDateFormat(input2);
		boolean validation3 = Validation.validateDateFormat(input3);
		boolean validation4 = Validation.validateDateFormat(input4);
		
		
		assertEquals("true", String.valueOf(validation1));
		assertEquals("false", String.valueOf(validation2));
		assertEquals("false", String.valueOf(validation3));		
		assertEquals("false", String.valueOf(validation4));		
	}
	
	/**
	 * Desc: Method tests date validation
	*/
	@Test
	public void testValidateDateMonth() {
		
		String input1 = "2020-02";
		String input2 = "2020-13";
		String input3 = "2020-0";
		
		boolean validation1 = Validation.validateDateMonth(input1);
		boolean validation2 = Validation.validateDateMonth(input2);
		boolean validation3 = Validation.validateDateMonth(input3);
		
		
		assertEquals("true", String.valueOf(validation1));
		assertEquals("false", String.valueOf(validation2));
		assertEquals("false", String.valueOf(validation3));	
		
	}
	
	/**
	 * Desc: Method tests date validation
	*/
	@Test
	public void testValidateDateYear() {
		
		String input1 = "2020-02";
		String input2 = "2006-12";
		String input3 = "3000-10";
		
		boolean validation1 = Validation.validateDateYear(input1);
		boolean validation2 = Validation.validateDateYear(input2);
		boolean validation3 = Validation.validateDateYear(input3);
			
		assertEquals("true", String.valueOf(validation1));
		assertEquals("true", String.valueOf(validation2));
		assertEquals("false", String.valueOf(validation3));	
	
	}
	
	/**
	 * Desc: Method tests E, B, D for PDF
	*/
	@Test
	public void validatePDFPath() {
		
		String input1 = "E";
		String input2 = "e";
		String input3 = "A";
		
		boolean validation1 = Validation.validatePDFPath(input1);
		boolean validation2 = Validation.validatePDFPath(input2);
		boolean validation3 = Validation.validatePDFPath(input3);
		
		assertEquals("true", String.valueOf(validation1));
		assertEquals("true", String.valueOf(validation2));
		assertEquals("false", String.valueOf(validation3));	
		
	}
	
}
