import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader =  
                new BufferedReader(new InputStreamReader(System.in)); 
		int numberN, numberS, numberL;
		
		List<InputSquare> S = new ArrayList<InputSquare>();
		List<Integer> L = new ArrayList<Integer>();
		// TODO Auto-generated method stub
		System.out.print( "Enter N: " );
		numberN = Integer.parseInt(reader.readLine());
		
		System.out.print( "Enter S: " );
		numberS = Integer.parseInt(reader.readLine());
		
		int count = 0;
		while (count < numberS) {
			String tempString = reader.readLine();			
			String[] tempList = tempString.split(" ");
			if(tempList.length != 3) {				
				continue;
			}
			
			List<Integer> temp = new ArrayList<Integer>();
			for (String a : tempList) {
				try
			    {
			       int i = Integer.parseInt(a);
			       temp.add(i);
			    }
			    catch (NumberFormatException nfe)
			    {
			      	continue;
			    }
			}
			
			S.add(new InputSquare(numberN, temp.get(0), temp.get(1), temp.get(2)));	
			count++;
		}
		
		S.add(new InputSquare(numberN, 1, 2, 3));		
		
		for(int i = 0; i < S.size(); i++) {
			drawSquare(S.get(i).getLargeSquare());
        }
	}

	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}
	
	public static void drawSquare(int[][]square) {
		int i, j;
		int length = square.length;
		
		for(i = 0; i < length; i++)
		{
			for(j = 0; j < length; j++)
			{
				System.out.print(square[i][j] + " ");
			}
			System.out.println("\n"); 
		}
	}
}

