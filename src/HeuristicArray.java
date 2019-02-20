import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HeuristicArray
{
	public String NameFile;
	public int N, W;
	public Double[] Indexes, Values, Weights;
	public Double[] Ratios;
	public Double[] Knapsack;
	
	public MatrixArray matrix;
	
	HeuristicArray (String name_file)
	{
		this.NameFile = name_file;
		this.ReadFile();
	}
	
	public void ReadFile ()
	{
		// This will reference one line at a time
		String line = null;
		
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
					
					Indexes = new Double[N];
					Values  = new Double[N];
					Weights = new Double[N];
					Ratios  = new Double[N];
				}
				else
				{
					int index = new Integer(line.split(" ")[0]);
					double v = new Double(line.split(" ")[1]);
					double w = new Double(line.split(" ")[2]);
					Values[index] = v;
					Weights[index] = w;
					Ratios[index] = ((double) v/ (double) w);
					Indexes[index] = (double) index;
				}
				//System.out.println(line);
				i++;
			}
			// Always close files.
			bufferedReader.close();
			
			matrix = new MatrixArray(Indexes, Values, Weights, Ratios);
		}
		catch(FileNotFoundException ex)
		{
			System.out.println(String.format("Unable to open file %s", this.NameFile));
		}
		catch(IOException ex) {
			System.out.println(String.format("Unable to read file %s", this.NameFile));
		}
	}
	
	public void Resluts ()
	{
		System.out.println("Results");
		
		int value = 0, weight = 0;
		System.out.println("Items: ");
		for (int i = 0; i < Knapsack.length; i++)
		{
			if (Knapsack[i] == null)
			{
				continue;
			}
			else
			{
				value += matrix.Values[i];
				weight += matrix.Weights[i];
				System.out.println(String.format("i: %s; v: %s; w: %s", Knapsack[i], matrix.Values[i], matrix.Weights[i]) );
			}
		}
		System.out.println("");
		
		System.out.println("Knapsack total value: " + value);
		System.out.println("Knapsack limit weight: " + this.W);
		System.out.println("Knapsack total weight: " + weight);
	}
	
	public void ResultsToFile (String print_vector)
	{
		File file = new File(this.NameFile + ".result"); 
		try {
			if (file.createNewFile())
			{
				System.out.println(String.format("File is created %s!", file.getName()));
			} else {
				System.out.println("File already exists.");
			}
			
			FileWriter writer = new FileWriter(file);
			writer.write("Results\n");
			int value = 0, weight = 0;
			if (print_vector.equals("true"))
			{
				writer.write("Items:\n");
				for (int i = 0; i < Knapsack.length; i++)
				{
					if (Knapsack[i] == null)
					{
						continue;
					}
					value += matrix.Values[i];
					weight += matrix.Weights[i];
					writer.write(String.format("i: %s; v: %s; w: %s\n", Knapsack[i], matrix.Values[i], matrix.Weights[i]) );
				}
			}
			else
			{
				for (int i = 0; i < Knapsack.length; i++)
				{
					if (Knapsack[i] == null)
					{
						continue;
					}
					value += matrix.Values[i];
					weight += matrix.Weights[i];
				}
			}

			writer.write("\n");
			
			writer.write("Knapsack total value: " + value + "\n");
			writer.write("Knapsack limit weight: " + this.W + "\n");
			writer.write("Knapsack total weight: " + weight + "\n");
			
			writer.close();
			
			System.out.println("File finished..");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void Compare ()
	{
		Knapsack = new Double[N];
		int KnapsackEmptySpace = W;
		for (int i = 0; i < matrix.Indexes.length; i++)
		{
			if (matrix.Weights[i] <= KnapsackEmptySpace)
			{
				Knapsack[i] = matrix.Indexes[i];
				KnapsackEmptySpace -= matrix.Weights[i];
			}
		}
	}
	
	public void Heuristic1 ()
	{
		System.out.println("sorting...");
		java.util.Arrays.sort(matrix.Values, Collections.reverseOrder());
		System.out.println("finish sorting");
		this.Compare();
	}
	
	public void Heuristic2 ()
	{
		System.out.println("sorting...");
		java.util.Arrays.sort(matrix.Weights);
		System.out.println("finish sorting");
		this.Compare();
	}
	
	public void Heuristic3 ()
	{
		System.out.println("sorting...");
		java.util.Arrays.sort(matrix.Ratios, Collections.reverseOrder());
		System.out.println("finish sorting");
		this.Compare();
	}
}
