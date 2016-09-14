package Aproaches;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import experimentClasses.CreateFile;
import experimentClasses.FrequencyCounter;

public class SequentialFD<E extends Comparable<E>> extends FrequencyCounter<E> 
//TODO this class uses arrays
{
	private ArrayList<E> list = new ArrayList<>();
	//	private Random rand = new Random();
	//		rand.nextInt

	public SequentialFD() {
		super("Sequential");

		//		Random rand = new Random();
		for(int i=0; i<200; i++)
		{
			//			list[i] = rand.nextInt(200 + 1);
			list.set(i, new Random().nextInt(200 + 1));
		}
	}

	@Override
	public ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet) {
		ArrayList<Map.Entry<E, Integer>> results = 
				new ArrayList<Map.Entry<E, Integer>>();         
		for (E e : dataSet) { 
			boolean entryFound = false; 
			for (int i=0; i<results.size() && !entryFound; i++) {
				Map.Entry<E, Integer> entry = results.get(i); 

				if (entry.getKey().equals(e)) { 
					entry.setValue(entry.getValue()+1);
					entryFound = true; 
				}
			}
			if (!entryFound) { 
				//need to create a new entry for the first instance found of object e
				Map.Entry<E, Integer> entry = new AbstractMap.SimpleEntry<E, Integer>(e, 1); 
				results.add(entry); 
			}
		}

		return results;
	}  // end of method computeFDList

	private int sequentialCounter(int key)
	{
		//PRE: index and values are valid.

		int counter = 0;
		for(int i=0; i<list.length; i++)
		{
			if(list[i]==key)
			{
				counter++;
			}
		}
		return counter;
	}

	public void sequencial()
	{
		ArrayList<E> counted = new ArrayList<>();

		for(int i=0; i<list.length; i++)
		{
			for (int j = 0; j < counted.size() - 1; j++)
			{
				if(list[i] == counted[j])
				{
					//stop searching and continue to next key.
					break;
				}
				else // i has not been counted yet.
				{
					sequentialCounter(list[i]); //TODO tengo las veces que se repiten, falta escribierlo en lista uno al lado del otro.
					//podemos escribirlo en este metodo o en otro. o en otra clase.

					counted[j+1] = list[i]; //add element to counted list.
				}
			}
		}
	}

	public void sequencialString()
	{
		String[] counted = new String[200];


	}

	//------------------------------------------------------------------------------------
	public void createFile()
	{
		CreateFile g = new CreateFile();
		g.createIntFile();
		//g.addIntData(list[index], timeTaken);
		g.closeFile();
	}
	
	public void readFile()
	{
		CreateFile g = new CreateFile();
		g.openFile("int");
		g.readFile("int");
		g.closeFile();
	}


}
