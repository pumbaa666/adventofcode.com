package ch.correvon.adventofcode.day06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_Day06
{
	public static void main(String[] args)
	{
		int result = parseFile(getFileStream("data.txt"), 4);
		System.out.println("Last result Part A : " + result);
		// Last result : 1198

		result = parseFile(getFileStream("data.txt"), 14);
		System.out.println("Result Part B: " + result);
		// Last result : 3120
	}

	private static InputStream getFileStream(String fileName)
	{
		InputStream inputStream = Main_Day06.class.getResourceAsStream(fileName);
		if(inputStream == null)
			System.err.println("Unable to open " + fileName);
		return inputStream;
	}

	private static int parseFile(InputStream inputStream, int bufferSize)
	{
		int i = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)))
		{
			String line;
			int lineNum = 0;
			line:while((line = br.readLine()) != null)
			{
				System.out.println("\nline : " + line);
				
				i = 1;
				Character[] buffer = new Character[bufferSize];
				for(char c:line.toCharArray())
				{
					buffer[i%bufferSize] = c;
					if(checkBufferUnicity(buffer, bufferSize))
					{
					    Stream<Character> charStream = Arrays.stream(buffer);
					    String bufferEnString = charStream.map(String::valueOf).collect(Collectors.joining());
						System.out.println("1st uniques at index "+i+" : " + bufferEnString);
						continue line;
					}
					i++;
				}

				lineNum++;
			}
		}
		catch(IOException e)
		{
			System.err.println("Unable to parse the file :");
			e.printStackTrace();
		}
		
		return i;
	}
	
	public static boolean checkBufferUnicity(Character[] arr, int minimalBufferSize)
    {
		if(arr.length < minimalBufferSize)
			return false;
		for(int i = 0; i < minimalBufferSize; i++)
			if(arr[i] ==  null)
				return false;
		
        // Put all array elements in a HashSet
		Set<Character> s = new HashSet<Character>(Arrays.asList(arr));
 
        // If all elements are distinct, size of HashSet should be same array.
        return (s.size() == arr.length);
    }
}
