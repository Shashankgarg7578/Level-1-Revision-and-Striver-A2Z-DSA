package _01_Arrays._2_Medium;

//blog : https://takeuforward.org/data-structure/leaders-in-an-array/
//Question : https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=leaders-in-an-array
import java.util.ArrayList;
import java.util.Collections;

public class _21_Leaders_in_Array_problem {
	public static void main(String[] args) {
		// Array Initialization.
		int n = 6;
		int arr[] = { 10, 22, 12, 3, 0, 6 };

		ArrayList<Integer> ans = printLeadersBruteForce(arr, n);

		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		System.out.println();
		ArrayList<Integer> ans2 = printLeadersBruteForce2(arr, n);

		for (int i = 0; i < ans2.size(); i++) {
			System.out.print(ans2.get(i) + " ");
		}
	}

	// Brute force
	// Time Complexity: O(N^2)
	// Space Complexity: O(N)
	private static ArrayList<Integer> printLeadersBruteForce(int[] arr, int n) {
		ArrayList<Integer> ansList = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			boolean leader = true;

			// Checking whether arr[i] is greater than all
			// the elements in its right side
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					// If any element found is greater than current leader
					// curr element is not the leader.
					leader = false;
					break;
				}
			}

			// Push all the leaders in ans array.
			if (leader) {
				ansList.add(arr[i]);
			}
		}

		return ansList;
	}

	// Optimal
	// Time Complexity: O(N)
	// Space Complexity: O(N)
	private static ArrayList<Integer> printLeadersBruteForce2(int[] arr, int n) {
		ArrayList<Integer> ansList = new ArrayList<Integer>();
//		10, 22, 12, 3, 0, 6 
		int max = arr[arr.length - 1];
		ansList.add(max);

		for (int i = arr.length - 2; i >= 0; i--) {

			if(arr[i] >= max) {
				ansList.add(arr[i]);
			}
			
			max = Math.max(max, arr[i]);
		}

		Collections.sort(ansList, Collections.reverseOrder());
		  
		return ansList;
	}
}
