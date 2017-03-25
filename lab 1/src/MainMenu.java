public class MainMenu {

	public static void main(String[] args)
	{
		Fraction F1 = new Fraction();
		Fraction F2 = new Fraction();
		Fraction F3 = new Fraction();
		//user input
		System.out.println("This program does the 4 main calculations with the numbers you enter");
		F1.inputFraction();
		F2.inputFraction();
		//output results
		F3 = F1.add(F2); //result of addition
		System.out.println(F1 + " + " + F2 + " = " + F3);
		F3.sub(F1, F2); //result of subtraction
		System.out.println(F1 + " - " + F2 + " = " + F3);
		F3.mul(F1, F2); //result of multiplication
		System.out.println(F1 + " * " + F2 + " = " + F3);
		F3.div(F1, F2); //result of division
		System.out.println(F1 + " / " + F2 + " = " + F3);
		Fraction.divFraction(F1, F2); //result of the real number from the division of f1 and f2
		System.out.println(F1 + " / " + F2 + " = " + Fraction.divFraction(F1,  F2));
		F1.setNumerator(2); //sets numerator of F1 = 2
		F2.setDenominator(5); //sets denominator of F2 = 5
		System.out.println("Numerator: " + F1.getNumerator()); //prints F1 as 2
		System.out.println("Denominator: " + F2.getDenominator()); //prints F2 as 5
	}
}