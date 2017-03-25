import java.util.Calendar;

/**
 * CLass Partime inherits from Class Staff
 * It contains the attributes from Staff + HoursWorkedPerWeek
 */
public class Partime extends Staff{
	//attribute
	int HoursWorkedPerWeek;
	/**
	 * constructor
	 */
	Partime()
	{
		super();
		HoursWorkedPerWeek = 0;
	}
	/**
	 * argument constructor with
	 * @param L, F, I, S, year, month, day, H, HW
	 */
	Partime(String L, String F, int I, char S, int year, int month, int day, double H, int HW)
	{
		super(L, F, I, S, year, month, day, H);
		HoursWorkedPerWeek = HW;
	}
	/**
	 * the following is the setters and getters of the attribute
	 */
	public int getHoursWorkedPerWeek()
	{
		return HoursWorkedPerWeek;
	}
	public void setHoursWorkedPerWeek(int hwpw)
	{
		HoursWorkedPerWeek = hwpw;
	}
	/**
	 * the abstract method returns the multiplication of
	 * HourlyRate and HoursWorkedPerWeek
	 */
	public double monthlyEarning()
	{
		 return HourlyRate * HoursWorkedPerWeek * 4;
	}
	/**
	 * returns the display format from Employee and entered format
	 */
	public String toString()
	{
		return "\n\nID Employee number: " + ID +
				"\nEmployee name: " + FName + " " + LName +
				"\nBirth date: " + BDate.get(Calendar.YEAR) + "/" +
				BDate.get(Calendar.MONTH) + "/" + BDate.get(Calendar.DAY_OF_MONTH) +
				"\nHours works per month: " + HoursWorkedPerWeek +
				"\nMonthly Salary: $" + monthlyEarning();
	}
}
