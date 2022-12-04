package ch.correvon.adventofcode.day04.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main_Day04_b
{

	public static void main(String[] args)
	{
		int overlapping = parseFile(getFileStream("/ch/correvon/adventofcode/day04/data.txt"));
		System.out.println("Overlapping elfes : " + overlapping);
		// Overlapping elfes : 867
	}

	private static InputStream getFileStream(String fileName)
	{
		InputStream inputStream = Main_Day04_b.class.getResourceAsStream(fileName);
		if(inputStream == null)
			System.err.println("Unable to open " + fileName);
		return inputStream;
	}

	private static int parseFile(InputStream inputStream)
	{
		int nbOverlapping = 0;
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)))
		{
			String line;
			int lineNum = 0;
			while((line = br.readLine()) != null)
			{
				String[] split = line.split(",");
				if(split.length != 2)
				{
					System.err.println("Invalid line " + lineNum + " : " + line);
					continue;
				}
				
				System.out.println("Looking at : " + line);

				Shift shift1 = Shift.parseShift(split[0]);
				Shift shift2 = Shift.parseShift(split[1]);
				if(isOverlapping(shift1, shift2)) {
					System.out.println("Overlaping : " + lineNum + " : " + line);
					nbOverlapping++;
				}
				
				lineNum++;
			}
		}
		catch(IOException e)
		{
			System.err.println("Unable to parse the file :");
			e.printStackTrace();
		}
		
		return nbOverlapping;
	}
	
	private static final boolean isOverlapping(Shift shift1, Shift shift2)
	{
	    return (shift1.getStart() >= shift2.getStart() && shift1.getEnd() <= shift2.getEnd()
	    			|| (shift2.getStart() >= shift1.getStart() && shift2.getEnd() <= shift1.getEnd())
	    			|| (shift1.getEnd() >= shift2.getStart() && shift1.getEnd() <= shift2.getEnd())
	    			|| (shift1.getStart() >= shift2.getStart() && shift1.getStart() <= shift2.getEnd())
	    			);
	}
}
