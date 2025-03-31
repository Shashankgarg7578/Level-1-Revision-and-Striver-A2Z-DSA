package _10_Binary_Search._01_BS_on_1D_Arrays;

public class _13_Find_peak_element {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 5, 1 };
		int ans = findPeakElement(arr);
		System.out.println("The peak is at index: " + ans);
		
		int ans2 = findPeakElement2(arr);
		System.out.println("The peak is at index: " + ans2);

		
		int ans3 = findPeakElement3(arr);
		System.out.println("The peak is at index: " + ans3);
	}

	// Brute force
	private static int findPeakElement(int[] arr) {

		int n = arr.length;

		for (int i = 0; i < n; i++) {

			if ((i == 0 || arr[i - 1] < arr[i]) && (i == n - 1 || arr[i] > arr[i + 1])) {
				return i;
			}

		}

		return -1;
	}

	// for one peak element, we have to return index
	private static int findPeakElement2(int[] arr) {

		int n = arr.length;

		if (n == 1)
			return 0;
		if (arr[0] > arr[1])
			return 1;
		if (arr[n - 1] > arr[n - 2])
			return n - 1;

		int low = 1;
		int high = n - 2;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
				return mid;
			} else if (arr[mid] > arr[mid - 1]) {
				low = mid + 1;
			} else if (arr[mid] > arr[mid + 1]) {
				high = mid - 1;
			}

		}

		return -1;
	}

	// for Multiple peak element use [1,5,1,2,1] for debug, we have to return index
	private static int findPeakElement3(int[] arr) {

		int n = arr.length;

		if (n == 1)
			return 0;
		if (arr[0] > arr[1])
			return 0;
		if (arr[n - 1] > arr[n - 2])
			return n - 1;

		int low = 1;
		int high = n - 2;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
				return mid;
			} else if (arr[mid] > arr[mid - 1]) {
				low = mid + 1;
			} else if (arr[mid] > arr[mid + 1]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}

		return -1;
	}

}
