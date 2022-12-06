package ch.correvon.adventofcode.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main_Day06
{
	public static void main(String[] args)
	{
		int result = parseFile(getFileStream("data.txt"), false);
		System.out.println("Result : " + result);
	}

	private static InputStream getFileStream(String fileName)
	{
		InputStream inputStream = Main_Day06.class.getResourceAsStream(fileName);
		if(inputStream == null)
			System.err.println("Unable to open " + fileName);
		return inputStream;
	}

	private static int parseFile(InputStream inputStream, boolean partB)
	{
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)))
		{
			String line;
			int lineNum = 0;
			while((line = br.readLine()) != null)
			{
				String[] split = line.split(" ");
				if(split.length != 2)
				{
					System.err.println("Invalid line " + lineNum + " : " + line);
					continue;
				}
				

				lineNum++;
			}
		}
		catch(IOException e)
		{
			System.err.println("Unable to parse the file :");
			e.printStackTrace();
		}
		
		return -1;
	}
}
