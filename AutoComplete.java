import java.util.*;
import java.io.*;

public class AutoComplete {

	//1) Put all words in text file into _words
	//2) Sort _words
	//3) Search _words using binary search for matching results. 
	//4) Put the found words into the priority queue. 
	private Term [] _words;
	private String _phrase;
	private PriorityQueue<Term> _results;
	// Initializes the data structure from the given array of terms.
    public AutoComplete(Term [] words, String phrase){
    	_words = words;
    	_phrase = phrase;
    	quickSort(0, _words.length-1);
		_results = allMatches(_phrase);
    }
    
    // Sort all words in file (_words)
    
    public PriorityQueue<Term> getResults() {
    	return _results;
    }
    public static void printArray(Term [] terms) {
    	for (int i = 0; i < terms.length; i++) System.out.println(terms[i].getQuery() + ", ");
    }
    public void quickSort(int low, int high){
	if (_words == null || _words.length == 0) return;
	int i = low, j = high;
	Term pivot = _words[low + (high - low)/2];
	while (i <= j) {
	    while (_words[i].compareTo(pivot) < 0) i++;
	    while (_words[j].compareTo(pivot) > 0) j--;
	    if (i <= j) {
	        exchange(i, j);	
	        i++;
	        j--;
	    }
	}	
	if (low < j) quickSort(low, j); 
	if (i < high) quickSort(i, high);
    }

    private void exchange(int i, int j) {
	Term temp = _words[i];
	_words[i] = _words[j];
	_words[j] = temp;
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public PriorityQueue<Term> allMatches(String prefix){
	Comparator<Term> byRev = new ReverseWeightComparator();
	PriorityQueue<Term> q = new PriorityQueue<Term>(byRev);
	int firstMatch = getFirstOccur(prefix);
	int lastMatch = getLastOccur(prefix);	
	if (firstMatch == -1 || lastMatch == -1) {
		System.out.println("No matches!");
		return q;
	}
	while (firstMatch <= lastMatch) {
	    q.add(_words[firstMatch]);	
	    firstMatch++;
	}
	return q;
    }

	
    public int getFirstOccur(String key){
    	Comparator<String> queryC = new QueryComparator<String>(_phrase.length());
    	int lo = 0; 
    	int hi = _words.length - 1;
    	int recent = -1;
    	while (lo <= hi) {
    		int mid = lo + (hi-lo)/2;
    		if (queryC.compare(key, _words[mid].getQuery()) < 0)
    			hi = mid - 1;
    		else if (queryC.compare(key, _words[mid].getQuery()) > 0)
    			lo = mid + 1;
    		else {
    			hi = mid - 1;
    			recent = mid;
    		}
    	}
    	return recent;
    }
 
    public int getLastOccur(String key){
    	Comparator<String> queryC = new QueryComparator<String>(_phrase.length());
    	int lo = 0; 
    	int hi = _words.length - 1;
    	int recent = -1;
    	while (lo <= hi) {
    		int mid = lo + (hi-lo)/2;
    		if (queryC.compare(key, _words[mid].getQuery()) == 0) {
    			lo = mid + 1;
    			recent = mid;
    		}
    		else if (queryC.compare(key, _words[mid].getQuery()) < 0)
    			hi = mid - 1;
    		else
    			lo = mid + 1;
    	}
    	return recent;
    }

    // unit testing (required)
    public static void main(String[] args) {
    String filename = args[0];
    In in = new In(filename);
    int N = in.readInt();
    Term[] terms = new Term[N];
    for (int i = 0; i < N; i++) {
        long weight = in.readLong();           // read the next weight
        in.readChar();                         // scan past the tab
        String query = in.readLine();          // read the next query
        terms[i] = new Term(query, weight);    // construct the term
    }
    int numTerms = Integer.parseInt(args[1]);
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter a term!: ");
	while (sc.hasNext()) {
		int counter = 0;
		String input = sc.nextLine().toLowerCase();
		AutoComplete ac = new AutoComplete(terms, input);	
		while (!ac.getResults().isEmpty() && counter < numTerms) {
			counter++;
			System.out.println(ac.getResults().poll());
		}
		System.out.print("Enter a term!: ");
	}
    }
	
}

