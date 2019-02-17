import java.util.ArrayList;
import java.util.Collections;

public class Matrix
{
	public ArrayList<Integer> Indexes, Values, Weights;
	public ArrayList<Double> Ratios; 
	
	Matrix(ArrayList<Integer> indexes,
		ArrayList<Integer> values,
		ArrayList<Integer> weights,
		ArrayList<Double> ratios)
	{
		Indexes = indexes;
		Values = values;
		Weights = weights;
		Ratios = ratios;
	}
	
	public void SortByIndexes ()
	{
		int inOrder = 1;
		
		while(inOrder != 0)
		{
			inOrder = 0;
			
			for(int i = 0; i < Indexes.size() - 1; i++)
			{
				if (Indexes.get(i) > Indexes.get(i+1))
				{
					Collections.swap(Indexes, i, i+1);
					Collections.swap(Values, i, i+1);
					Collections.swap(Weights, i, i+1);
					Collections.swap(Ratios, i, i+1);
				}
			}
			
			for(int i = 0; i < Indexes.size() - 1; i++)
			{
				if (Indexes.get(i) > Indexes.get(i+1))
				{
					inOrder++; 
				}
			}
		}
	}
	
	public void SortByValues ()
	{
		int inOrder = 1;
		
		while(inOrder != 0)
		{
			inOrder = 0;
			
			for(int i = 0; i < Values.size() - 1; i++)
			{
				if (Values.get(i) < Values.get(i+1))
				{
					Collections.swap(Indexes, i, i+1);
					Collections.swap(Values, i, i+1);
					Collections.swap(Weights, i, i+1);
					Collections.swap(Ratios, i, i+1);
				}
			}
			
			for(int i = 0; i < Values.size() - 1; i++)
			{
				if (Values.get(i) < Values.get(i+1))
				{
					inOrder++; 
				}
			}
		}
	}
	
	public void SortByWeights ()
	{
		int inOrder = 1;
		
		while(inOrder != 0)
		{
			inOrder = 0;
			
			for(int i = 0; i < Weights.size() - 1; i++)
			{
				if (Weights.get(i) > Weights.get(i+1))
				{
					Collections.swap(Indexes, i, i+1);
					Collections.swap(Values, i, i+1);
					Collections.swap(Weights, i, i+1);
					Collections.swap(Ratios, i, i+1);
				}
			}
			
			for(int i = 0; i < Weights.size() - 1; i++)
			{
				if (Weights.get(i) > Weights.get(i+1))
				{
					inOrder++; 
				}
			}
		}
	}
	
	public void SortByRatios ()
	{
		int inOrder = 1;
		
		while(inOrder != 0)
		{
			inOrder = 0;
			
			for(int i = 0; i < Ratios.size() - 1; i++)
			{
				if (Ratios.get(i) < Ratios.get(i+1))
				{
					Collections.swap(Indexes, i, i+1);
					Collections.swap(Values, i, i+1);
					Collections.swap(Weights, i, i+1);
					Collections.swap(Ratios, i, i+1);
				}
			}
			
			for(int i = 0; i < Ratios.size() - 1; i++)
			{
				if (Ratios.get(i) < Ratios.get(i+1))
				{
					inOrder++; 
				}
			}
		}
	}
	
	public void DebugAll()
	{
		//Collections.swap(arg0, arg1, arg2);
		System.out.println("=== Debug ===");
		System.out.println("=== Indexes ===");
		for (Integer i : Indexes)
		{
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("=== Values ===");
		for (Integer i : Values)
		{
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("=== Weights ===");
		for (Integer i : Weights)
		{
			System.out.print(i + " ");
		}
		System.out.println("");
		System.out.println("=== Ratios ===");
		for (Double i : Ratios)
		{
			System.out.print(i + " ");
		}
		
		System.out.println("");
		System.out.println("");
	}
}
