/**
 * Class test contains main method
 * Contains data of Employees
 * Displays the data in ascending order based on last name
 * Displays the data in descending order based on ID 
 */
import java.util.*; 

 public class test {

	public static void main(String[] args) throws CloneNotSupportedException{	
/*		//this is an array
		Employee[] AlexTyrone = new Employee[9];
		AlexTyrone[0] = new Staff ("Allen", "Paita", 123, 'M', 59, 2, 23, 50.00);
		AlexTyrone[1] = new Staff ("Zapata", "Steven", 456, 'F', 64, 7, 12, 35.00);
		AlexTyrone[2] = new Staff ("Rios", "Enrique", 789, 'M', 70, 6, 2, 40.00);
		AlexTyrone[3] = new Faculty ("Johnson", "Anne", 234, 'F', 62, 4, 27, "Ph.D", "Engineering", 3, Level.FU);
		AlexTyrone[4] = new Faculty ("Bouris", "William", 791, 'F', 75, 3, 14, "Ph.D", "English", 1, Level.AO);
		AlexTyrone[5] = new Faculty ("Andrade", "Christopher", 623, 'F', 80, 15, 22, "MS", "Physical Education", 0, Level.AS);
		AlexTyrone[6] = new Partime ("Guzman", "Augusto", 455, 'F', 77, 8, 10, 35.00, 30);
		AlexTyrone[7] = new Partime ("Depirro", "Martin", 678, 'F',87, 9, 15, 30.00, 15);
		AlexTyrone[8] = new Partime ("Aldaco", "Marque", 945, 'M', 88, 11, 24, 20.00, 35);
		
		Arrays.sort(AlexTyrone);
		for(Employee i : AlexTyrone)
		{
			System.out.print(AlexTyrone.toString());
		}*/		
		double total1 = 0.00;
		double total2 = 0.00;
		//employee data
		List<Employee> test = new ArrayList<Employee>(); //array list
		test.add(new Staff("Allen", "Paita", 123, 'M', 59, 2, 23, 50.00));
		test.add(new Staff("Zapata", "Steven", 456, 'F', 64, 7, 12, 35.00));
		test.add(new Staff("Rios", "Enrique", 789, 'M', 70, 6, 2, 40.00));
		test.add(new Faculty("Johnson", "Anne", 234, 'F', 62, 4, 27, "Ph.D", "Engineering", 3, Level.FU));
		test.add(new Faculty("Bouris", "William", 791, 'F', 75, 3, 14, "Ph.D", "English", 1, Level.AO));
		test.add(new Faculty("Andrade", "Christopher", 623, 'F', 80, 15, 22, "MS", "Physical Education", 0, Level.AS));
		test.add(new Partime("Guzman", "Augusto", 455, 'F', 77, 8, 10, 35.00, 30));
		test.add(new Partime("Depirro", "Martin", 678, 'F',87, 9, 15, 30.00, 15));
		test.add(new Partime("Aldaco", "Marque", 945, 'M', 88, 11, 24, 20.00, 35));
		//sort for ID
		Collections.sort(test);
		Iterator<Employee> itr = test.iterator();
		System.out.println("Sort by ID number in descending order:");
		System.out.println();
		while(itr.hasNext())
		{
			Employee em = itr.next();
			System.out.print(test.toString());
			System.out.println();
			
		}
		//sort for LName
		Collections.sort(test, new LNameComparator());
		Iterator<Employee> itr2= test.iterator();
		System.out.println("Sort by Last Name in ascending order:");
		System.out.println();
		while(itr2.hasNext())
		{
			Employee em = itr2.next();
			System.out.println(test.toString());
		}   
		//calculates the total monthly earning of all employee
		for (Employee em: test)
		{
			total1 += em.monthlyEarning();
		}
		System.out.println("\nTotal Monthly Earning of all employees: $" + total1);
		//calculates the total monthly earning of all partime
		long startTime = System.nanoTime();
		for (Employee em: test)
		{
			if(em instanceof Partime)
				total2 += em.monthlyEarning();
		}
		long endTime = System.nanoTime();
		System.out.println("Total Monthly Earning of all Part timers: $" + total2);
		//cloning
		Faculty b1 = (Faculty)test.get(3);
		Faculty b2 = (Faculty)b1.clone();
		System.out.println("\noriginal: " + b1.toString());
		System.out.println("\ncloned: "+ b2.toString());
		((Faculty)test.get(3)).setEducation("Ms", "Mathematics", 7);
		System.out.println("\nriginal(after alteration): " + b1.toString());
		System.out.println("\ncloned(after alteration): " + b2.toString());
		//prints out runtime output for calculating total monthly earning of Partime
		System.out.println("\nRun time output for part B: " + (endTime - startTime) + "ns");
	}
}
