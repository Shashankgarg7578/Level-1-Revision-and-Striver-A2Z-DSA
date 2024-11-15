package Arrays._1_Easy;

import java.util.HashMap;
import java.util.Map;

//blog : https://takeuforward.org/arrays/find-the-number-that-appears-once-and-the-other-numbers-twice/
//Question : https://leetcode.com/problems/single-number/
public class _12_Find_the_number_that_appears_once_and_other_numbers_twice {
	public static void main(String[] args) {
		int[] arr = { 4, 1, 2, 1, 2 };
		int ans = getSingleElement(arr);
		System.out.println("The single element is: " + ans);

		int ans2 = getSingleElement2(arr);
		System.out.println("The single element is: " + ans2);

		int ans3 = getSingleElement3(arr);
		System.out.println("The single element is: " + ans3);
	}

	// Brute force
//	Time Complexity: O(N2)
//	Space Complexity: O(1) 
	private static int getSingleElement(int[] nums) {

		for (int a : nums) {
			int count = 0;

			for (int b : nums) {
				if (b == a) {
					count++;
				}
			}

			if (count == 1) {
				return a;
			}
		}

		return -1;
	}

	// Better
//	Time Complexity: O(N*logM) + O(M), where M = size of the map i.e. M = (N/2)+1. N = size of the array.
//	Space Complexity: O(M) 
	private static int getSingleElement2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int a : nums) {
			int val = map.getOrDefault(map.get(a), 0);
			map.put(a, val + 1);
		}

		for (Map.Entry<Integer, Integer> keyVal : map.entrySet()) {
			if (keyVal.getValue() == 1) {
				return keyVal.getKey();
			}
		}

		return -1;
	}

	// Optimal : we will solve using XOR
//	Time Complexity: O(N*logM) + O(M), where M = size of the map i.e. M = (N/2)+1. N = size of the array.
//	Space Complexity: O(M) 
	private static int getSingleElement3(int[] nums) {
		int ans = 0;
		for(int num : nums) {
			ans ^= num;
		}
		
		return ans;
	}
	
}
