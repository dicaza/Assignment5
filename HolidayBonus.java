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

public class HolidayBonus
{
	public static final double HIGH_BONUS = 5000.0;
	public static final double LOW_BONUS = 1000.0;
	public static final double OTHER_BONUS = 2000.0;
	
	public static double[] calculateHolidayBonus(double[][] data)
	{
		double[] bonuses = new double[data.length];
		int maxC = 0;
		for(double[] row : data)
		{
			if(row.length > maxC)
			{
				maxC = row.length;
			}
		}
		for(int c = 0; c < maxC; c++)
		{
			int highestStoreIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data,c);
			int lowestStoreIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data,c);
			
			if(highestStoreIndex >= 0)
			{
				bonuses[highestStoreIndex] += HIGH_BONUS;
			}
			
			if(lowestStoreIndex >= 0 && lowestStoreIndex != highestStoreIndex)
			{
				bonuses[lowestStoreIndex] += LOW_BONUS;
			}
			
			for(int row = 0; row < data.length; row++)
			{
				if(row != highestStoreIndex && row != lowestStoreIndex && c < data[row].length)
				{
					bonuses[row] += OTHER_BONUS;
				}
			}
		}
		return bonuses;
	}
	
	public static double calculateTotalHolidayBonus(double[][] data)
	{
		double total =  0;
		double[] bonuses = calculateHolidayBonus(data);
		
		for(double bonus : bonuses)
		{
			total += bonus;
		}
		
		return total;
	}
}
