package _11_Dynamic_Programming._02_1D_DP;

public class _06_House_Robber {
	public static void main(String args[]) {
		// Input array with elements. which is circular this is same as previous Question
		int arr[] = { 1,2,3,1 };

		// Get the length of the array.
		int n = arr.length;

		System.out.println(rob(n, arr));
	}

	public static int rob(int n, int[] nums) {
		int arr1[] = new int[n - 1];
		int arr2[] = new int[n - 1];

		if (n == 1) {
			return nums[0];
		}

		for (int i = 0; i < n; i++) {
			if (i != 0) {
				arr1[i-1] = nums[i];
			}
			if (i != n - 1) {
				arr2[i] = nums[i];
			}
		}

		//without first element
		int ans1 = solveByDpTabuSpaceOpt(arr1);
		
		//without last element
		int ans2 = solveByDpTabuSpaceOpt(arr2);

		return Math.max(ans1, ans2);
	}

	private static int solveByDpTabuSpaceOpt(int[] arr) {
		int prev1 = arr[0];
		int prev2 = 0;
		int curri = 0;

		for (int i = 1; i < arr.length; i++) {
			int pick = arr[i];

			if (i > 1) {
				pick += prev2;
			}

			int notPick = 0 + prev1;

			curri = Math.max(pick, notPick);
			prev2 = prev1;
			prev1 = curri;
		}

		return prev1;
	}

}
