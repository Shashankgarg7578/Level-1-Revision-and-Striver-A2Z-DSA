package _10_Binary_Search._02_BS_on_Answers;

import java.util.Arrays;

//https://leetcode.com/problems/magnetic-force-between-two-balls/description/

//here we started new Category of Questions for Binary Search in which 
// these types of question contains max of min OR min of max

public class _21_Aggressive_Cows {
	public static void main(String[] args) {
		int[] stalls = { 0, 3, 4, 7, 10, 9 };
		int k = 4;
		int ans = aggressiveCows(stalls, k);
		System.out.println("The maximum possible minimum distance is: " + ans);

		int ans2 = aggressiveCows2(stalls, k);
		System.out.println("The maximum possible minimum distance is: " + ans2);

	}

	// Brute force
//	Time Complexity: O(NlogN) + O(N *(max(stalls[])-min(stalls[])))
	private static int aggressiveCows(int[] stalls, int k) {

		int n = stalls.length;

		Arrays.sort(stalls);

		int limit = stalls[n - 1] - stalls[0];

		for (int i = 1; i < limit; i++) {

			if (canWePlace(stalls, i, k) == false) {
				return (i - 1);
			}
		}

		return limit;
	}

	private static boolean canWePlace(int[] stalls, int dist, int cows) {
		int n = stalls.length;

		int cntCows = 1;// no. of cows placed

		int last = stalls[0];// position of last placed cow.

		for (int i = 1; i < n; i++) {
			if (stalls[i] - last >= dist) {
				cntCows++;// place next cow.
				last = stalls[i];// update the last location.
			}

			if (cntCows >= cows) {
				return true;
			}
		}

		return false;
	}

	// Optimal :- Binary Search
	// Time Complexity: O(NlogN) + O(N * log(max(stalls[])-min(stalls[])))
	private static int aggressiveCows2(int[] stalls, int k) {
		int n = stalls.length;

		Arrays.sort(stalls);

		int low = 1;
		int high = stalls[n - 1] - stalls[0];

		while (low <= high) {
			int mid = (low + high) / 2;

			if (canWePlace(stalls, mid, k) == true) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return high;
	}
}
