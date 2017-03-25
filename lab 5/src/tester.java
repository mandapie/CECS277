import java.util.*;
/**
 * tester Class to test binary search and insertion sort
 * created array of Faculty
 * created array of numbers for user to input
 * @author amanda
 *
 */
public class tester {

	public static void main(String[] args)
	{
		Scanner reader = new Scanner(System.in);
		//initialized array of Employees
		Employee[] AlexTyrone = new Employee[3];
		AlexTyrone[0] = new Faculty ("Johnson", "Anne", 234, 'F', 62, 4, 27, "Ph.D", "Engineering", 3, Level.FU);
		AlexTyrone[1] = new Faculty ("Bouris", "William", 791, 'F', 75, 3, 14, "Ph.D", "English", 1, Level.AO);
		AlexTyrone[2] = new Faculty ("Andrade", "Christopher", 623, 'F', 80, 15, 22, "MS", "Physical Education", 0, Level.AS);
		InsertionSort.InsertionSort(AlexTyrone); // sort the array
		/*
		for(int i= 0; i < AlexTyrone.length; i++)
		{
				System.out.print(AlexTyrone[i]);
		}
		*/
		System.out.println("Enter Factulty ID: ");
		int n = reader.nextInt();
		BinarySearcher<Employee> findF = new BinarySearcher(AlexTyrone); //define class BinarySearcher to type Employee
		Faculty found = new Faculty();
		found.setID(n);
		try
		{
			System.out.println("Faculty Data found in location: " + (findF.search(found)+1) + ", " + AlexTyrone[findF.search(found)].getFName() + " " + AlexTyrone[findF.search(found)].getLName());
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Faculty Data not found");
		}
		/*
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		System.out.println("Enter a few numbers: ");
		String[] tokens = reader.nextLine().split("\\s");
	    for (int i = 0; i < tokens.length; i++)
	       numbers.add(Integer.parseInt(tokens[i]));
	    Collections.sort(numbers);
	    System.out.println(numbers.toString());
	    */
		System.out.println("");
		System.out.println("How many integers do you want to enter?");
        int num = reader.nextInt();
        Integer numArray[] = new Integer[num];
        System.out.println("Enter the " + num + " integers now.");
        for (int i = 0; i < numArray.length; i++)
        	numArray[i] = reader.nextInt();
        InsertionSort.InsertionSort(numArray); //sort the array
        /*
        for (int i = 0 ; i < numArray.length; i++ ) 
        {
        	System.out.print(numArray[i]);
        }
        */        
      	System.out.println("");
       	System.out.println("Enter a number you want to find: ");
		int find = reader.nextInt();
		BinarySearcher<Integer> findnum = new BinarySearcher(numArray); // define class BinarySearcher to type Integer
		
		try
		{
			System.out.println("Number found in locaton: " + (findnum.search(find)+1) + ", " + numArray[findnum.search(find)]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Integer not found");
		}
	}
}
