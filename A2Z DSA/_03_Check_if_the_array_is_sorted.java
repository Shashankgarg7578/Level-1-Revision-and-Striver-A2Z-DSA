package Arrays;

//blog : https://takeuforward.org/data-structure/check-if-an-array-is-sorted/
//Question : https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/#:~:text=Input%3A%20nums%20%3D%20%5B2%2C,no%20rotation)%20to%20make%20nums.
public class _03_Check_if_the_array_is_sorted {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 }, n = 5;

		System.out.println(isSorted(arr, n));
	}

	
//	Time Complexity: O(N)
//	Space Complexity: O(1)
	private static boolean isSorted(int[] arr, int n) {

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}

		return true;
	}

}
