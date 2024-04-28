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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
public class TwoDimRaggedArrayUtility 
{
	//First method
	public static double [][] readFile(File file) throws FileNotFoundException
	{
		ArrayList<double[]> rows = new ArrayList<>();
		Scanner inputfile = new Scanner(file);
		while (inputfile.hasNextLine())
		{
				String line = inputfile.nextLine().trim();
				if(!line.isEmpty())
				{
					String[] values = line.split("\\s+");
					double[]row = new double[values.length];
					for(int i = 0; i < values.length; i++)
					{
						row[i] = Double.parseDouble(values[i]);
					}
					rows.add(row);
				}
		}
		inputfile.close();
		
		double[][] result = new double[rows.size()][];
		for (int i = 0; i < rows.size(); i++)
			{
				result[i] = rows.get(i);
			}
			return result;
	}
	
	//Second Method
	public static void writeToFile(double[][] data, File file)
	{
		try
		{
			FileWriter writer = new FileWriter(file);
			for(double[] row : data)
			{
				for(double value : row)
				{
					writer.write(value + " ");
				}
			writer.write("\n");
			}
			writer.close();
		}
		catch (IOException e)
		{
			System.err.println("Error writing to file: " + e.getMessage());
		}
	}
	
	
	//Third Method
	public static double getTotal(double[][] data)
	{
		double total = 0;
		for(double[] row : data)
		{
			for (double value : row)
			{
				total += value;
			}
		}
		return total;
	}
	
	//Fourth Method
	public static double getAverage(double[][] data)
	{
		double total = getTotal(data);
		int count = 0;
		for(double[]row : data)
		{
			count += row.length;
		}
		return total/count;
	}
	
	//Fifth Method
	public static double getRowTotal(double[][]data, int row)
	{
		double total = 0;
		if(row >= 0 && row < data.length)
		{
			for(double value : data[row])
			{
				total += value;
			}
		}
		return total;
	}
	
	//Sixth Method
	public static double getColumnTotal(double[][] data, int column)
	{
		double total = 0;
		for (double[] row : data)
		{
			if(column < row.length);
		}
		return total;
	}
	
	//Seventh Method
	public static double getHighestInRow(double[][] data, int row)
	{
		double highest = Double.NEGATIVE_INFINITY;
		if(row >= 0 && row < data.length)
		{
			for(double value : data[row])
			{
				if(value > highest)
				{
					highest = value;
				}
			}
		}
		return highest;
	}
	
	//Eighth Method
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		double highest = Double.NEGATIVE_INFINITY;
		int index = -1;
		if(row >= 0 && row < data.length)
		{
			for(int i = 0; i < data[row].length; i++)
			{
				if(data[row][i] > highest)
				{
					highest = data[row][i];
					index = i;
				}
			}
		}
		return index;
	}
	
	//Ninth Method
	public static double getLowestInRow(double[][] data, int row)
	{
		double lowest = Double.POSITIVE_INFINITY;
		if(row >= 0 && row < data.length)
		{
			for(double value : data[row])
			{
				if(value < lowest)
				{
					lowest = value;
				}
			}
		}
		return lowest;
	}
	
	//Tenth Method
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		double lowest = Double.POSITIVE_INFINITY;
		int index = -1;
		if(row >= 0 && row < data.length)
		{
			for(int i = 0; i < data[row].length; i++)
			{
				if(data[row][i] < lowest)
				{
					lowest = data[row][i];
					index = i;
				}
			}
		}
		return index;
	}
	
	//Eleventh Method
	public static double getHighestInColumn(double[][] data, int column)
	{
		double highest = Double.NEGATIVE_INFINITY;
		for(double[] row : data)
		{
			if(column < row.length)
			{
				if(row[column] > highest)
				{
					highest = row[column];
				}
			}
		}
		return highest;
	}
	
	//Twelfth Method
	public static int getHighestInColumnIndex(double[][]data, int column)
	{
		double highest = Double.NEGATIVE_INFINITY;
		int index = -1;
		for(int i = 0; i < data.length; i++)
		{
			if(column < data[i].length)
			{
				if(data[i][column] > highest)
				{
					highest = data[i][column];
					index = i;
				}
			}
		}
		return index;
	}
	
	//Thirteenth Method
	public static double getLowestInColumn(double[][] data, int column)
	{
		double lowest = Double.POSITIVE_INFINITY;
		for (double[] row : data)
		{
			if(column < row.length)
			{
				if(row[column] < lowest)
				{
					lowest = row[column];
				}
			}
		}
		return lowest;
	}
	
	//Fourteenth Method
	public static int getLowestInColumnIndex(double[][] data, int column)
	{
		double lowest = Double.POSITIVE_INFINITY;
		int index = -1;
		for(int i = 0; i < data.length; i++)
		{
			if(column < data[i].length)
			{
				if(data[i][column] < lowest)
				{
					lowest = data[i][column];
					index = i;
				}
			}
		}
		return index;
	}
	
	//Fifteenth Method
	public static double getHighestInArray(double[][] data)
	{
		double highest = Double.NEGATIVE_INFINITY;
		for(double[] row : data)
		{
			for(double value : row)
			{
				if(value > highest)
				{
					highest = value;
				}
			}
		}
		return highest;
	}
	
	//Sixteenth Method
	public static double getLowestInArray(double[][] data)
	{
		double lowest = Double.POSITIVE_INFINITY;
		for(double[] row : data)
		{
			for(double value : row)
			{
				if(value < lowest)
				{
					lowest = value;
				}
			}
		}
		return lowest;
	}
}
