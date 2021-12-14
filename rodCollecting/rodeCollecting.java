
/*
 * Taoufik Laaroussi
 * COP3503
 * Prof.: Travis Meade
 * 11/10/2020
 * Assignment6: Rod Collecting
 * */

import java.util.*;
public class rodeCollecting {
	  public static int[] memo1;

		public static int values[];
		public static int weight[];
		public static int numRods;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Input the max value and number of rods
		int w = sc.nextInt();
		//w*=1000;
		 numRods = sc.nextInt();
		 values = new int[numRods];
		 weight = new int[numRods];
		 //Loop to handle Input of weights and values
		for(int i = 0; i<numRods; i++) {
			values[i] = sc.nextInt();
			float weightNum = sc.nextFloat();
			weightNum = Math.round(weightNum*1000/1000);
			weight[i] =(int)weightNum;
		}
		
		 memo1 = new int[w + 1];
		 
		// Solve the problem using knapsack method
		int answer = dp1(w);
	        System.out.println(answer);
		sc.close();
	}
	
	// knapsackDP to solve the problem
		
	    public static int dp1(int cap) {
	    	
	    	 for (int i = 0; i < numRods; i++) { // current item
	    	        
	    	            for (int j = cap; j > weight[i]; j--) { // current capacity
	    	                int possibleValue = values[i] + memo1[j - weight[i]];
	    	                if (possibleValue > memo1[j])
	    	                    memo1[j] = possibleValue;
	    	            }
	    	        }
	    	        return memo1[cap];
	    
		    
	}
	
	
}
