/**
A generic class with type T for sorting through an array.
*/
public class InsertionSort<T extends Comparable<T>>
{
	/**
	 * Compares value in each array
	 * Bigger value is swapped to the right side and
	 * smaller value to the left side
	 * @param theArray
	 */
	public static <T extends Comparable<T>> void InsertionSort(T[] theArray)
	{
		for (int unsorted = 1; unsorted < theArray.length; ++unsorted)
		{
			T nextItem = theArray[unsorted];
			int loc = unsorted;
			while ((loc > 0) && (theArray[loc-1].compareTo(nextItem) > 0))
			{
				// shift theArray[loc-1] to the right
				theArray[loc] = theArray[loc-1];
				loc--;
			}
			// insert nextItem into sorted region
			theArray[loc] = nextItem;
		}
	}
}