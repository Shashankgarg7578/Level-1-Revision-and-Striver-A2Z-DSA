package Arrays;

import java.util.HashMap;
import java.util.Map;

public class _26_Count_subarrays_with_given_sum {

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 4 };
		int k = 6;
		int cnt = findAllSubarraysWithGivenSum(arr, k);
		System.out.println("The number of subarrays is: " + cnt);

		int cnt2 = findAllSubarraysWithGivenSum2(arr, k);
		System.out.println("The number of subarrays is: " + cnt2);

		int cnt3 = findAllSubarraysWithGivenSum3(arr, k);
		System.out.println("The number of subarrays is: " + cnt3);
	}

	// Brute force
	// Time Complexity: O(N3)
	// Space Complexity: O(1)
	private static int findAllSubarraysWithGivenSum(int[] arr, int val) {

		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}
				if (sum == val) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	// Better
	// Time Complexity: O(N2)
	// Space Complexity: O(1)
	private static int findAllSubarraysWithGivenSum2(int[] arr, int val) {
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum == val) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	// Optimal
	// Time Complexity: O(N) or O(N*logN)
	// Space Complexity: O(1)
	private static int findAllSubarraysWithGivenSum3(int[] arr, int val) {
		int n = arr.length; // size of the given array.
		Map<Integer, Integer> mpp = new HashMap<Integer, Integer>();
		int preSum = 0, cnt = 0;

		mpp.put(0, 1); // Setting 0 in the map.
		for (int i = 0; i < n; i++) {
			// add current element to prefix Sum:
			preSum += arr[i];

			// Calculate x-k:
			int remove = preSum - val;

			// Add the number of subarrays to be removed:
			cnt += mpp.getOrDefault(remove, 0);

			// Update the count of prefix sum
			// in the map.
			mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
		}
		return cnt;
	}

}
