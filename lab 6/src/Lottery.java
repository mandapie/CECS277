/**
 * Amanda Pan
 * CECS 277
 * lab 6
 * generating lottery with tree set
 */
import java.util.*;

public class Lottery{
	
	/**
	 * generateWinNumbers generates 6 random numbers
	 * for the lottery ticket
	 * @return winSet
	 */
	public static Set<Integer> generateWiningNumbers()
    {

        Set<Integer> winSet = new TreeSet<Integer>();
        Random rand = new Random();
        while(winSet.size()<6)
        {
            Integer r = rand.nextInt(40)+1; //generate numbers from (0 - 40) + 1
            winSet.add(r);
        }
        return winSet;
    }
	/**
	 * getTicket allows user to enter 6 numbers
	 * as his ticket number
	 * @return input
	 */
	public static Set<Integer> getTicket()
	{
		Set<Integer> input = new TreeSet<Integer>();
		System.out.println("Type 6 lotto numbers: ");
		Scanner reader = new Scanner(System.in);
		while(input.size()<6)
        {
        	Integer n = reader.nextInt();
            input.add(n);
        }
        return input;
	}

	public static void main(String args[])
	{
		Set <Integer> win = generateWiningNumbers();
		Set <Integer> ticket = getTicket();
		
		System.out.println("Winning numbers: " + win);
		System.out.println("Your numbers: " + ticket);
		
		Set <Integer> matching = ticket;
		matching.retainAll(win); //keeps the matching number in the win set
		int prize;
		//System.out.println(matching.size());
		if(matching.size() == 1)
			prize = 100;
		else if(matching.size() == 2)
			prize = 200;
		else if(matching.size() == 3)
			prize = 300;
		else if(matching.size() == 4)
			prize = 400;
		else if(matching.size() == 5)
			prize = 500;
		else if(matching.size() == 6)
			prize = 600;
		else
			prize = 0;

		System.out.println("Matched numbers: " + matching);
		System.out.println("Prize: $" + prize);
    }
}