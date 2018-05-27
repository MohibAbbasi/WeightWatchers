package assignment3;

import java.util.Scanner;
import java.util.Arrays;

public class A3 {
	
	
	 
	public static int[ ] GenerateRandom(){
		int [ ] random = new int [500];
		for (int i = 0; i < random.length; i++ ){
			random[i] = (int)(Math.random()*500+1);
		}
		return random;
	}

	
	public static int FindSmallNth(int RandInts[ ], int n){
		Arrays.sort(RandInts);	
		return RandInts[n-1];
	}

	
	public static void main(String args[ ]){

		System.out.println("Please enter a value for n: ");
		Scanner obj =  new Scanner(System. in);
		int nInput = obj.nextInt();

		int [ ] RandInts = GenerateRandom();
		int nthSmallestElement = FindSmallNth(RandInts, nInput); 
		System.out.println("Your "+nInput+"th "+"smallest number is: "+nthSmallestElement);
	}	
	
}