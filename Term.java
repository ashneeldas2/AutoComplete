import java.util.Comparator;

public class Term implements Comparable<Term> {

	private String _query;
	private long _weight;

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight){
    	_query = query;
    	_weight = weight;
    }
    
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
    	return "Query: " + getQuery() + " Weight: " + getWeight();
    }
    
    public static void main(String[] args){
    	Term term = new Term("hello", 100);
    	Term term2 = new Term("goodbye", 500);
    	Term term3 = new Term("hey", 200);
    	System.out.println(term);
    	System.out.println(term.compareTo(term2));
    	Comparator<Term> byRev = Term.byReverseWeightOrder();
    	System.out.println(byRev.compare(term2, term));
    	Comparator<Term> byPre = Term.byPrefixOrder(3);
    	System.out.println(byPre.compare(term3, term));
    }

}
