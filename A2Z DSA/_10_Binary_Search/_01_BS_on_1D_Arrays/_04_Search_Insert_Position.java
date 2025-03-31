package _10_Binary_Search._01_BS_on_1D_Arrays;

public class _04_Search_Insert_Position {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 7 };
		int x = 6;
		int ind = searchInsert(arr, x);
		System.out.println("The index is: " + ind);
	}

	
	//same code of Lower Bound
	private static int searchInsert(int[] arr, int target) {
		int n = arr.length;
		int low = 0;
		int high = n - 1;

		int ans = arr.length;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (arr[mid] >= target) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return ans;
	}
}
