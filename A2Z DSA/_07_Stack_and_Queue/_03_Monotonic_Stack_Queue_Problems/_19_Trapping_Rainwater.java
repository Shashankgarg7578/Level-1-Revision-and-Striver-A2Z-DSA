package _07_Stack_and_Queue._03_Monotonic_Stack_Queue_Problems;

public class _19_Trapping_Rainwater {
	public static void main(String args[]) {
		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("The duplicate element is " + trap01(arr));
		System.out.println("The duplicate element is " + trap02(arr));

	}

	// Brute force
	// TC: O(2N) + O(N) ~ O(3N)
	// SC: O(2N)
	static int trap01(int[] arr) {
		int n = arr.length;
		int total = 0;

		//get all time max to left 
		int[] leftMax = new int[n];
		leftMax[0] = arr[0];
		for (int i = 1; i < n; i++) {
			leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
		}

		//get all time max to right
		int[] rightMax = new int[n];
		rightMax[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
		}

		//get min form both left or right and then subtract with arr[i]
		for (int i = 0; i < n; i++) {
			// this is the formula we can drive.
			total += Math.min(leftMax[i], rightMax[i]) - arr[i];
		}

		return total;
	}

//	1. choose only which is smaller arr[l] or arr[r], after choose
//	2. if lmax or rmax is greater then calculate with that otherwise adsign the value to that.

	// always give priority to smaller
	//Optimal
	// TC: O(N)
	// SC: O(1)
	static int trap02(int[] arr) {
		int n = arr.length;
		int lmax = 0, rmax = 0, total = 0;
		int l = 0, r = n - 1;

		while (l < r) {
			if (arr[l] <= arr[r]) {
				if (lmax > arr[l]) {
					total += lmax - arr[l];
				} else {
					lmax = arr[l];
				}
				l = l + 1;
			} else {
				if (rmax > arr[r]) {
					total += rmax - arr[r];
				} else {
					rmax = arr[r];
				}
				r = r - 1;
			}

		}

		return total;
	}

}
