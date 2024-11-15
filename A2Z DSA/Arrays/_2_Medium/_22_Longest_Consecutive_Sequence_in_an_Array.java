package Arrays._2_Medium;

//blog : https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array/
//Quesition : https://leetcode.com/problems/longest-consecutive-sequence/
import java.util.Arrays;
import java.util.HashSet;

public class _22_Longest_Consecutive_Sequence_in_an_Array {

	public static void main(String[] args) {
		int[] a = { 100, 200, 1, 2, 3, 4 };
		int ans = longestSuccessiveElements(a);
		System.out.println("For Brute force The longest consecutive sequence is " + ans);

		int[] a2 = { 1, 2, 0, 1 }; // for dry run use this: {100, 102, 100, 101, 101, 4, 3, 2, 3, 2, 1, 1, 1, 2}
		int ans2 = longestSuccessiveElements2(a2);
		System.out.println("For Better The longest consecutive sequence is " + ans2);

		int[] a3 = { 102, 4, 100, 1, 101, 3, 2, 1, 1 };
		int ans3 = longestSuccessiveElements3(a3);
		System.out.println("For Better The longest consecutive sequence is " + ans3);

	}

	// Brute force : used 2 for loops
	// Time Complexity: O(N2
	// Space Complexity: O(1)
	private static int longestSuccessiveElements(int[] arr) {
		int longest = 1;

		// pick a element and search for its consecutive numbers.
		for (int i = 0; i < arr.length; i++) {
			int x = arr[i];
			int cnt = 1;

			// search for consecutive numbers using linear search
			while (linearSearch(arr, x + 1)) {
				x++;
				cnt++;
			}

			longest = Math.max(longest, cnt);
		}

		return longest;
	}

	private static boolean linearSearch(int[] arr, int num) {
		int n = arr.length; // size of array
		for (int i = 0; i < n; i++) {
			if (arr[i] == num)
				return true;
		}
		return false;
	}

	// Better : : used 1 for loop only
	// Time Complexity: Time Complexity: O(NlogN) + O(N),
	// Space Complexity: O(1)
	private static int longestSuccessiveElements2(int[] arr) {
		if (arr.length == 0) {
			return 0;
		}

		// sort the array:
		Arrays.sort(arr);

		int longest = 1;
		int currCnt = 1;
		int lastSmall = Integer.MIN_VALUE;

		// find longest sequence:
		for (int i = 0; i < arr.length; i++) {
			if (lastSmall == arr[i] - 1) {
				// a[i] is the next element of the current sequence.
				currCnt = currCnt + 1;
				lastSmall = arr[i];
				longest = Math.max(longest, currCnt);
			} else if (lastSmall != arr[i] && lastSmall != arr[i] - 1) {
				currCnt = 1;
				lastSmall = arr[i];
			}
		}

		return longest;
	}

	// Optimal : we can use Set or Map , In level-1 we use Map<K,V> so we are
	// solving this with Set<>
	// Time Complexity: O(N) + O(2*N) ~ O(3*N),
	// Space Complexity: O(N)
	private static int longestSuccessiveElements3(int[] arr) {

		if (arr.length == 0) {
			return 0;
		}

		int longest = 1;

		HashSet<Integer> set = new HashSet<Integer>();
		for (int val : arr) {
			set.add(val);
		}

		//it gives TLE because everytime we are comparing with all elements
//		for (int it : arr) {
//			int cnt = 1;
//			int x = it;
//			while (set.contains(x - 1)) {
//                cnt++;
//                longest = Math.max(longest, cnt);
//				x = x-1;
//			}
//		}

//		{ 102, 4, 100, 1, 101, 3, 2, 1, 1 }
		for (int it : arr) {
			
			if(!set.contains(it-1)) {
				int cnt = 1;
				int x = it;
				
				while(set.contains(x+1)) {
					cnt++;
					x++;
				}
				longest = Math.max(longest, cnt);
			}
			
		}
		
		return longest;
	}

}
















