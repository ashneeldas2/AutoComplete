import java.util.Comparator;

public class QueryComparator<T> implements Comparator<T>{

   private int _r;
   
   public QueryComparator(int r){
       _r = r;
   }

   public int compare(T a, T b) throws ClassCastException{
	   if (((String) a).length() < _r || ((String) b).length() < _r) return ((String)a).compareTo((String) b);
	   
       return ((String) a).substring(0, _r).compareTo(((String) b).substring(0, _r));
    }

}

