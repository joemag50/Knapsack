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

	// Quick sort algorithm
	public void quicksortDouble(ArrayList<Double> numbers, Integer low, Integer high)
	{
		if (low < high)
		{
			Integer dp = partitionDouble(numbers, low, high);
			quicksortDouble(numbers, low, dp-1);
			quicksortDouble(numbers, dp+1, high);
		}
	}
	
	// partition numbers[low] to numbers[high] using numbers[low] as the pivot
	private int partitionDouble(ArrayList<Double> numbers, Integer low, Integer high)
	{
		double pivot = numbers.get(low);
		Integer i = low;
		for (Integer j = low + 1; j <= high; j++)
		{
			if (numbers.get(j) < pivot) {
				++i;
				swap(i, j);
			}
		}
		swap(low, i);
		return i; 
	}
	
	// Quick sort algorithm
	public void quicksort(ArrayList<Integer> numbers, Integer low, Integer high)
	{
		if (low < high)
		{
			Integer dp = partition(numbers, low, high);
			quicksort(numbers, low, dp-1);
			quicksort(numbers, dp+1, high);
		}
	}
	
	// partition numbers[low] to numbers[high] using numbers[low] as the pivot
	private Integer partition(ArrayList<Integer> numbers, Integer low, Integer high)
	{
		Integer pivot = numbers.get(low);
		Integer i = low;
		for (Integer j = low + 1; j <= high; j++)
		{
			if (numbers.get(j) < pivot) {
				++i;
				swap(i, j);
			}
		}
		swap(low, i);
		return i; 
	}
 
	// Exchange list[i] and list[j] values
	private void swap(Integer i, Integer j)
	{
		Collections.swap(Indexes, i, j);
		Collections.swap(Values, i, j);
		Collections.swap(Weights, i, j);
		Collections.swap(Ratios, i, j);
	}
	
	public void SortByIndexes ()
	{
		int inOrder = 1;
		System.out.println("sorting...");
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
		System.out.println("Sort finish.");
	}
	
	public void SortByValues ()
	{
		int inOrder = 1;
		System.out.println("sorting...");
		/*
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
		}*/
		this.quicksort(Values, 0, Values.size()-1);
		System.out.println("Sort finish.");
	}
	
	public void SortByWeights ()
	{
		int inOrder = 1;
		System.out.println("sorting...");
		this.quicksort(Weights, 0, Weights.size()-1);
		System.out.println("Sort finish.");
	}
	
	public void SortByRatios ()
	{
		int inOrder = 1;
		System.out.println("sorting...");
		this.quicksortDouble(Ratios, 0, Ratios.size()-1);
		System.out.println("Sort finish.");
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
