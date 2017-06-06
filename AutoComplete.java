import java.util.*;

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
//	_results = allMatches(phrase);
	_phrase = phrase;
	quickSort(0, _words.length-1);
	for (int i = 0; i < _words.length; i++) System.out.println(_words[i]);
	System.out.println(getLastOccur(_phrase));
    }
    
    // Sort all words in file (_words)
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
	Comparator<Term> byRev = Term.byReverseWeightOrder();	
	PriorityQueue<Term> q = new PriorityQueue<Term>(byRev);
	int firstMatch = getFirstOccur(prefix);
	int lastMatch = getLastOccur(prefix);	
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
    			recent = mid;
    			lo = mid + 1;
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
	Term t1 = new Term("hello", 5);
	Term t15 = new Term("hell", 6);
	Term t16 = new Term("hellenistic", 17);
	Term t2 = new Term("goodbye", 10);
	Term t3 = new Term("yes", 17);
	Term t4 = new Term("no", 18);
	Term [] terms = {t1, t15, t16, t2, t3, t4};
	AutoComplete ac = new AutoComplete(terms, "hell");		
    }  
}
