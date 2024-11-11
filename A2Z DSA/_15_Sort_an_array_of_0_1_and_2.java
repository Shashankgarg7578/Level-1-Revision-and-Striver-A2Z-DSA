package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

//blog : https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/
//Question : https://leetcode.com/problems/sort-colors/description/
public class _15_Sort_an_array_of_0_1_and_2 {
	public static void main(String[] args) {
		int n = 6;
		ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(new Integer[] { 0, 2, 1, 2, 0, 1 }));
		sortArray(arr, n);
		System.out.println("After sorting:");
		for (int i = 0; i < n; i++) {
			System.out.print(arr.get(i) + " ");
		}
		System.out.println();

		int n2 = 6;
		ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(new Integer[] { 0, 2, 1, 2, 0, 1 }));
		sortArray2(arr2, n2);
		System.out.println("After sorting:");
		for (int i = 0; i < n2; i++) {
			System.out.print(arr2.get(i) + " ");
		}
		System.out.println();
		
		int n3 = 6;
		int[] arr3 = { 0, 2, 1, 2, 0, 1 };
 		sortArray3(arr3, n3);
		System.out.println("After sorting:");
		for (int i = 0; i < n3; i++) {
			System.out.print(arr3[i] + " ");
		}
		System.out.println();

	}

	// Brute force : Sort the array
//	Time Complexity: O(N*logN)
//	Space Complexity: O(1)
	private static void sortArray(ArrayList<Integer> arr, int n) {
		// default sorting order
		arr.sort(null);
	}

	// Better :
//	Time Complexity: O(N) + O(N)
//	Space Complexity: O(1)
	private static void sortArray2(ArrayList<Integer> arr, int n) {
		int cnt0 = 0;
		int cnt1 = 0;
		int cnt2 = 0;

		for (Integer a : arr) {
			if (a == 0) {
				cnt0++;
			} else if (a == 1) {
				cnt1++;
			} else if (a == 2) {
				cnt2++;
			}
		}

		for (int i = 0; i < cnt0; i++) {
			arr.set(i, 0);
		}
		for (int i = cnt0; i < cnt0 + cnt1; i++) {
			arr.set(i, 1);
		}
		for (int i = cnt0 + cnt1; i < (cnt0 + cnt1 + cnt2); i++) {
			arr.set(i, 2);
		}
	}

	
	// Optimal
//	Time Complexity: O(N) 
//	Space Complexity: O(1)
	private static void sortArray3(int[] arr, int n) {
		int mid = 0;
		int low= 0;
		int high = arr.length -1;
				
		while(mid <= high) {
			if(arr[mid] == 0) {
				int temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				
				low++;
				mid++;
			}else if(arr[mid] == 1) {
				mid++;
			}else if(arr[mid] == 2) {
				int temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
			}
			
		}
		
	}

	
}
