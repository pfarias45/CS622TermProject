package resume.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import resume.*;

/**
 * Name: Paula Farias
 * Class: CS-622
 * Date: 2/1/2022
 * Desc: Class tests Section class
 */
public class SectionTest {

	/**
	 * Desc: Method tests that dates print correctly
	 */
	@Test
	public void testSetDates() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Title");
		arr.add("Employer");
		Experience e = new Experience(arr);
		e.setDates("2020-04", "na");
		assertEquals("Present", e.getEndDate());
	}
	
	/**
	 * Desc: Method tests that sub heading is formatted correctly
	 */
	@Test
	public void testSetSubheading1() {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Title");
		arr.add("Employer");
		Experience e = new Experience(arr);
		e.setDates("2020-04", "na");
		e.setSubheading1();
		assertEquals("Title, 2020-04 to Present", e.getSubheading1());
	}

}
