package _01_Arrays._3_Hard;

import java.util.ArrayList;

//blog: https://takeuforward.org/data-structure/count-inversions-in-an-array/
//QUestion : https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=inversion-of-array
public class _35_Count_Inversions {
	public static void main(String[] args) {
		int[] a = { 5, 3, 2, 4, 1 };
		int n = 5;
		
		int cnt = numberOfInversions(a, n);
		System.out.println("The number of inversions is: " + cnt);
		
		int cnt2 = numberOfInversions2(a, n);
		System.out.println("The number of inversions is: " + cnt2);

	}

	// Brute force
	// Time Complexity: O(N^2)
	// Space Complexity: O(1)
	private static int numberOfInversions(int[] a, int n) {
		// Count the number of pairs:
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j])
					cnt++;
			}
		}
		return cnt;
	}

	// Optimal
	//Time Complexity: O(N*logN), 
	//Space Complexity: O(N)
	public static int numberOfInversions2(int[] a, int n) {
		// Count the number of pairs:
		return mergeSort(a, 0, n - 1);
	}


	public static int mergeSort(int[] arr, int low, int high) {
		int cnt = 0;
		if (low >= high) {
			return cnt;
		}

		int mid = (low + high) / 2;
		cnt += mergeSort(arr, low, mid); // left half
		cnt += mergeSort(arr, mid + 1, high); // right half
		cnt += merge(arr, low, mid, high); // merging sorted halves
		return cnt;
	}

	private static int merge(int[] arr, int low, int mid, int high) {
		ArrayList<Integer> temp = new ArrayList<>(); // temporary array
		int left = low; // starting index of left half of arr
		int right = mid + 1; // starting index of right half of arr

		// Modification 1: cnt variable to count the pairs:
		int cnt = 0;

		// storing elements in the temporary array in a sorted manner//
		while (left <= mid && right <= high) {
			if (arr[left] <= arr[right]) {
				temp.add(arr[left]);
				left++;
			} else {
				temp.add(arr[right]);
				cnt += (mid - left + 1); // Modification for if right side is lower then,
				                         //it is smaller from all elements which are on left.
				right++;
			}
		}

		// if elements on the left half are still left //

		while (left <= mid) {
			temp.add(arr[left]);
			left++;
		}

		// if elements on the right half are still left //
		while (right <= high) {
			temp.add(arr[right]);
			right++;
		}

		// transfering all elements from temporary to arr //
		for (int i = low; i <= high; i++) {
			arr[i] = temp.get(i - low);
		}
		return cnt; // Modification 3
	}


}
