package Aproaches;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

import experimentClasses.FrequencyCounter;

public class SequentialFD<E extends Comparable<E>> extends FrequencyCounter<E> 
//TODO this class uses arrays
{

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
}
