package _08_SlidingWindow_and_TwoPointer_Combined_Problems._02_Medium_Problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _08_Fruit_Into_Baskets {
	public static void main(String[] args) {

//		this is same Question as Q7 MaxConsicutiveOne3
//		but in this we have to choose unique 2 numbers and take max subarray
		int[] arr = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };

		System.out.println(totalElements(arr));
		System.out.println(totalElements2(arr));
		System.out.println(totalElements3(arr));

	}

	// TC : O(N^2)
	// SC : O(1)
	public static int totalElements(int[] arr) {
		int n = arr.length;
		int maxlen = 0;

		for (int i = 0; i < n; i++) {

			Set<Integer> st = new HashSet<Integer>();

			for (int j = i; j < n; j++) {

				st.add(arr[j]);

				if (st.size() <= 2) {
					maxlen = Math.max(maxlen, j - i + 1);
				} else {
					break;
				}

			}

		}

		return maxlen;
	}

	// Better :- Two Pointer same as previous Q (remove till 2 elements in map)
	// TC : O(N + N) ~ O(2N)
	// SC : O(3)
	public static int totalElements2(int[] arr) {
		int k = 2; // because we are able to use only 2 type of number
		int n = arr.length;
		int maxlen = 0;
		int l = 0, r = 0;

		// element -> frequency
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		while (r < n) {

			int val1 = map.getOrDefault(arr[r], 0);
			map.put(arr[r], val1 + 1);

			if (map.size() > k) {

				while (map.size() > k) {
					int val2 = map.get(arr[l]);
					map.put(arr[l], val2 - 1);

					if (map.get(arr[l]) == 0) {
						map.remove(arr[l]);
					}
					l++;
				}
			}

			if (map.size() <= k) {
				maxlen = Math.max(maxlen, r - l + 1);
			}
			r++;

		}

		return maxlen;
	}

	// Same as previous Q
	// Optimal :- one time shrink only
	// TC : O(N)
	// SC : O(1)
	public static int totalElements3(int[] arr) {
		int k = 2; // because we are able to use only 2 type of number
		int n = arr.length;
		int maxlen = 0;
		int l = 0, r = 0;

		// element -> frequency
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		while (r < n) {

			int val1 = map.getOrDefault(arr[r], 0);
			map.put(arr[r], val1 + 1);

			if (map.size() > k) {

				if (map.size() > k) {
					int val2 = map.get(arr[l]);
					map.put(arr[l], val2 - 1);

					if (map.get(arr[l]) == 0) {
						map.remove(arr[l]);
					}
					l++;
				}
			}

			if (map.size() <= k) {
				maxlen = Math.max(maxlen, r - l + 1);
			}
			r++;

		}

		return maxlen;
	}

}
