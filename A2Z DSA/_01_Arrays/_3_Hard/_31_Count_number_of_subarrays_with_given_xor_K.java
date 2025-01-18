package _01_Arrays._3_Hard;

import java.util.HashMap;
import java.util.Map;

//blog : https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/
//Question : https://www.interviewbit.com/problems/subarray-with-given-xor/
public class _31_Count_number_of_subarrays_with_given_xor_K {
	public static void main(String[] args) {
		int[] a = { 4, 2, 2, 6, 4 };
		int k = 6;
		int ans = subarraysWithXorK(a, k);
		System.out.println("The number of subarrays with XOR k is: " + ans);

		int ans2 = subarraysWithXorK2(a, k);
		System.out.println("The number of subarrays with XOR k is: " + ans2);

		int ans3 = subarraysWithXorK3(a, k);
		System.out.println("The number of subarrays with XOR k is: " + ans3);

	}

	// Brute force
	// Time Complexity: O(N^3)
	// Space Complexity: O(1)
	private static int subarraysWithXorK(int[] a, int k) {
		int cnt = 0;

		// Step 1: Generating subarrays:
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {

				// step 2:calculate XOR of all elements
				int xorr = 0;
				for (int K = i; K <= j; K++) {
					xorr = xorr ^ a[K];
				}

				// step 3:check XOR and count
				if (xorr == k) {
					cnt++;
				}
			}
		}

		return cnt;
	}

	// Better
	// Time Complexity: O(N^2)
	// Space Complexity: O(1)
	private static int subarraysWithXorK2(int[] a, int k) {
		int cnt = 0;
		// Step 1: Generating subarrays:
		for (int i = 0; i < a.length; i++) {

			// step 2:calculate XOR of all elements
			int xorr = 0;
			for (int j = i; j < a.length; j++) {
				xorr = xorr ^ a[j];

				// step 3:check XOR and count
				if (xorr == k) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	// Optimal
	// Time Complexity: O(N) or O(N*logN)
	// Space Complexity: O(N)
	private static int subarraysWithXorK3(int[] a, int k) {

		int xr = 0;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(xr, 1);

		int cnt = 0;

		for (int i = 0; i < a.length; i++) {
			// prefix XOR till index i:
			xr = xr ^ a[i];

			// By formula: x = xr^k:
			int x = xr ^ k;

			// add the occurrence of xr^k
            // to the count:
			if (map.containsKey(x)) {
				cnt += map.get(x);
			} 
			
			// Insert the prefix xor till index i
            // into the map:
			if(map.containsKey(xr)){
				map.put(xr, map.get(xr)+1);
			}else {
				map.put(xr, 1);
			}
		}

		return cnt;
	}

}
