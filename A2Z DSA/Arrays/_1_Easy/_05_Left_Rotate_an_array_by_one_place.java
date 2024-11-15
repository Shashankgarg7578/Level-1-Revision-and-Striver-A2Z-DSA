package Arrays._1_Easy;
//blog : https://takeuforward.org/data-structure/left-rotate-the-array-by-one/
//Question : https://leetcode.com/problems/rotate-array/
public class _05_Left_Rotate_an_array_by_one_place {
	public static void main(String[] args) {

		int n = 5;

		int arr[] = { 1, 2, 3, 4, 5 };
		solve(arr, n);

	}

	// Optimal
//	Time Complexity: O(n), as we iterate through the array only once.
//	Space Complexity: O(1) as no extra space is used
	private static void solve(int[] arr, int n) {

		int temp = arr[0];

		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}

		arr[arr.length - 1] = temp;

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
}
