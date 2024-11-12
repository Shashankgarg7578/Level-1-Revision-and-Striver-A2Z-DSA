package Arrays;

import java.util.ArrayList;

//blog : https://takeuforward.org/arrays/rearrange-array-elements-by-sign/
//Question : https://leetcode.com/problems/rearrange-array-elements-by-sign/
public class _18_Rearrange_the_array_in_alternating_positive_and_negative_items {
	public static void main(String[] args) {
		// Array Initialisation.
		int n = 4;
		int A[] = { 1, 2, -4, -5 };

		// this is for showing even , odd numbers alternatively, while positive/negative
		// occurrence are same.
		int[] ans = RearrangebySign(A, n);
		for (int i = 0; i < n; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println();
		
		// this is Optimal approach for showing even , odd numbers alternatively, while
		// positive/negative occurrence are same.
		int n2 = 4;
		int A2[] = { 1, 2, -4, -5 };
		int[] ans2 = RearrangebySign2(A2, n2);
		for (int i = 0; i < n2; i++) {
			System.out.print(ans2[i] + " ");
		}
		
		System.out.println();
		// this is Optimal approach for showing even , odd numbers alternatively, while
		// positive/negative occurrence are not same.
		int n3 = 6;
		int A3[] = { 1, 2, -4, -5, 3, 4};
		int[] ans3 = RearrangebySign3(A3, n3);
		for (int i = 0; i < n3; i++) {
			System.out.print(ans3[i] + " ");
		}

	}

	// Brute force
//	Time Complexity: O(N+N/2) 
//	Space Complexity:  O(N/2 + N/2) = O(N) 
	private static int[] RearrangebySign(int[] arr, int n) {

		ArrayList<Integer> posList = new ArrayList<Integer>();
		ArrayList<Integer> negList = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				posList.add(arr[i]);
			} else {
				negList.add(arr[i]);
			}
		}

		for (int i = 0; i < arr.length / 2; i++) {
			arr[2 * i] = posList.get(i);
			arr[2 * i + 1] = negList.get(i);
		}

		return arr;
	}

	// Better
//	Time Complexity: O(N) 
//	Space Complexity:  O(N)
	private static int[] RearrangebySign2(int[] arr, int n) {

		int[] ans = new int[arr.length];
		int posIndx = 0;
		int negIndx = 1;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > 0) {
				ans[posIndx] = arr[i];
				posIndx += 2;
			} else {
				ans[negIndx] = arr[i];
				negIndx += 2;
			}

		}

		return ans;
	}

	// 2nd Varity of Question
	// Better :- as it does not contains equal elements we are not able to solve
	// with optimal approach
//	Time Complexity: O(2*N) 
//	Space Complexity: O(N/2 + N/2) = O(N)
	private static int[] RearrangebySign3(int[] arr, int n) {
		ArrayList<Integer> posList = new ArrayList<Integer>();
		ArrayList<Integer> negList = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				posList.add(arr[i]);
			} else {
				negList.add(arr[i]);
			}
		}

		if (posList.size() < negList.size()) {
			for (int i = 0; i < posList.size(); i++) {
				arr[2 * i] = posList.get(i);
				arr[2 * i + 1] = negList.get(i);
			}

			int index = posList.size()*2;
			for(int i = posList.size(); i < negList.size() ; i++) {
				arr[index] = negList.get(i);
			    index++;
			}
			
		} else {

			for (int i = 0; i < negList.size(); i++) {
				arr[2 * i] = posList.get(i);
				arr[2 * i + 1] = negList.get(i);
			}

			int index = negList.size()*2;
			for(int i = negList.size(); i < posList.size() ; i++) {
				arr[index] = posList.get(i);
			    index++;
			}
			
		}

		return arr;
	}

}
