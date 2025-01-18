package _01_Arrays._3_Hard;

import java.util.Arrays;

//blog : https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
//Question :https://leetcode.com/problems/merge-sorted-array/
public class _33_Merge_two_sorted_arrays_without_extra_space {
	public static void main(String[] args) {
		long[] arr1 = { 1, 4, 8, 10 };
		long[] arr2 = { 2, 3, 9 };
		int n = 4, m = 3;
		merge(arr1, arr2, n, m);
		System.out.println("The merged arrays are:");
		System.out.print("arr1[] = ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.print("\narr2[] = ");
		for (int i = 0; i < m; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();

		
		
		System.out.println();
		long[] arr3 = { 1, 4, 8, 10 };
		long[] arr4 = { 2, 3, 9 };
		int n3 = 4, m4 = 3;
		merge2(arr3, arr4, n3, m4);
		System.out.println("The merged arrays are:");
		System.out.print("arr1[] = ");
		for (int i = 0; i < n3; i++) {
			System.out.print(arr3[i] + " ");
		}
		System.out.print("\narr2[] = ");
		for (int i = 0; i < m4; i++) {
			System.out.print(arr4[i] + " ");
		}
		System.out.println();

	}

	// Brute force
//	Time Complexity: O(n+m) + O(n+m)
//	Space Complexity: O(n+m)
	private static void merge(long[] arr1, long[] arr2, int n, int m) {
		int left = 0;
		int right = 0;

		long[] arr3 = new long[n + m];
		int index = 0;

		// Insert the elements from the 2 arrays
		// into the 3rd array using left and right
		// pointers:
		while (left < n && right < m) {
			if (arr1[left] <= arr2[right]) {
				arr3[index] = arr1[left];
				left++;
				index++;
			} else {
				arr3[index] = arr2[right];
				right++;
				index++;
			}
		}

		// If right pointer reaches the end:
		while (left < n) {
			arr3[index] = arr1[left];
			left++;
			index++;
		}

		// If left pointer reaches the end:
		while (right < m) {
			arr3[index] = arr2[right];
			right++;
			index++;
		}

		for (int i = 0; i < n + m; i++) {
			if (i < n) {
				arr1[i] = arr3[i];
			} else {
				arr2[i - n] = arr3[i];
			}
		}
	}

	// Optimal
//	Time Complexity: O(min(n, m)) + O(n*logn) + O(m*logm)
//	Space Complexity: O(1) 
	private static void merge2(long[] arr1, long[] arr2, int n, int m) {

		// Declare 2 pointers:
		int left = arr1.length - 1;
		int right = 0;

		// Swap the elements until arr1[left] is
		// smaller than arr2[right]:
		while (left >= 0 && right < m) {
			if (arr1[left] > arr2[right]) {
				long temp = arr1[left];
				arr1[left] = arr2[right];
				arr2[right] = temp;
				left--;
				right++;
			} else {
				break;
			}
		}

		// Sort arr1[] and arr2[] individually:
		Arrays.sort(arr1);
		Arrays.sort(arr2);

	}

}
