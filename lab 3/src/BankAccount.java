import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
/**
* A bank account has a balance that can be changed by deposits and withdrawals.
*/
public class BankAccount {
	
	private double balance;
	private int accountNumber;
	/**
	* Constructs a bank account with a zero balance.
	*/
	public BankAccount()
	{
		balance = 0.0;
	}
	/**
	* Constructs a bank account with a given account number and a initial balance.
	*/
	public BankAccount(double bal)
	{
		balance = bal;
	}
	/**
	* Reads an account number and balance.
	* @param in the scanner
	* @return true if the data was read
	* false if the end of the stream was reached
	* @throws IOException 
	*/
	public void read(Scanner in) throws IOException
	{
		try
		{
			accountNumber = in.nextInt();
			balance = in.nextDouble();
		}
		catch(NoSuchElementException exception)
		{
			throw new IOException();
		}
	}
		/**
		* Deposits money into the bank account.
		* @param money the amount to deposit
		*/
		public void deposit(double money)
		{
			balance = balance + money;
			
		}
		/**
		* Withdraws money from the bank account.
		* @param money the amount to withdraw
		*/
		public void withdraw(double money)
		{
			balance = balance - money;
		}
		/**
		* Gets the current balance of the bank account.
		* @return the current balance
		*/
		public double getBalance()
		{
			return balance;
		}
		/**
		* Gets the account number of the bank account.
		* @return the account number
		*/
		public int getAccountNumber()
		{
			return accountNumber;
		}
}
