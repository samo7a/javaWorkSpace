import java.util.Scanner;
public class main{
	
	public static void main(String [] args){
		System.out.println("Case 1: movements can go only downwards or rightwards");
		System.out.println("Case 2: movements could be right, down, or diagonal right and down");
		int problemNumber = inputHandler();
		int width = 6;
		int height = 4;
		int[][] map = new int [height][width];
		for (int i = 0; i < height; i++) map[i][width - 1] = 1;
		for (int i = 0; i < width; i++) map[height - 1][i] = 1;

		for(int i = height - 2; i >= 0; i--)
			for(int j = width - 2; j >= 0; j--)
				if(problemNumber == 1)
					map[i][j] = map[i][j + 1] + map[i + 1][j];
				else map[i][j] = map[i][j + 1] + map[i + 1][j] + map[i + 1][j + 1];
	
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++) 
				System.out.printf("%4d " , map[i][j]);
			System.out.println();
		}
		System.out.println();
		System.out.println("Number of paths from location S to E is " + map[0][0]);	


		System.out.println("********* Modified Solution For the First Case Only ************");
		int [] map2 = new int[width];
		for(int i = 0; i < width; i++) map2[i] = 1;
		for(int j = 1; j < height; j++)
			for (int i = width - 2; i >= 0; i--)
				map2[i] += map2[i + 1];
			
		
		System.out.println("(Modified) Number of paths from location S to E is " + map2[0]);	

		
		
	}
	public static int inputHandler(){
		Scanner scnr = new Scanner(System.in);
		int problemNumber = 0;
		boolean isValidInput = false;
		do{
			System.out.println("Enter 1 for the first case, or 2 for the second case:...");
			try{
				problemNumber = scnr.nextInt();
			}
			catch(Exception e) {
				System.out.println(e);
				System.out.println("1 or 2 are the only valid input, please try again.");
				return inputHandler();
			}
			if (problemNumber == 1 || problemNumber == 2) isValidInput = true;
			else System.out.println("1 or 2 are the only valid input, please try again.");
		} while (!isValidInput);
		return problemNumber;

	}
}
