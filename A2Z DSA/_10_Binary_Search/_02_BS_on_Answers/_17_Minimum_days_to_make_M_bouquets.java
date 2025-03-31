package _10_Binary_Search._02_BS_on_Answers;

public class _17_Minimum_days_to_make_M_bouquets {
	public static void main(String[] args) {
		int[] arr = { 7, 7, 7, 7, 13, 11, 12, 7 };
		int k = 3; // adjecents flower required
		int m = 2; // no. of bouquets
		int ans = roseGarden(arr, k, m);
		if (ans == -1)
			System.out.println("We cannot make m bouquets.");
		else
			System.out.println("We can make bouquets on day " + ans);
		
		

		int ans2 = roseGarden2(arr, k, m);
		if (ans2 == -1)
			System.out.println("We cannot make m bouquets.");
		else
			System.out.println("We can make bouquets on day " + ans2);
		
	}

	// Brute force
	// Time Complexity: O((max(arr[])-min(arr[])+1) * N)
	// Space Complexity: O(1)
	private static int roseGarden(int[] arr, int k, int m) {
		long val = (long) m * k;
		int n = arr.length;

		if (val > n) {
			// making bouquets not possible
			return -1;
		}

		int mini = Integer.MAX_VALUE;
		int maxi = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			mini = Math.min(mini, arr[i]);
			maxi = Math.max(maxi, arr[i]);
		}

		for (int i = mini; i < maxi; i++) {
			if (possible(arr, i, m, k)) {
				return i;
			}
		}

		return -1;
	}

	private static boolean possible(int[] arr, int day, int m, int k) {

		int n = arr.length;

		int cnt = 0;
		int noOfB = 0;

		// traverse array and Count the number of bouquets:
		for (int i = 0; i < n; i++) {

			// check for day is possible or not
			if (arr[i] <= day) {
				cnt++;
			} else {
				noOfB += (cnt / k);
				cnt = 0;
			}

		}

		noOfB += (cnt / k);

		return noOfB >= m;
	}

	// Optimal by Binary Search
	private static int roseGarden2(int[] arr, int k, int m) {

		long val = (long) m * k;
		int n = arr.length;

		if (val > n) {
			// making bouquets not possible
			return -1;
		}

		int mini = Integer.MAX_VALUE;
		int maxi = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			mini = Math.min(mini, arr[i]);
			maxi = Math.max(maxi, arr[i]);
		}
		
		int low = mini, high = maxi;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (possible(arr, mid, m, k)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return low;
	}

}
