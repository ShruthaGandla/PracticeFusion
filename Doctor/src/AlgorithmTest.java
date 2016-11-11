import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
/*
 What the program does: When a user enters the doctor's name the algorithm lists 
 Top 10 similar Doctors.
 Assumptions:
 1.Two Doctors are considered to be similar if their specialty is same.
 2.All the similar doctors are displayed in descending order based on their
  review score.This is how the list is prioritized
  
  Final Thoughts:If I had more time I would like to consider a different way
  to prioritize the doctors,may be add another attribute say zip-code to the doctor object and see if I
  can prioritize based on the location attribute too...
 
  */

public class AlgorithmTest {

	@Test
	/*
	 * Given a list of 15 doctors the searchTestForTopTenDoctors() method tests
	 * if the algorithm correctly lists only top 10 similar doctors and also
	 * tests if the list is prioritized as per the assumption.
	 * 
	 */
	public void searchTestForTopTenDoctors() {

		Algorithm al = new Algorithm();

		al.addDoctor("John", new Doctor("John", "cardiologist", "pleasanton", 4.5));
		al.addDoctor("Sam", new Doctor("Sam", "cardiologist", "sanramon", 2.5));
		al.addDoctor("Kalra", new Doctor("Kalra", "cardiologist", "fremont", 3.5));
		al.addDoctor("Paul", new Doctor("Paul", "physician", "sanfran", 3.0));
		al.addDoctor("Punch", new Doctor("Punch", "physician", "sanjose", 1.0));

		al.addDoctor("John1", new Doctor("John1", "cardiologist", "pleasanton", 4.5));
		al.addDoctor("Sam1", new Doctor("Sam1", "cardiologist", "sanramon", 2.5));
		al.addDoctor("Kalra1", new Doctor("Kalra1", "cardiologist", "fremont", 3.5));
		al.addDoctor("Paul1", new Doctor("Paul1", "cardiologist", "sanfran", 3.0));
		al.addDoctor("Punch1", new Doctor("Punch1", "cardiologist", "sanjose", 1.0));

		al.addDoctor("John2", new Doctor("John2", "cardiologist", "pleasanton", 4.5));
		al.addDoctor("Sam2", new Doctor("Sam2", "cardiologist", "sanramon", 2.5));
		al.addDoctor("Kalra2", new Doctor("Kalra2", "cardiologist", "fremont", 3.5));
		al.addDoctor("Paul2", new Doctor("Paul2", "cardiologist", "sanfran", 3.0));
		al.addDoctor("Punch2", new Doctor("Punch2", "cardiologist", "sanjose", 1.0));

		ArrayList<Doctor> result = al.searchByName("John");
		// System.out.println(result);
		String resultString = result.toString();

		ArrayList<Doctor> expectedResult = new ArrayList<Doctor>();
		expectedResult.add(new Doctor("John1", "cardiologist", "pleasanton", 4.5));
		expectedResult.add(new Doctor("John2", "cardiologist", "pleasanton", 4.5));
		expectedResult.add(new Doctor("Kalra2", "cardiologist", "fremont", 3.5));
		expectedResult.add(new Doctor("Kalra", "cardiologist", "fremont", 3.5));
		expectedResult.add(new Doctor("Kalra1", "cardiologist", "fremont", 3.5));
		expectedResult.add(new Doctor("Paul2", "cardiologist", "sanfran", 3.0));
		expectedResult.add(new Doctor("Paul1", "cardiologist", "sanfran", 3.0));
		expectedResult.add(new Doctor("Sam", "cardiologist", "sanramon", 2.5));
		expectedResult.add(new Doctor("Sam1", "cardiologist", "sanramon", 2.5));
		expectedResult.add(new Doctor("Sam2", "cardiologist", "sanramon", 2.5));
		String expectedResultString = expectedResult.toString();

		assertEquals(expectedResultString, resultString);
	}

	@Test
	/*
	 * Given a list of doctors the searchTestInvalidDoctorName() method tests if
	 * the algorithm returns an empty list when an invalid or no doctor name is
	 * given
	 * 
	 */
	public void searchTestInvalidDoctorName() {

		Algorithm al = new Algorithm();

		al.addDoctor("John", new Doctor("John", "cardiologist", "pleasanton", 4.5));
		al.addDoctor("Sam", new Doctor("Sam", "cardiologist", "sanramon", 2.5));
		al.addDoctor("Kalra", new Doctor("Kalra", "cardiologist", "fremont", 3.5));
		al.addDoctor("Paul", new Doctor("Paul", "physician", "sanfran", 3.0));
		al.addDoctor("Punch", new Doctor("Punch", "physician", "sanjose", 1.0));
		ArrayList<Doctor> result = al.searchByName("Invalid");
		assertTrue(result.isEmpty());
		ArrayList<Doctor> result2 = al.searchByName(null);
		assertTrue(result2.isEmpty());
	}

	@Test
	/*
	 * When the doctors list is empty the searchTestEmptyDoctors() method tests
	 * if the algorithm returns an empty list when the user enters the doctor's
	 * name.
	 * 
	 * 
	 */

	public void searchTestEmptyDoctors() {

		Algorithm al = new Algorithm();

		ArrayList<Doctor> result = al.searchByName("John");
		assertTrue(result.isEmpty());
	}

	// All the test cases run successfully.
}
