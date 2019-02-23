import java.util.ArrayList;
import java.util.Collections;

public class MatrixArray
{
	public Double[][] matrix;
	public int N;
	
	//public Double[] Indexes, Values, Weights;
	//public Double[] Ratios; 
	
	MatrixArray(int n, Double[] indexes,
		Double[] values,
		Double[] weights,
		Double[] ratios)
	{
		this.N = n;
		
		matrix = new Double[n][4];
		for (int i = 0; i < n; i++)
		{
			matrix[i][0] = indexes[i];
			matrix[i][1] = values[i];
			matrix[i][2] = weights[i];
			matrix[i][3] = ratios[i];
		}
	}
	
	public void DebugAll()
	{
		//Collections.swap(arg0, arg1, arg2);
		System.out.println("=== Debug ===");
		System.out.println("=== Indexes ===");
		for (int i = 0; i < N; i++)
		{
			System.out.print(matrix[i][0] + " ");
		}
		
		System.out.println("");
		System.out.println("=== Values ===");
		for (int i = 0; i < N; i++)
		{
			System.out.print(matrix[i][1] + " ");
		}
		
		System.out.println("");
		System.out.println("=== Weights ===");
		for (int i = 0; i < N; i++)
		{
			System.out.print(matrix[i][2] + " ");
		}
		System.out.println("");
		System.out.println("=== Ratios ===");
		for (int i = 0; i < N; i++)
		{
			System.out.print(matrix[i][3] + " ");
		}
		
		System.out.println("");
		System.out.println("");
	}
}
