package _10_Binary_Search._02_BS_on_Answers;

import java.util.ArrayList;
import java.util.List;

public class _24_Median_of_2_sorted_arrays {
	public static void main(String[] args) {
		int[] a = { 1, 4, 7, 10, 12 };
		int[] b = { 2, 3, 6, 15 };

		// we have to find mid of the merged array.
		// if a.length + b.length == even :- return from mid and mid-1 , mid
		// if a.length + b.length == Odd :- return Mid index

		System.out.println("The median of two sorted arrays is " + median(a, b));

		System.out.println("The median of two sorted arrays is " + median2(a, b));

	}

	// Brute force
	// Time Complexity: O(n1 + n2)
	// Space Complexity: O(n1 + n2)
	private static double median(int[] a, int[] b) {

		int n1 = a.length;
		int n2 = b.length;

		// merged array
		List<Integer> arr3 = new ArrayList<Integer>();

		int i = 0; // on first index
		int j = 0;// on Second index

		int k = 0; // on merged index

		while (i < n1 && j < n2) {
			if (a[i] < n1 && b[j] < n2) {
				arr3.add(a[i++]);
			} else {
				arr3.add(b[j++]);
			}
		}

		while (i < n1) {
			arr3.add(a[i++]);

		}

		while (j < n2) {
			arr3.add(b[j++]);
		}

		// add both arrays length
		int n = n1 + n2;

		if (n % 2 == 1) {
			return (double) arr3.get(n / 2);
		}

		double median = ((double) arr3.get(n / 2) + (double) arr3.get(n / 2) - 1) / 2.0;

		return median;
	}

	// Better approach
	// Time Complexity: O(n1 + n2)
	// Space Complexity: O(1)
	private static double median2(int[] a, int[] b) {
		int n1 = a.length;
		int n2 = b.length;

		int i = 0; // on first index
		int j = 0;// on Second index

		// add both arrays length
		int n = n1 + n2;

		int cnt = 0;

		int ind2 = n / 2;
		int ind1 = ind2 - 1;

		int ind1el = -1;
		int ind2el = -1;

		while (i < n1 && j < n2) {
			if (a[i] < b[j]) {
				if (cnt == ind1)
					ind1el = a[i];
				if (cnt == ind2)
					ind2el = a[i];
				cnt++;
				i++;
			} else {
				if (cnt == ind1)
					ind1el = b[j];
				if (cnt == ind2)
					ind2el = b[j];
				cnt++;
				j++;
			}
		}

		while (i < n1) {
			if (cnt == ind1)
				ind1el = a[i];
			if (cnt == ind2)
				ind2el = a[i];
			cnt++;
			i++;
		}

		while (j < n2) {
			if (cnt == ind1)
				ind1el = b[j];
			if (cnt == ind2)
				ind2el = b[j];
			cnt++;
			j++;
		}

		if (n % 2 == 1) {
			return ind2el;
		}

		double median = ((double) ind1el + (double) ind2el) / 2.0;

		return median;
	}

}
