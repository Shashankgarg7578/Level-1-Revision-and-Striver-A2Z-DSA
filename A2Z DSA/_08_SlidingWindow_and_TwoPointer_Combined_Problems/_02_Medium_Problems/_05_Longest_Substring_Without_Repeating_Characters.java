package _08_SlidingWindow_and_TwoPointer_Combined_Problems._02_Medium_Problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _05_Longest_Substring_Without_Repeating_Characters {

	// here we have to use sliding window and two pointers
	public static void main(String args[]) {
		String str = "cadbzabcd";
		System.out.println(
				"The length of the longest substring without repeating characters is " + lengthOfLongestSubstring(str));
		System.out.println("The length of the longest substring without repeating characters is "
				+ lengthOfLongestSubstring2(str));
	}

	// Brute Force
	public static int lengthOfLongestSubstring(String str) {
		if (str.length() == 0) {
			return 0;
		}

		int maxAns = Integer.MIN_VALUE;

		for (int i = 0; i < str.length(); i++) {
			Set<Character> set = new HashSet<Character>();
			for (int j = i; j < str.length(); j++) {
				char ch = str.charAt(j);
				if (set.contains(ch)) {
					break;
				}
				maxAns = Math.max(maxAns, j - i + 1);
				set.add(ch);
			}

		}

		return maxAns;
	}

	// Optimal
	// Using two pointer
	public static int lengthOfLongestSubstring2(String str) {
		if (str.length() == 0) {
			return 0;
		}

		int[] hashArr = new int[256]; // 256 for all type of char or any value
		Arrays.fill(hashArr, -1);

		int n = str.length();

		int l = 0, r = 0, maxlen = 0;

		while (r < n) {
//1.if right pointer char is already visited then shrink the left to previous char point + 1
			if (hashArr[str.charAt(r)] != -1) {
//2.if previous visited char is lesser then left pointer then don't shrink
				if (hashArr[str.charAt(r)] >= l) {
					l = hashArr[str.charAt(r)] + 1;
				}
			}
			int len = r - l + 1;
			maxlen = Math.max(maxlen, len);
			hashArr[str.charAt(r)] = r;
			r++;

		}

		return maxlen;
	}

}
