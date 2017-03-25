import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
* Reads bank accounts from a file and prints highest balance.
*/
public class BankReader {

	/**
	Prompts for and reads name of file to process.
	@param in Scanner from which to read
	@return file name
	*/
	private static String getFileName(Scanner in)
	{
		String filename = null;
		System.out.println("Enter file to process: ");
		if (in.hasNext())
		{
			filename = in.next();
		}
		return filename;
	}

	public static void main(String[] args)
	{
		Bank bank = new Bank();
		Scanner in = new Scanner(System.in);
		String filename = getFileName(in);
		
		boolean done = false;
		while(!done)
		{
			try
			{
				bank.readFile(filename);//read the file
				BankAccount OBJ = bank.getHighestBalance(); //display the highest balance
				System.out.println("Account number: " + OBJ.getAccountNumber());
				System.out.println("Highest balance is $" + OBJ.getBalance());
				done = true;
			} 
			//catch file not found exception and get the file name again
			catch (FileNotFoundException exception)
			{
				System.err.println(filename + " not found");
				filename = getFileName(in);
			}
			//catch for improperly formatted line and get the file name again
			catch (IOException e)
			{
				System.err .println(filename + " contains improperly formatted line\n");
				filename = getFileName(in);
			}
		}
	}
}
