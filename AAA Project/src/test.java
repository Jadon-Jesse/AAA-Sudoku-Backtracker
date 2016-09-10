import java.io.IOException;
import java.util.*;

public class test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int puzzleNum = 0;
		String path = "C:/Users/Jadon/WorkSpace3Y/AAA-Sudoku-Backtracker/AAA Project/src/sudoku.txt";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Choose puzzle between 1 & 50 ");
		puzzleNum = sc.nextInt();
		
		
		while(puzzleNum<1 || puzzleNum >50){
			System.out.println("Out of bounds");
			System.out.println("Choose puzzle between 1 & 50 ");
			puzzleNum = sc.nextInt();
		}
		
		getPuzzle obj = new getPuzzle();
		String[][] boardTmp=obj.getGrid(path, puzzleNum);
		int[][] board = obj.toInt(boardTmp);
		
		print(board);
		
		
		

	}
	
	public static void print(int[][] grid)
	{
		for(int i=0;i<9;i++)
		{
			for(int k=0;k<9;k++)
			{
				System.out.print(grid[i][k]);
			}
			System.out.println();
		}
	}

}
