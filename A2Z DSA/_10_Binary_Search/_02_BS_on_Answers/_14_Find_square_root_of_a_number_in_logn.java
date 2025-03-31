package _10_Binary_Search._02_BS_on_Answers;

public class _14_Find_square_root_of_a_number_in_logn {

	public static void main(String[] args) {
		int n = 28;
		int ans = floorSqrt(n);
		System.out.println("The floor of square root of " + n + " is: " + ans);

		int ans2 = floorSqrt2(n);
		System.out.println("The floor of square root of " + n + " is: " + ans2);

		int ans3 = floorSqrt3(n);
		System.out.println("The floor of square root of " + n + " is: " + ans3);

	}

	// Brute force
	private static int floorSqrt(int n) {

		int ans = 0;

		for (int i = 1; i <= n; i++) {
			long val = i * i;
			if (val <= n) {
				ans = (int) i;
			} else {
				break;
			}
		}

		return ans;
	}

	private static int floorSqrt2(int n) {
		int ans = (int) Math.sqrt(n);
		return ans;
	}

	// Binary Search :- if we have to find min/max and we have to find data in 1 to n then we have to use BS.
//	Time Complexity: O(logN)
//	Space Complexity: O(1)
	private static int floorSqrt3(int n) {

		int ans = 1;

		int low = 1;
		int high = n;

		while (low <= high) {
			int mid = (low + high) / 2;
			long val = mid * mid;
			if (val <= n) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return ans;
	}

}
