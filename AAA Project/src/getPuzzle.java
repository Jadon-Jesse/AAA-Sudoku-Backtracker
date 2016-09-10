import java.util.*;
import java.io.*;

public class getPuzzle {
	
	public getPuzzle(){
		
	}
	
	
	public int[][] toInt(String [][]arr ) throws IOException
	{
		int grid[][] = new int[9][9];
		
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				grid[i][j] =Integer.parseInt(arr[i][j]);
			}
			
		}
		
		return grid;
		
		
	}
	
	
	public String[][] getGrid (String path, int num) throws IOException
	{
		String[] temp = new String[9];
		String [][] Char = new String[9][9];
		String puzzleChoice = "Grid "+num+"";//+puzzleNo;
		//System.out.println(puzzleChoice);
		
		FileReader reader = new FileReader(path);
		BufferedReader txtReader = new BufferedReader(reader);
		
		String[] textData = new String[500];
		
		for(int i=0; i<500;i++)
		{
			textData[i] = txtReader.readLine();
			
			if(textData[i].contains(puzzleChoice)) // find the grid no and get the next 9 lines
			{
				for(int j=0;j<9;j++)
				{
					temp[j]= txtReader.readLine();
					//System.out.println(temp[j]);
				}
				
				for(int k=0;k<9;k++)//store the numbers in a 2d array
				{
					for(int l=0;l<9;l++)
					{
						Char[k][l] =  temp[k].charAt(l)+"";
					}
				}
				
				break; //we can break cause we dont need anything else
				
			}
			else{
				
			}
		}
		
		txtReader.close();
		
		return Char;
		
	}
}
