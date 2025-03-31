package _11_Dynamic_Programming._04_DP_on_Subsequences;

public class _15_Partition_Equal_Subset_Sum {

	// same as previous but here we need to partition the array in 2 arrays,
//	and both array have equal sum elements

	public static void main(String args[]) {
		int arr[] = { 2, 3, 3, 3, 4, 5 };
		int n = arr.length;

		// Check if the array can be partitioned into two equal subsets :- {2,3,5} {3,3,4}
		if (canPartition(n, arr))
			System.out.println("The Array can be partitioned into two equal subsets");
		else
			System.out.println("The Array cannot be partitioned into two equal subsets");
	}

	//Optimal
	private static boolean canPartition(int n, int[] arr) {

		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		if (sum % 2 == 1) {
			return false;
		}

		int target = sum / 2;
		return subsetSumToK4(arr.length, target, arr);
	}

	// we are using previous question space optimized approach
	private static boolean subsetSumToK4(int n, int k, int[] arr) {

		boolean[] prev = new boolean[k + 1];

		// Initialize the first row of the DP table
		prev[0] = true;

		// Initialize the first column of the DP table
		if (arr[0] <= k) {
			prev[arr[0]] = true;
		}

		for (int ind = 1; ind < n; ind++) {
			boolean[] curr = new boolean[k + 1];
			curr[0] = true;
			for (int target = 1; target <= k; target++) {

				boolean notTaken = prev[target];
				boolean taken = false;

				if (arr[ind] <= target) {
					taken = prev[target - arr[ind]];
				}

				curr[target] = notTaken || taken;

			}
			prev = curr;
		}

		return prev[k];
	}

}
