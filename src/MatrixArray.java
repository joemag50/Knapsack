import java.util.ArrayList;
import java.util.Collections;

public class MatrixArray
{
	public Double[] Indexes, Values, Weights;
	public Double[] Ratios; 
	
	MatrixArray(Double[] indexes,
		Double[] values,
		Double[] weights,
		Double[] ratios)
	{
		Indexes = indexes;
		Values = values;
		Weights = weights;
		Ratios = ratios;
	}
	
	public void DebugAll()
	{
		//Collections.swap(arg0, arg1, arg2);
		System.out.println("=== Debug ===");
		System.out.println("=== Indexes ===");
		for (int i = 0; i < Indexes.length; i++)
		{
			System.out.print(Indexes[i] + " ");
		}
		
		System.out.println("");
		System.out.println("=== Values ===");
		for (int i = 0; i < Values.length; i++)
		{
			System.out.print(Values[i] + " ");
		}
		
		System.out.println("");
		System.out.println("=== Weights ===");
		for (int i = 0; i < Weights.length; i++)
		{
			System.out.print(Weights[i] + " ");
		}
		System.out.println("");
		System.out.println("=== Ratios ===");
		for (int i = 0; i < Ratios.length; i++)
		{
			System.out.print(Ratios[i] + " ");
		}
		
		System.out.println("");
		System.out.println("");
	}
}
