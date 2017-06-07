import java.util.Comparator;

public class Term implements Comparable<Term> {

	private String _query;
	private long _weight;

    // Initializes a term with the given query string and weight.
	// Constructor
    public Term(String query, long weight){
    	_query = query;
    	_weight = weight;
    }
    
    // Accessor methods
    public String getQuery(){
    	return _query;
    }
    
    public long getWeight(){
    	return _weight;
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
    	return new ReverseWeightComparator<Term>();
    }

    // Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r){
    	return new QueryComparator<Term>(r);
    }

    // Compares the two terms in lexicographic order by query.

    public int compareTo(Term that){
    	return this.getQuery().compareTo(that.getQuery());
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString(){
    	return getQuery() + "     " + getWeight();
    }

}
