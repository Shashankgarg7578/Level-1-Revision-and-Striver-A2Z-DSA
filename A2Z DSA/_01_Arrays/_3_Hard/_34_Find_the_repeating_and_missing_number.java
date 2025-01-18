package _01_Arrays._3_Hard;


//blog : https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
//Question : https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=inversion-of-array
public class _34_Find_the_repeating_and_missing_number {
	public static void main(String[] args) {
		int[] a = { 3, 1, 2, 5, 4, 6, 7, 5 };
		int[] ans = findMissingRepeatingNumbers(a);
		System.out.println("The repeating and repeating and missing numbers are: {" + ans[0] + ", " + ans[1] + "}");

		int[] ans2 = findMissingRepeatingNumbers2(a);
		System.out.println("The repeating and repeating and missing numbers are: {" + ans2[0] + ", " + ans2[1] + "}");

	}

	// Brute force
//	Time Complexity: O(N2)
//	Space Complexity: O(1) 
	private static int[] findMissingRepeatingNumbers(int[] arr) {

		int[] ans = new int[2];

		int repeating = -1;
		int missing = -1;

		// Find the repeating and missing number:
		for (int i = 1; i <= arr.length; i++) {

			// Count the occurrences:
			int cnt = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == i) {
					cnt++;
				}
			}

			if (cnt == 0) {
				missing = i;
			} else if (cnt == 2) {
				repeating = i;
			}

			// if both have value then don't traverse whole array
			if (repeating != -1 && missing != -1)
				break;
		}

		ans[0] = repeating;
		ans[1] = missing;

		return ans;
	}

	// Better
//	Time Complexity: O(N2)
//	Space Complexity: O(1) 
	private static int[] findMissingRepeatingNumbers2(int[] arr) {
		int[] hashArr = new int[arr.length + 1];

		// update the hash array:
		for (int i = 0; i < arr.length; i++) {
			hashArr[arr[i]]++;
		}

		int[] ans = new int[2];
		int repeating = -1;
		int missing = -1;

		// Find the repeating and missing number:
		for (int i = 1; i < hashArr.length; i++) {
			if (hashArr[i] == 0) {
				missing = i;
			} else if (hashArr[i] == 2) {
				repeating = i;
			}

			// if both have value then don't traverse whole array
			if (repeating != -1 && missing != -1)
				break;
		}

		ans[0] = repeating;
		ans[1] = missing;

		return ans;
	}

}
