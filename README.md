I. What Is AutoComplete?
  AutoComplete is a program that mimicks the autocomplete feature of search engines such as Google. It takes a phrase from the user and then searches a database for words that begin with that phrase. Each word in the database has an assigned weight and when the found words are returned by the program, they are returned in decending order by weight.
  
II. How Does It Work?
  1) Each entry in the datatbase (text file) is converted into a Term Object which contains the word (String) and its corresponding weight(long). The terms are placed in a Term Array.
  2) The array of Terms is sorted alphabetically using QuickSort.
  3) Using binary search, we search the Term Array for a range of words beginning with the given phrase. We use "QueryComparator" to compare Terms because while searching, we only need to compare the part of the word that contains the phrase we are searching for (ex: if we are searching using the phrase "top", "topology" and "topic" should be considered equal)   
  4) The words in the range are placed in a PriorityQueue that prioritizes words based on their weight. The PriorityQueue uses the "ReverseWeightComparator" in order to compare terms in reverse order of their weight.
  5) The results are displayed to the user.
  
III. How Do You Run AutoComplete?
  "java AutoComplete <filename> <number of results to display>"
