package Arrays;

import java.util.ArrayList;

//blog : https://takeuforward.org/data-structure/remove-duplicates-in-place-from-sorted-array/
//Question : https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class _04_Remove_duplicates_from_Sorted_array {
	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 2, 2, 3, 3 };
		int k = removeDuplicates(arr);
		System.out.print("The array after removing duplicate elements is :");
		for (int i = 0; i < k; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		int arr2[] = { 1, 1, 2, 2, 2, 3, 3 };
		int l = removeDuplicates2(arr2);
		System.out.println("The array after removing duplicate elements is :");
		for (int i = 0; i < l; i++) {
			System.out.print(arr2[i] + " ");
		}
	}

	// Brute Force
	private static int removeDuplicates(int[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (!list.contains(arr[i])) {
				list.add(arr[i]);
			}
		}

		int idx = 0;

		for (int data : list) {
			arr[idx] = data;
			idx++;
		}

		return list.size();
	}

	// Optimal
	private static int removeDuplicates2(int[] arr2) {

		int i = 0;

		for (int j = 1; j < arr2.length; j++) {

			if(arr2[j] != arr2[i]) {
				i++;
				arr2[i] = arr2[j];
			}
			
		}

		return i + 1;
	}

}




























