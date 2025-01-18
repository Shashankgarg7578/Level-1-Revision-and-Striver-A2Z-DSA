package _01_Arrays._1_Easy;

public class _08_Linear_Search {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		int num = 4;

		int val = search(arr, arr.length, num);
		System.out.print(val);
	}

	// Optiomal
//	Time Complexity: O(n), where n is the length of the array.
//	Space Complexity: O(1)
	public static int search(int arr[], int n, int num) {
		int i;
		for (i = 0; i < n; i++) {
			if (arr[i] == num)
				return i;
		}
		return -1;
	}
}
