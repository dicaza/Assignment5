/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: (Give a brief description for each Class)
 * Due: MM/DD/YYYY
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: David Icaza
*/
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.Arrays;

public class TwoDimRaggedArrayUtilityTestStudent 
{
	private File testFile;
	private File outputFile;
	
	@BeforeEach
	public void setUp() throws Exception 
	{
		testFile = new File("testfile.txt");
		outputFile = new File("output.txt");
	}

	@AfterEach
	public void tearDown() throws Exception 
	{
		if(testFile.exists())
		{
			testFile.delete();
		}
		if(outputFile.exists())
		{
			outputFile.delete();
		}
	}

	@Test
	public void testReadFile() throws FileNotFoundException 
	{
		try(PrintWriter writer = new PrintWriter(testFile))
		{
			writer.println("1.0 2.0 3.0");
			writer.println("4.0 5.0");
			writer.println("6.0");
		}
		
		double [][] result = TwoDimRaggedArrayUtility.readFile(testFile);
		double[][] expected = {{1.0, 2.0, 3.0}, {4.0,5.0}, {6.0}};
		
		assertArrayEquals(expected, result, "The read data does not match the expected data.");
	}
	
	@Test
	public void testWriteToFile() throws FileNotFoundException
	{
		double[][] data = {{1.0,2.0,3.0}, {4.0,5.0}, {6.0}};
		
		TwoDimRaggedArrayUtility.writeToFile(data, outputFile);
		
		double[][] result = TwoDimRaggedArrayUtility.readFile(outputFile);
		
		assertArrayEquals(data, result, "The written data doesn not match the expected output.");
	}
	
	@Test
	public void testGetTotal()
	{
		double[][] data = {{1.0,2.0,3.0}, {4.0,5.0}, {6.0}};
		double total = TwoDimRaggedArrayUtility.getTotal(data);
		
		assertEquals(21.0, total, "The total should be 21.0");
	}
	
	@Test
	public void testGetAverage()
	{
		double[][] data = {{1.0,2.0,3.0}, {4.0,5.0}, {6.0}};
		double average = TwoDimRaggedArrayUtility.getAverage(data);
		
		assertEquals(3.5, average, 0.001, "The average should be approximately 3.5.");
	}
	
	@Test
	public void testGetRowTotal()
	{
		double[][] data = {{1.0,2.0,3.0}, {4.0,5.0}, {6.0}};
		double rowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 1);
		
		assertEquals(9.0, rowTotal, "The total for row 1 should be 9.0.");
	}
	
	@Test
	public void testGetColumnTotal()
	{
		double[][] data = {{1.0,2.0,3.0}, {4.0, 5.0}, {6.0}};
		double columnTotal = TwoDimRaggedArrayUtility.getColumnTotal(data, 1);
		
		assertEquals(0.0, columnTotal, "The total for column 1 should 0.0.");
	}

}
