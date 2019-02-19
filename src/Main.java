import java.util.Scanner;

public class Main
{
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		//JCGE
		Main m = new Main();
		int select = 0;
		
		System.out.println("file name:");
		String filename = m.sc.nextLine();
		
		String message = "Type of heuristic:\n";
		message += "(1) By value\n";
		message += "(2) By weight\n";
		message += "(3) By Ratio\n";
		select = m.ReadInt(message);
		
		System.out.println("Print vector?:");
		String print_vector = m.sc.nextLine();
		
		HeuristicArray h = new HeuristicArray(filename);

		switch (select)
		{
			case 1:
				h.Heuristic1();
				break;
			case 2:
				h.Heuristic2();
				break;
			case 3:
				h.Heuristic3();
				break;
			default:
				System.out.println("No option selected.");
				break;
		}
		h.ResultsToFile(print_vector);
	}
	
	public int ReadInt(String question)
	{
		String reader = "";
		while (!this.isInteger(reader))
		{
			System.out.println(question);
			reader = sc.nextLine();
		}
		
		return new Integer(reader);
	}
	
	public boolean isInteger(String str)
	{
		try
		{
			Integer i = Integer.parseInt(str);
		}
		catch(NumberFormatException nfe)
		{
			return false;
		}
		return true;
	}
}
