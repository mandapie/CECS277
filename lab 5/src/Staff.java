/**
 * Class Staff inherits from abstract Class Employee
 * It has attributes of Employee + Hourly rate
 */
public class Staff extends Employee{
	//attributes
	double HourlyRate;
	/**
	 * constructor
	 */
	Staff()
	{
		super();
		HourlyRate = 0;
	}
	/**
	 * argument constructor with
	 * @param L, F, I, S, year, month, day, H
	 */
	Staff(String L, String F, int I, char S,int year, int month, int day, double H)
	{
		super(L, F, I, S, year, month, day); //inherits from Employee
		HourlyRate = H;
	}
	/**
	 * the following is the getters and setters of the attribute
	 */
	public double getHourlyRate()
	{
		return HourlyRate;
	}
	public void setHourlyRate(double hr)
	{
		HourlyRate = hr;
	}
	/**
	 * the abstract method returns the multiplication
	 * of HourlyRate and STAFF_MONTHLY_HOURS_WORKED
	 */
	public double monthlyEarning()
	{
		return HourlyRate * STAFF_MONTHLY_HOURS_WORKED;
	}
	/**
	 * returns the display format from Employee and entered format
	 */
	public String toString()
	{
		return super.toString() + "\nFull time monthly salary: $" + monthlyEarning();
	}
	@Override
	public int compareTo(Employee obj) {
		Employee em = obj;
		if(ID == em.ID)
			return 0;
		else if(ID < em.ID)
			return 1;
		else
			return -1;
	}
	@Override
	public int compare(Employee obj1, Employee obj2) {
		Employee em1 = obj1; //Employee em1 = (Employee)obj1; -> type cast if Comparator<Employee> isn't used
		Employee em2 = obj2;
		return em1.LName.compareTo(em2.LName);
	}
}