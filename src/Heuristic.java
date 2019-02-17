import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Heuristic
{
	public String NameFile;
	public int N, W;
	public ArrayList<Integer> Indexes, Values, Weights;
	public ArrayList<Double> Ratios;
	public ArrayList<Integer> Knapsack;
	
	public Matrix matrix;
	
	Heuristic (String name_file)
	{
		this.NameFile = name_file;
		this.ReadFile();
	}
	
	public void ReadFile ()
	{
		// This will reference one line at a time
		String line = null;
		Indexes = new ArrayList<Integer>();
		Values  = new ArrayList<Integer>();
		Weights = new ArrayList<Integer>();
		Ratios  = new ArrayList<Double>();
		
		try
		{
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(this.NameFile);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int i = 0, j = 0;
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
					Indexes.add(j);
					j++;
				}
				//System.out.println(line);
				i++;
			}
			// Always close files.
			bufferedReader.close();
			
			matrix = new Matrix(Indexes, Values, Weights, Ratios);
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
		for (Integer i : Knapsack)
		{
			value += matrix.Values.get(i);
			weight += matrix.Weights.get(i);
			System.out.println("i: " + i + "; v: " + matrix.Values.get(i) + "; w: " + matrix.Weights.get(i));
		}
		System.out.println("");
		
		System.out.println("Knapsack total value: " + value);
		System.out.println("Knapsack limit weight: " + this.W);
		System.out.println("Knapsack total weight: " + weight);
	}
	
	public void ResultsToFile ()
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
			writer.write("Items:\n");
			for (Integer i : Knapsack)
			{
				value += matrix.Values.get(i);
				weight += matrix.Weights.get(i);
				writer.write("i: " + i + "; v: " + matrix.Values.get(i) + "; w: " + matrix.Weights.get(i) + "\n");
			}
			writer.write("\n");
			
			writer.write("Knapsack total value: " + value + "\n");
			writer.write("Knapsack limit weight: " + this.W + "\n");
			writer.write("Knapsack total weight: " + weight + "\n");
			
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void Heuristic1 ()
	{
		matrix.SortByValues();
		matrix.DebugAll();
		
		Knapsack = new ArrayList<Integer>();
		int KnapsackEmptySpace = W;
		
		for (Integer i : matrix.Indexes)
		{
			if (matrix.Weights.get(i) <= KnapsackEmptySpace)
			{
				Knapsack.add(i);
				KnapsackEmptySpace -= matrix.Weights.get(i);
			}
		}
		
		this.Resluts();
	}
	
	public void Heuristic2 ()
	{
		matrix.SortByWeights();
		matrix.DebugAll();
		
		Knapsack = new ArrayList<Integer>();
		int KnapsackEmptySpace = W;
		
		for (Integer i : matrix.Indexes)
		{
			if (matrix.Weights.get(i) <= KnapsackEmptySpace)
			{
				Knapsack.add(i);
				KnapsackEmptySpace -= matrix.Weights.get(i);
			}
		}
		
		this.Resluts();
	}
	
	public void Heuristic3 ()
	{
		matrix.SortByRatios();
		matrix.DebugAll();
		
		Knapsack = new ArrayList<Integer>();
		int KnapsackEmptySpace = W;
		
		for (Integer i : matrix.Indexes)
		{
			if (matrix.Weights.get(i) <= KnapsackEmptySpace)
			{
				Knapsack.add(i);
				KnapsackEmptySpace -= matrix.Weights.get(i);
			}
		}
		
		this.Resluts();
	}
}
