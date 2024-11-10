package Arrays;

import java.util.Arrays;

//blog : https://takeuforward.org/data-structure/find-second-smallest-and-second-largest-element-in-an-array/
//Question : https://www.geeksforgeeks.org/problems/second-largest3735/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=second-largest
public class _02_Second_Largest_Element_in_an_Array_without_Sorting {
	public static void main(String[] args) {
		System.out.println("Brute Force Solution");
		int[] arr = { 1, 2, 4, 6, 7, 5 };
		int n = arr.length;
		getElements(arr, n);

		System.out.println();

		System.out.println("Better Solution");
		int[] arr2 = { 1, 2, 4, 6, 7, 5 };
		int m = arr2.length;
		getElements2(arr2, m);

		System.out.println();

		System.out.println("Optimal Solution");
		int[] arr3 = { 1, 2, 4, 6, 7, 5 };
		int o = arr3.length;
		getElements3(arr3, o);
	}

	// Brute Force approach.
//	Time Complexity: O(NlogN), For sorting the array
//	Space Complexity: O(1)
	private static void getElements(int[] arr, int n) {
		Arrays.sort(arr);

		// second smallest
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[0]) {
				System.out.println("Second Smallest:" + arr[i]);
				break;
			}
		}

		// second Largest
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] != arr[arr.length - 1]) {
				System.out.println("Second Largest:" + arr[i]);
				break;
			}
		}

	}

	// Better approach.
//	Time Complexity: O(N), We do two linear traversals in our array
//	Space Complexity: O(1)
	private static void getElements2(int[] arr, int n) {
		Arrays.sort(arr);

		int min = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		int secondSmallest = Integer.MAX_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > secondLargest && max > arr[i]) {
				secondLargest = arr[i];
			}

			if (arr[i] < secondSmallest && min < arr[i]) {
				secondSmallest = arr[i];
			}
		}

		System.out.println("Second Smallest:" + secondSmallest);
		System.out.println("Second Largest:" + secondLargest);

	}

	// Optimal approach.
//	Time Complexity: O(N), Single-pass solution
//	Space Complexity: O(1)
	private static void getElements3(int[] arr, int n) {
		Arrays.sort(arr);

		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (largest < arr[i]) {
				secondLargest = largest;
				largest = arr[i];
			}
			if (largest > arr[i] && secondLargest < arr[i]) {
				secondLargest = arr[i];
			}
		}

		System.out.println("Second Largest:" + secondLargest);
	}

}