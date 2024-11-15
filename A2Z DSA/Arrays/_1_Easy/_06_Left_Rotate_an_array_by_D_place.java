package Arrays._1_Easy;

//blog : https://takeuforward.org/data-structure/rotate-array-by-k-elements/
//Question : https://leetcode.com/problems/rotate-array/
public class _06_Left_Rotate_an_array_by_D_place {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int n = arr.length; // length of array
		int k = 2; // rotate by 2
		Rotatetoleft(arr, n, k);
		System.out.print("After Rotating the elements to left ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
		int[] arr2 = { 1, 2, 3, 4, 5, 6, 7 };
		int n2 = arr2.length; // length of array
		int k2 = 3; // rotate by 2
		Rotatetoleft2(arr2, n2, k2);
		System.out.print("After Rotating the elements to left ");
		for (int i = 0; i < n2; i++) {
			System.out.print(arr2[i] + " ");
		}
	}

	// Brute force
//	Time Complexity: O(n)
//	Space Complexity: O(k) since k array element needs to be stored in temp array
	private static void Rotatetoleft(int[] arr, int n, int k) {
		if (n == 0)
			return;
		k = k % n;
		if (k > n)
			return;

		int[] temp = new int[k];
		// for storing last values which we have to rotate
		for (int i = n - k; i < n; i++) {
			temp[i - n + k] = arr[i];
		}

		// for from last to first shift
		for (int i = n - k - 1; i >= 0; i--) {
			arr[i + k] = arr[i];
		}
		// put values from temp array.
		for (int i = 0; i < k; i++) {
			arr[i] = temp[i];
		}
	}

	// Optimal :- Reversal Algorithm
//	Time Complexity - O(N) where N is the number of elements in an array
//	Space Complexity - O(1) since no extra space is required
	private static void Rotatetoleft2(int[] arr, int n, int k) {
		if (n == 0)
			return;
		k = k % n;
		if (k > n)
			return;

		reverse(arr, 0, arr.length - 1 - k);
		reverse(arr, arr.length - k, arr.length - 1);
		reverse(arr, 0, arr.length - 1);

	}

	private static void reverse(int[] arr, int i, int j) {
		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

			i++;
			j--;
		}

	}

}
