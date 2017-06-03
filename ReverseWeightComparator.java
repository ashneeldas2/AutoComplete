import java.util.Comparator;

public class ReverseWeightComparator<T> implements Comparator<T>{

   public int compare(T a, T b) throws ClassCastException{
       return (int) (((Term) b).getWeight() - ((Term) a).getWeight());
    }

}

