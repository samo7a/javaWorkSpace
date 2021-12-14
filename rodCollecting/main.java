import java.util.*;
public class main{
	public static void main(String args[]){
		//scanner object
		Scanner scnr = new Scanner(System.in);
		// read in the first two values
		long c = scnr.nextLong() * 1000; // read in the capacity multiplied by 1000
		int r = scnr.nextInt(); // number of rods
		int answerSize = 1; // this will be the size of our answer array
		int value [] = new int[r];
		long weight [] = new long[r];
		for (int i = 0; i < r; i++){
			// read in all the values and weights for each rod.
			int v = scnr.nextInt(); // value;
			// read in the wieght multiplied by 1000 and typecasted to long
			long w = (long) (scnr.nextDouble() * 1000);
			value[i] = v;
			weight[i] = w;
			answerSize = answerSize + v; // accumulate the answerSize
		}
		long answer [] = new long[answerSize]; // this will hold our answer
		// fill the array with a very big number
		Arrays.fill( answer, (long) Integer.MAX_VALUE); 
		answer[0] = 0;	// initialize the first eleement to zero

		// the algorithm itself (logic)

		// for each rod do the following...
		for (int i = 0; i < r; i++){ 
			int val = value[i];
			long wt = weight[i];
			// for each element in the answer array do the following...
			for (int j = answerSize - 1; j >= val; j--){
				// the possibleWeight var will hold the possibleWeight
				// that might be choosen which is equal to 
				// the current weight plus the weight at the 
				// value that we want to add
				long possibleWeight = answer[j - val] + wt;
				// we will choose the minimum value to update our value.
				answer[j] = Math.min(possibleWeight, answer[j]);
			}
		}
		// to get the max value
		// we will loop through the answer array in the reverse direction
		// the value that corresponds to the first weight that is equal
		// or smaller than the capacity will be our answer(max value)
		// 
		for(int i = answerSize - 1; i >= 0; i--){
			if (answer[i] <= c){
				System.out.println(i);
				break;
			}
		}
	}

}

