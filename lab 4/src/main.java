import java.util.*;
/**
 * Compare and sort string by length in ascending order
 */
public class main{
	public static void main(String[] args)
	{
		//array list
		List<String> test = new ArrayList<String>();
		test.add("abcd");
		test.add("a");
		test.add("hello world");
		test.add("by");
		//compares the length of the strings
		class LengthCompare implements Comparator<String>
		{
			public int compare(String obj1, String obj2)
			{
				String len1 = obj1;
				String len2 = obj2;
				if(len1.length()> len2.length())
					return 1;
				else
					return -1;
			}
		}
		System.out.println("Original name list:\n" + test);
		
		Collections.sort(test, new LengthCompare()); //sorts the string by comparing the length of string
		System.out.println("Sorted in length list:\n" + test);
	}
}