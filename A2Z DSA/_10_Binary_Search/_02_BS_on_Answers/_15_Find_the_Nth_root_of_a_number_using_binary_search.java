package _10_Binary_Search._02_BS_on_Answers;

public class _15_Find_the_Nth_root_of_a_number_using_binary_search {
	public static void main(String[] args) {
		int m = 27;
		int n = 3; // it means multiply 3 times
		int ans = NthRoot(n, m);
		System.out.println("The answer is: " + ans);

		int ans2 = NthRoot2(n, m);
		System.out.println("The answer is: " + ans2);
	}

	// Brute force
	private static int NthRoot(int n, int m) {

		for (int i = 0; i <= m; i++) {
			long val = funCheck(i, n);

			if (val == m) {
				return i;
			} else if (val > (long) m) {
				break;
			}

		}

		return -1;
	}

	private static long funCheck(int mid, int n) {

		long ans = 1;

		long base = mid;

		while (n > 0) {
			if (n % 2 == 1) {
				ans = ans * base;
				n = n - 1;
			} else {
				base = base * base;
				n = n / 2;
			}
		}

		return ans;
	}

	// Optimal by Binary Search as this is in Range
	private static int NthRoot2(int n, int m) {

		int low = 0;
		int high = m;

		while (low <= high) {

			int mid = (low + high) / 2;

			long midN = funCheckForBS(mid, n, m);

			if (midN == 1) {
				return mid;
			} else if (midN == 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return -1;
	}

	// Return 1 if mid == m
	// Return 0 if mid < m
	// Return 2 if mid > m
	private static long funCheckForBS(int mid, int n, int m) {

		int ans = 1;
		for (int i = 1; i <= n; i++) {
			ans = ans * mid;

			if (ans > m) {
				return 2;
			}

		}

		if (ans == m) {
			return 1;
		}

		return 0;
	}

}
