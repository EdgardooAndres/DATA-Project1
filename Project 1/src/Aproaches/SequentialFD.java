package Aproaches;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import experimentClasses.FrequencyCounter;

public class SequentialFD<E extends Comparable<E>> extends FrequencyCounter<E> 
//TODO this class uses arrays
{
	private ArrayList<E> list = new ArrayList<>();
	//	private Random rand = new Random();
	//		rand.nextInt

	public SequentialFD() {
		super("Sequential");
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

	private int SequentialCounter(E e)
	{
		//PRE: index and values are valid.

		int counter = 0;
		for(int i=0; i<list.size(); i++)
		{
			if(list.get(i).equals(e))
			{
				counter++;
			}
		}
		return counter;
	}

	public void Sequencial()
	{
		ArrayList<E> counted = new ArrayList<>();

		for(int i=0; i<list.size(); i++)
		{
			for (int j = 0; j < counted.size() - 1; j++)
			{
				if(list.get(i).equals(counted.get(j)))
				{
					//stop searching and continue to next key.
					break;
				}
				else // i has not been counted yet.
				{
					
					//TODO write the file with element j, counter SequentialCounter(list.get(i)), timeTaken
					
					SequentialCounter(list.get(i)); //TODO tengo las veces que se repiten, falta escribierlo en lista uno al lado del otro.
					//podemos escribirlo en este metodo o en otro. o en otra clase.

					counted.set(j+1, list.get(i)); //add element to counted list.
				}
			}
		}
	}
}
