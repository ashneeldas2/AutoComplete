import java.util.PriorityQueue;

public class Autocomplete {

	//1) Put all words in text file into _words
	//2) Sort _words
	//3) Search _words using binary search for matching results. 
	//4) Put the found words into the priority queue. 
	private PriorityQueue<Term> _results;
	private ArrayList<Term> _words;
	private String _phrase; 

	// Initializes the data structure from the given array of terms.
    public Autocomplete(ArrayList<Term> words, String phrase){
    	_results = new PriorityQueue<Term>();
    	_words = words;
		_phrase = phrase;
    }
    
    // Sort all words in file (_words)
    public void sortFile(){
		
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public PriorityQueue<Term> allMatches(String prefix){
	    
    }

	
    public int getFirstOccur(String prefix){
	    
    }
 
    public int getLastOccur(String prefix){
	    
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix)

    // unit testing (required)
    public static void main(String[] args)   
}
