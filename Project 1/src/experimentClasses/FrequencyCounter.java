package experimentClasses;

import java.util.ArrayList;
import java.util.Map;

public abstract class FrequencyCounter<E extends Comparable<E>> { 
    private String name;    // the name given to this strategy
    
    public FrequencyCounter(String name) { 
        this.name = name; 
    }

    /**
        Accesses the name of the particular strategy that the object instance corresponds to. 
    **/
    public String getName() { 
        return name; 
    } 

    /**
        Determines the frequency distribution of objects in a particular dataset using a valid
        strategy. It is based on the algorithm defining the particular strategy to solve the 
        frequency counting problem.
        @param dataSet the dataset of objects to be analized
        @return a list of entries, where each such entry is a pair: key (of type E) is a reference 
              to one instance of a different object , and value is the frequency of that object in the 
              list being analyzed
    **/
    public abstract ArrayList<Map.Entry<E, Integer>> computeFDList(ArrayList<E> dataSet); 
}
