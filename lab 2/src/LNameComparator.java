/**
 * Comparator class to compare last name of Employee in asceding order
 */
import java.util.*;
public class LNameComparator implements Comparator<Employee>{
		public int compare(Employee obj1, Employee obj2) //last name, ascending
		{
			Employee em1 = obj1; //Employee em1 = (Employee)obj1; -> type cast if Comparator<Employee> isn't used
			Employee em2 = obj2;
			return em1.LName.compareTo(em2.LName);
		}
	}