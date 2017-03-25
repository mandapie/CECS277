/**
 * this program does the 4 main calculating functions
 * addition, subtraction, multiplication, and division
 * @author Amanda Pan
 * class: CECS 277
 */

public class Fraction extends SavitchIn //imported SavitchIn class into Fraction class
{
	
	private int numerator, denominator; //stores fraction data
	
	//default constructor
	public Fraction(){
		numerator = 0;
		denominator = 1;
	}
	//accessor for numerator
	public int getNumerator()
	{
		return numerator;
	}
	//accessor for denominator
	public int getDenominator()
	{
		return denominator;
	}
	//stores accessed data for numerator
	public void setNumerator(int n)
	{
		numerator = n;
	}
	//stores accessed data for denominator
	public void setDenominator(int d)
	{
		denominator = d;
	}
	/**
	 * user inputs integer numbers here
	 * numerator accepts all integer number
	 * denominator accepts all integer number except 0
	 * the user will have to enter any other number but 0
	 */
	public void inputFraction()
	{
		 System.out.print("Integer for numerator: ");
		 numerator = SavitchIn.readLineInt();
		 do
		 {
			 System.out.print("integer for denominator: ");
	         denominator = SavitchIn.readLineInt();
	         // make sure it is non-zero
	         if (denominator == 0)
	            System.out.println("Invalid value. Please enter a non-zero integer.");
	     }while (denominator == 0);
	}
	//returns a string in numerator/denominator form
	public String toString()
	{
		String buffer = numerator + "/" + denominator;
		return buffer;
	}
	/**
	 * calculates the greatest common denominator
	 * @param m is the greater number between the numerator and denominator
	 * @param n is the smaller number between the numerator and denominator
	 * m mods n to find the remainder it is 0
	 * @return m which is the gcd
	 */
	private int gcd(int m, int n)
	{
		int r;
		while(n!=0)
		{
			r = m%n;
			m = n;
			n = r;
		}
		return m;
	}
	/**
	 * calculates addition of f1 and f2
	 * @param f which is the second fraction
	 * @return f3 which is the sum
	 */
	public Fraction add(Fraction f)
	{
		Fraction f3 = new Fraction();
		f3.numerator = numerator*f.denominator + f.numerator*denominator;
		f3.denominator = denominator * f.denominator;
		int store = gcd(f3.numerator, f3.denominator); //finds the gcd of f3
		f3.numerator = f3.numerator/store;
		f3.denominator = f3.denominator/store;
		return f3;
	}
	/**
	 * calculates subtraction of f1 and f2
	 * @param f1 which is the first fraction
	 * @param f2 which is the second fraction
	 * f3 is the result fraction of f1 and f2
	 */
	public void sub(Fraction f1, Fraction f2)
	{
		numerator = f1.numerator*f2.denominator - f2.numerator*f1.denominator;
		denominator = f1.denominator * f2.denominator;
		int store = gcd(numerator, denominator); //finds the gcd of f3
		numerator = numerator/store;
		denominator = denominator/store;
	}
	/**
	 * calculates multiplication of f1 and f2
	 * @param f1 which is the first fraction
	 * @param f2 which is the second fraction
	 * f3 is the result fraction of f1 and f2
	 */
	public void mul(Fraction f1, Fraction f2)
	{
		numerator = f1.numerator * f2.numerator;
		denominator = f1.denominator * f2.denominator;
		int store = gcd(numerator, denominator); //finds the gcd of f3
		numerator = numerator/store;
		denominator = denominator/store;
	}
	/**
	 * calculates division of f1 and f2
	 * @param f1 which is the first fraction
	 * @param f2 which is the second fraction
	 * f3 is the result fraction of f1 and f2
	 */
	public void div(Fraction f1, Fraction f2)
	{
		numerator = f1.numerator * f2.denominator;
		denominator = f1.denominator * f2.numerator;
		int store = gcd(numerator, denominator); //finds the gcd of f3
		numerator = numerator/store;
		denominator = denominator/store;
	}
	/**
	 * returns real value(in decimal) of the division of f1 and f2
	 * @param f1 which is the first fraction
	 * @param f2 which is the second fraction
	 * @return store which is the real value of f3
	 * f3 is the result fraction of f1 and f2
	 */
	public static double divFraction(Fraction f1, Fraction f2)
	{
		Fraction f3 = new Fraction();
		f3.div(f1, f2);
		double store = ((double)f3.numerator)/((double)f3.denominator);
		return store;
	}
}
