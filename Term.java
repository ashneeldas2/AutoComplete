
public class Term implements Comparable<Term> {

    public Term(String query, long weight)

    public static Comparator<Term> byReverseWeightOrder()

    public static Comparator<Term> byPrefixOrder(int r)

    public int compareTo(Term that)

    public String toString()

    public static void main(String[] args)   
}
