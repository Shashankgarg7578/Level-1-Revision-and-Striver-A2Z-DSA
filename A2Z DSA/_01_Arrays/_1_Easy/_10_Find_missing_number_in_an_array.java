package _01_Arrays._1_Easy;

//blog : https://takeuforward.org/arrays/find-the-missing-number-in-an-array/
//Question : https://leetcode.com/problems/missing-number/
public class _10_Find_missing_number_in_an_array {

	public static void main(String[] args) {
		// total numbers
		int N = 5; 
		
		// arr.length is always lesser then N, 
		//because one number in array always missing.
		int a[] = { 1, 2, 4, 5 }; 
		
		int ans = missingNumber(a, N);
		System.out.println("The missing number is: " + ans);

		int ans2 = missingNumber2(a, N);
		System.out.println("The missing number is: " + ans2);

		int ans3 = missingNumber3(a, N);
		System.out.println("The missing number is: " + ans3);

		int ans4 = missingNumber4(a, N);
		System.out.println("The missing number is: " + ans4);
	}

	// Brute force
//	Time Complexity: O(N^2), where N = size of the array+1.
//  Space Complexity: O(1)  
	private static int missingNumber(int[] arr, int n) {

		// It run for 'n' Numbers.
		for (int i = 1; i <= n; i++) {
			int flag = 0;

			//this loop is for i number exist or not
			for (int j = 0; j < n - 1; j++) {
				if (arr[j] == i) {
					flag = 1;
					break;
				}
			}

			//if i number not exist then that is missing
			if (flag == 0) {
				return i;
			}
		}

		return -1;
	}

	// Better
//	Time Complexity: O(N) + O(N) ~ O(2*N),  where N = size of the array+1.
//	Reason: For storing the frequencies in the hash array, the program takes O(N) time complexity and for checking the frequencies in the second step again O(N) is required. So, the total time complexity is O(N) + O(N).

//  Space Complexity: O(N), where N = size of the array+1. Here we are using an extra hash array of size N+1.
	private static int missingNumber2(int[] arr, int n) {

		int[] hash = new int[n + 1];

		// storing the frequencies:
		for (int i = 0; i < n - 1; i++)
			hash[arr[i]]++;

		for (int i = 1; i < n - 1; i++) {
			if (hash[i] == 0) {
				return i;
			}
		}

		return -1;
	}

	// Optimal :- we have 2 types of approach for optimal. 1.Sum , 2. XOR

	// 1. This Optimal solution for `SUM`
//	Time Complexity: O(N)
//	Space Complexity: O(1)
	private static int missingNumber3(int[] arr, int n) {

		// this will give sum of all numbers form 1 to n.
		int allSum = (n * (n + 1)) / 2;

		int arrSum = 0;
		for (int i = 0; i < arr.length; i++) {

			arrSum += arr[i];
		}

		return allSum - arrSum;
	}

	// 2. This Optimal solution for `XOR`
	// example :- 1.) 2 ^ 2 = 0, 2.) 1^2^3^4^5 ^ 1^2^4^5 = 3
//	Time Complexity: O(N)
//	Space Complexity: O(1) 
	private static int missingNumber4(int[] arr, int n) {
		int xor1 = 0, xor2 = 0;

		for (int i = 0; i < arr.length; i++) {
			xor2 = xor2 ^ arr[i]; // XOR of array elements
			xor1 = xor1 ^ (i + 1); // XOR up to [1...N-1]
		}
		xor1 = xor1 ^ n; // XOR up to [1...N], so this is for last element 

		return (xor1 ^ xor2); // the missing number

	}

}
