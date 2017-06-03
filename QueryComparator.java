import java.util.Comparator;

public class QueryComparator<T> implements Comparator<T>{

   private int _r;
   
   public QueryComparator(int r){
       _r = r;
   }

   public int compare(T a, T b) throws ClassCastException{
       return (((Term) b).getQuery().substring(0, _r).compareTo(((Term) a).getQuery().substring(0, _r)));
    }

}

