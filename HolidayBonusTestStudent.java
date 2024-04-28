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

class HolidayBonusTestStudent {

	private double[][] sales;
	@BeforeEach
	public void setUp() throws Exception 
	{
		sales = new double[][] {{1.0, 2.0, 3.0}, {4.0, 5.0}, {6.0, 7.0, 8.0, 9.0}};
	}

	@AfterEach
	public void tearDown() throws Exception 
	{
		
	}

	@Test
	public void test() 
	{
		double totalBonus = HolidayBonus.calculateTotalHolidayBonus(sales);
		
		assertEquals(27000.0, totalBonus);
	}
	
	@Test
	public void test2()
	{
		double expected = 27000.0;
		double actual = HolidayBonus.calculateTotalHolidayBonus(sales);
		assertEquals(expected, actual, 0.001);
	}

}
