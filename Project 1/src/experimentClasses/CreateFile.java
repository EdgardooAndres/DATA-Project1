package experimentClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class CreateFile {

	private Formatter x;
	private Scanner s;

	public void createIntFile()
	{
		try{
			x = new Formatter("inputData/integerData.txt");
		}
		catch(Exception e){
			System.out.println("you have an error.");
		}
	}
	
	public void createStringFile()
	{
		try{
			x = new Formatter("inputData/stringData.txt");
		}
		catch(Exception e){
			System.out.println("you have an error.");
		}
	}

	public void addIntData(int data, float time)
	{
		x.format("%s%s", data, time);
	}
	
	public void addStringData(String data, float time)
	{
		x.format("%s%s", data, time);
	}

	public void closeFile()
	{
		x.close();
	}

	public void openFile(String type)
	{
		try {
			if(type.equals("int"))
				s = new Scanner(new File("integerData.txt"));
			else if( type.equals("string"))
			{
				s = new Scanner(new File("stringData.txt"));
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("could not find file");
		}
	}

	public void readFile(String type)
	{
		if(type.equals("int"))
		{
			while(s.hasNext())
			{
				int a = s.nextInt();
				float b = s.nextFloat();

				System.out.printf("%s %s \n", a, b);
			}
		}
		else if( type.equals("string"))
		{
			while(s.hasNext())
			{
				String a = s.next();
				float b = s.nextFloat();

				System.out.printf("%s %s \n", a, b);
			}
		}

	}

}
