import java.util.Comparator;

//This class compares Terms based on their weights, in reverse. 
public class ReverseWeightComparator<T> implements Comparator<T>{

   public int compare(T a, T b) throws ClassCastException{
	   long weightDiff = ((Term) b).getWeight() - ((Term) a).getWeight();
       if (weightDiff > 0) return 1;
       else if (weightDiff < 0) return -1;
       else return 0;
    }
}

