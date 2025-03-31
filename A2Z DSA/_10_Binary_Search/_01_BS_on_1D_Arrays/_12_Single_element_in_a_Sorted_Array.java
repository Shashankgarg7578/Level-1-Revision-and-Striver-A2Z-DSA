package _10_Binary_Search._01_BS_on_1D_Arrays;

public class _12_Single_element_in_a_Sorted_Array {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6 };
		int ans = singleNonDuplicate(arr);
		System.out.println("The single element is: " + ans);

		
		int ans3 = singleNonDuplicate3(arr);
		System.out.println("The single element is: " + ans3);
		
	}

	// Brute Force
	private static int singleNonDuplicate(int[] arr) {
		int n = arr.length;

		if (n == 1) {
			return arr[0];
		}

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				if (arr[i] != arr[i + 1]) {
					return arr[i];
				}
			} else if (i == n - 1) {
				if (arr[i] != arr[i - 1]) {
					return arr[i];
				}
			} else {
				if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1]) {
					return arr[i];
				}
			}
		}

		return -1;
	}

	// Brute Force
	private static int singleNonDuplicate2(int[] arr) {

		int n = arr.length; // size of the array.
		int ans = 0;
		// XOR all the elements:
		for (int i = 0; i < n; i++) {
			ans = ans ^ arr[i];
		}

		return ans;
	}

	// Optimal by Binary Search
//	Time Complexity: O(logN), N = size of the given array.
//	Space Complexity: O(1) as we are not using any extra space.
	private static int singleNonDuplicate3(int[] arr) {

		int n = arr.length;

		if (n == 1)
			return arr[0];
		if (arr[0] != arr[1])
			return arr[0];
		if (arr[n - 1] != arr[n - 2])
			return arr[n - 1];

		int low = 1;
		int high = n - 2;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) {
				return arr[mid];
			}

			if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
				// we are on Left side where all elements are duplicate
				low = mid + 1;
			} else {
				// we are on Right side where all elements are duplicate
				high = mid - 1;
			}

		}

		return -1;
	}

}
