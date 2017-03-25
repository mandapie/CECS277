import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Lab 7
 * @author amanda
 * Due date: 3/23/2016
 */
public class WordCount {

	/**
	 * then counts the the number of times the each word appears in the text file
	 * use SortedMap to sort words in alphabetical order
	 * @param in
	 * @return wcount
	 */
	public static SortedMap<String,Integer> getWords(Scanner in)
	{
		int times;
		SortedMap<String,Integer>wcount = new TreeMap<String,Integer>();
		while (in.hasNext())
		{
			String word = in.next();//.toLowerCase();
			if(wcount.containsKey(word))
			{
				times = wcount.get(word) + 1;
				wcount.put(word, new Integer(times));
			}
			else
				wcount.put(word,1);
		}
		return wcount;
	}
	/**
	 * reads file "book.txt"
	 * prints out words that are repeated more than 10 times
	 * use SortedMap to sort words in alphabetical order
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		File reader = new File("book.txt");
		Scanner in = new Scanner(reader);
		
		SortedMap<String,Integer>words = getWords(in);
		
		for(String WORD: words.keySet())
		{
			//if(words.get(WORD).intValue() > 10)
				System.out.println(WORD + ": " + words.get(WORD) + "times");
		}
	}
}
