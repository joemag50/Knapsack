import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Heuristic
{
	public String NameFile;
	public int N, W;
	public ArrayList<Integer> Values, Weights;
	public ArrayList<Double> Ratios; 
	
	Heuristic (String name_file)
	{
		this.NameFile = name_file;
		this.ReadFile();
	}
	
	public void ReadFile ()
	{
		// This will reference one line at a time
		String line = null;
		Values  = new ArrayList<Integer>();
		Weights = new ArrayList<Integer>();
		Ratios  = new ArrayList<Double>();
		
		try
		{
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(this.NameFile);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int i = 0;
			while((line = bufferedReader.readLine()) != null)
			{
				if (i == 0)
				{
					N = new Integer(line.split(" ")[0]);
					W = new Integer(line.split(" ")[1]);
				}
				else
				{
					int v = new Integer(line.split(" ")[1]);
					int w = new Integer(line.split(" ")[2]);
					Values.add(v);
					Weights.add(w);
					Ratios.add((double) v/ (double) w);
				}
				System.out.println(line);
				i++;
			}
			// Always close files.
			bufferedReader.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println(String.format("Unable to open file %s", this.NameFile));
		}
		catch(IOException ex) {
			System.out.println(String.format("Unable to read file %s", this.NameFile));
		}
	}
}
