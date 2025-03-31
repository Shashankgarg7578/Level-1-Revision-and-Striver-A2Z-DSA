package _10_Binary_Search._02_BS_on_Answers;

//same problem as split-array-largest-sum and Painter's partition

public class _22_Book_Allocation_Problem {
	public static void main(String[] args) {
		int[] arr = { 25, 46, 28, 49, 24 };
		int n = arr.length;
		int students = 4; // students
		int ans = findPages(arr, n, students);
		System.out.println("The answer is: " + ans);

		int ans2 = findPages2(arr, n, students);
		System.out.println("The answer is: " + ans2);

	}

	// Brute Force
	// Time Complexity: O(N * (sum(arr[])-max(arr[])+1))
	private static int findPages(int[] arr, int n, int students) {

		if (students > n) {
			return -1;
		}

		int sum = 0;
		int maxi = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			maxi = Math.max(maxi, arr[i]);
			sum += arr[i];
		}

		int low = maxi;
		int high = sum;

		for (int pages = low; pages <= high; pages++) {
			if (countStudents(arr, pages) == students) {
				return pages;
			}
		}

		return -1;
	}

	private static int countStudents(int[] arr, int pages) {

		int n = arr.length;
		int students = 1;
		long pagesStudent = 0;

		for (int i = 0; i < n; i++) {
			if (pagesStudent + arr[i] <= pages) {
				// add pages to current student
				pagesStudent += arr[i];
			} else {
				// add pages to next student
				students++;
				pagesStudent = arr[i];
			}
		}

		return students;
	}

	// Optimal
	// Time Complexity: O(N * log(sum(arr[])-max(arr[])+1))
	private static int findPages2(int[] arr, int n, int students) {

		if (students > n) {
			return -1;
		}

		int sum = 0;
		int maxi = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			maxi = Math.max(maxi, arr[i]);
			sum += arr[i];
		}

		int low = maxi;
		int high = sum;

		while (low <= high) {

			int mid = (low + high) / 2;

			int countStudents = countStudents(arr, mid);

			if (countStudents > students) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return low;
	}

}
