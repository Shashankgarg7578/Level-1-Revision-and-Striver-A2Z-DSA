package _02_Recursion._1_Basic;

public class _07_Reverse_an_array {

	
	public static void main(String[] args) {
		int n = 5;
		int arr[] = { 5, 4, 3, 2, 1 };
		reverseArray(arr, n);

		System.out.println();

		int arr2[] = { 5, 4, 3, 2, 1 };
		int n2 = arr2.length - 1;
		reverseArray2(arr2, 0, n2);
		printArray(arr2, arr2.length);
	}

	// using for loop
	static void reverseArray(int arr[], int n) {
		int[] ans = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			ans[n - i - 1] = arr[i];
		}
		printArray(ans, n);
	}

	// using recursion
	private static void reverseArray2(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		// swap
		int temp = arr[lo];
		arr[lo] = arr[hi];
		arr[hi] = temp;

		lo = lo + 1;
		hi = hi - 1;
		reverseArray2(arr, lo, hi);
	}

	static void printArray(int ans[], int n) {
		System.out.print("Reversed array is:- \n");
		for (int i = 0; i < n; i++) {
			System.out.print(ans[i] + " ");
		}
	}

	
}
