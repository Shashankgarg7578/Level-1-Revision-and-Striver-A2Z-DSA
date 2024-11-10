package Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class _09_Find_the_Union {
	public static void main(String[] args) {
		int n = 10, m = 7;
		int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };

		ArrayList<Integer> Union = FindUnion(arr1, arr2, n, m);
		System.out.println("Union of arr1 and arr2 is ");
		for (int val : Union)
			System.out.print(val + " ");

		System.out.println();

		ArrayList<Integer> Union2 = FindUnion2(arr1, arr2, n, m);
		System.out.println("Union of arr1 and arr2 is ");
		for (int val : Union2)
			System.out.print(val + " ");

	}

	// brute force
//	Time Compleixty : O( (m+n)log(m+n) )
//	Space Complexity : O(m+n) 
	private static ArrayList<Integer> FindUnion(int[] arr1, int[] arr2, int n, int m) {
		HashSet<Integer> set = new HashSet<Integer>();
		ArrayList<Integer> union = new ArrayList<Integer>();

		for (int a : arr1) {
			set.add(a);
		}

		for (int b : arr2) {
			set.add(b);
		}

		for (int c : set) {
			union.add(c);
		}

		return union;
	}

	// Optimal :- Two Pointer
//	Time Compleixty : O(m+n)
//	Space Complexity : O(m+n) 
	private static ArrayList<Integer> FindUnion2(int[] arr1, int[] arr2, int n, int m) {
		ArrayList<Integer> union = new ArrayList<>();

		int i = 0, j = 0;

		// Merge the two sorted arrays
		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) {
				// Add arr1[i] if not already added (first element or different from the last
				// one)
				if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
					union.add(arr1[i]);
				}
				i++;
			} else if (arr1[i] > arr2[j]) {
				// Add arr2[j] if not already added
				if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
					union.add(arr2[j]);
				}
				j++;
			} else {
				// If both are equal, add only one of them
				if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
					union.add(arr1[i]);
				}
				i++;
				j++;
			}
		}

		// Add remaining elements from arr1
		while (i < n) {
			if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
				union.add(arr1[i]);
			}
			i++;
		}

		// Add remaining elements from arr2
		while (j < m) {
			if (union.isEmpty() || union.get(union.size() - 1) != arr2[j]) {
				union.add(arr2[j]);
			}
			j++;
		}

		return union;
	}

}
