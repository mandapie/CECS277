import java.util.ArrayList;
import java.util.Comparator;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;
/**
* A bank contains account numbers and balances of each customer.
*/
public class Bank implements Comparator<BankAccount>{

	private ArrayList<BankAccount>accountList;
	/**
	* Construct a Bank object.
	*/
	public Bank()
	{
		accountList = new ArrayList();
	}
	/**
	* Reads a file with account numbers and balances and adds the accounts
	* to the bank.
	* @param filename the name of the file
	 * @throws IOException 
	*/
	public void readFile(String filename) throws IOException
	{ 
		//Create File object, a scanner object to read data from the file.
		//call the method read 
		File reader = new File(filename);
		Scanner in = new Scanner(reader);
		try
		{
			read(in);
		}
		finally
		{
			in.close();
		}
	}
	/**
	* Read a file with account numbers and balances and adds the accounts
	* to the bank.
	* @param in the scanner for reading the input
	 * @throws IOException 
	*/
	private void read(Scanner in) throws IOException
	{
		while (in.hasNext())
		{	
			BankAccount obj = new BankAccount(); //Create a BankAccount object
			obj.read(in); //input data for the BankAccount object
			addAccount(obj); //Add the BankAccount object to the accountlist 
		}
	}
	/**
	* Add an account to the bank.
	* @param obj the BankAccount reference
	*/
	public void addAccount(BankAccount obj)
	{
		accountList.add(obj);
	}
	public int compare(BankAccount obj1, BankAccount obj2)
	{
		BankAccount ba1 = obj1;
		BankAccount ba2 = obj2;
		if(ba1.getBalance() > ba2.getBalance())
		{
			return 1;
		}
		else
			return -1;
	}
	/**
	* Gets the account with the highest balance.
	* @return the account with the highest balance
	*/
	public BankAccount getHighestBalance()
	{
		BankAccount store = accountList.get(0);
		for(int i=1; i<accountList.size(); i++)
		{
			if(compare(store,accountList.get(i)) == -1)
			{
				store = accountList.get(i);
			}
		}
		return store;
	}
}
