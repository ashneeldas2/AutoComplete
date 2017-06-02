import java.util.PriorityQueue;

public class Autocomplete {

	//1) Put all words in text file into _words
	//2) Sort _words
	//3) Search _words using binary search for mathcing results
	//4) 
	public PriorityQueue<Term> _results;
	public ArrayList<Term> _words;

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms){
    	_results = new PriorityQueue<Term>();
    	_words = new ArrayList<Term>();
    }
    
    // Sort all words in file (_words)
    public void sortFile(){
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix)

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix)

    // unit testing (required)
    public static void main(String[] args)   
}
