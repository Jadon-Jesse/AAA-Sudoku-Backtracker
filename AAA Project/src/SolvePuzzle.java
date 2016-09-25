import java.io.IOException;
import java.util.*;

public class SolvePuzzle {
	
	public static int N=9;
	public static int ROW;
	public static int COL;
	public static int[][] grid;



	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int puzzleNum = 0;
		String path = "C:/Users/Jadon/WorkSpace3Y/AAA-Sudoku-Backtracker/AAA Project/src/sudoku.txt";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Choose puzzle between 1 & 51 ");
		puzzleNum = sc.nextInt();
		
		
		while(puzzleNum<1 || puzzleNum >51){
			System.out.println("Out of bounds");
			System.out.println("Choose puzzle between 1 & 51 ");
			puzzleNum = sc.nextInt();
		}
		
		getPuzzle obj = new getPuzzle();
		String[][] boardTmp=obj.getGrid(path, puzzleNum);
		grid = obj.toInt(boardTmp);
		
		print(grid);
		
		System.out.println();
		System.out.println("Solving...");
		System.out.println();
		
		//Solve the puzzle and measure the time
		
		long start = System.nanoTime();
		boolean answer = solve(); 
		long end = System.nanoTime();
		
		long t= end-start;
		double time = t/1000000000.0; //convert ns to sec.
		
		if(answer){
			print(grid);
			System.out.println("Time taken :"+time);
		}
	    else
	         System.out.printf("No solution exists");		
		

	}
	
	public static boolean solve()
	{
		//find the unassigned cell
		int[] temp = FindEmpty();
		 
		//Assign the cords to row and col if they exsist
		if (temp != null)
		{
			int row =temp[0];
			int col =temp[1];
			
			//Try all values in that cell from 1 to 9
			for(int i=1;i<=N;i++)
			{
				//Can we make a legal insert?
				if (isSafe(row,col,i))
				{
					//If yes, Assugn the value to the cell
					grid[row][col]=i;
					
					//Re call solve, and if there is no unassigned cell
					//If true, then we're done son!
					if (solve()){
						return true;
					}
					//otherwise, we messed up. Delete and try again
					grid[row][col]=0;
				}
			}
		}
		
		else{
			return true;
		}
		
	  return false; //This line enables backtracking
		
	}
	
	//This function does all necessary checks
	public static boolean isSafe(int row,int col,int num){
		boolean ret = checkRow(row,col,num) && checkCol(row,col,num) && checkGrid(row,col,num);
		return ret;
	}
	
	public static int[] FindEmpty()
	{
		int[] cords = new int[2];
		for (int i =0;i<grid.length;i++){
			for(int j =0;j<grid.length;j++){
				if (grid[i][j]==0){
					cords[0]=i;
					cords[1]=j;
					return cords;
				}
			}
		}
		return null;
	}
	//Checks if the value is in that row allready
	public static boolean checkRow(int row,int col,int num)
	{
		for(int i =0;i<grid.length;i++){
			if(grid[row][i]==num){
				return false;
			}
		}
	  return true;
	}
	//Checks if the value is in that col allready
	public static  boolean checkCol(int row,int col,int num)
	{
		for(int i =0;i<grid.length;i++){
			if(grid[i][col]==num){
				return false;
			}
		}
	  return true;
	}
	 //Checks if the value exsists in the grid
	public static boolean checkGrid(int row,int col,int num)
	{
		//these calculations allow us to go to the start of each subgrid to find the value
		row=row-(row%3);
		col = col-(col%3);
		 
		for (int i =0;i<3;i++){
			for(int j =0;j<3;j++){
				if (grid[i+row][j+col]==num){
					return false;
				}
			}
		}
		
	  return true; 
	}
	

	public static void print(int[][] grid)
	{
		for(int i=0;i<9;i++){
			for(int k=0;k<9;k++){
				System.out.print(grid[i][k]+" ");
			}
			System.out.println();
		}
	}

}
