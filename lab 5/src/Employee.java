/**
 * Class Employee is an abstract and a base class.
 * It stores first and last names, ID number, Sex, and birth date of employees
 * It implements Interfaces EmployeeInfo, Comparator, and Comparable
 */
import java.util.*;

public abstract class Employee implements EmployeeInfo, Comparable<Employee>, Comparator<Employee>, Cloneable{
	//attributes
	String LName, FName;
	int ID;
	char Sex;
	Calendar BDate = new GregorianCalendar();
	/**
	 * constructor
	 */
	Employee()
	{
		LName = FName = " ";
		ID = 0;
		Sex = ' ';
		BDate = Calendar.getInstance();
	}
	/**
	 * argument constructor with
	 * @param L, F, I, S, year, month, day
	 */
	Employee(String L, String F, int I, char S, int year, int month, int day)
	{
		LName = L;
		FName = F;
		ID = I;
		Sex = S;
		BDate.set(Calendar.YEAR, year);
		BDate.set(Calendar.MONTH, month);
		BDate.set(Calendar.DAY_OF_MONTH, day);
	}
	/**
	 * The toString function returns the display format
	 */
	public String toString()
	{
		return "\nID Employee number: " + ID +
				"\nEmployee name: " + FName + " " + LName +
				"\nBirth date: " + BDate.get(Calendar.YEAR) + "/" +
		BDate.get(Calendar.MONTH) + "/" + BDate.get(Calendar.DAY_OF_MONTH);
	}
	/**
	 * The following is the getters and setters of the attributes
	 */
	public final String getLName()
	{
		return LName;
	}
	public void setLName(String LN)
	{
		LName = LN;
	}
	public final String getFName()
	{
		return FName;
	}
	public void setFName(String FN)
	{
		FName = FN;
	}
	public final int getID()
	{
		return ID;
	}
	public void setID(int id)
	{
		ID = id;
	}
	public final char getSex()
	{
		return Sex;
	}
	public void setSex(char s)
	{
		Sex = s;
	}
	public final Calendar getBDate()
	{
		return BDate;
	}
	public void setBDate(Calendar bd)
	{
		BDate = bd;
	}
	/**
	 * Comparator method to compare last name of Employee
	 */
		public int compareTo(Employee obj) //ID, descending
		{
			Employee em = obj;
			if(ID == em.ID)
				return 0;
			else if(ID < em.ID)
				return 1;
			else
				return -1;
		}
	/**
	 * monthlyEarning is an abstract method
	 */
	public abstract double monthlyEarning();
}
