package _08_SlidingWindow_and_TwoPointer_Combined_Problems._02_Medium_Problems;

import java.util.HashMap;
import java.util.Map;

public class _09_Longest_Substring_with_At_Most_K_Distinct_Characters {
	public static void main(String[] args) {

//		this is same Question as Q7 MaxConsicutiveOne3

		String s = "aaabbccd";
		int k = 2;
		System.out.println(lengthOfLongestSubstringKDistinct(s, k));
		System.out.println(lengthOfLongestSubstringKDistinct2(s, k));
		System.out.println(lengthOfLongestSubstringKDistinct3(s, k));

	}

	// TC : O(N^2) * log(256)
	// SC : O(256)
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {

		int maxlen = 0;

		// element -> frequency
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {

			map = new HashMap<Character, Integer>();
			for (int j = i; j < s.length(); j++) {
				int val1 = map.getOrDefault(s.charAt(j), 0);
				map.put(s.charAt(j), val1 + 1);

				if (map.size() <= k) {
					maxlen = Math.max(maxlen, j - i + 1);
				} else {
					break;
				}

			}

		}

		return maxlen;
	}

	// Better :- Two Pointer same as previous Q (remove till 2 elements in map)
	// TC : O(N + N) + log(256)
	// SC : O(256)
	public static int lengthOfLongestSubstringKDistinct2(String s, int k) {
		int n = s.length();

		int maxlen = 0;
		int l = 0, r = 0;

		// element -> frequency
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		while (r < n) {

			int val1 = map.getOrDefault(s.charAt(r), 0);
			map.put(s.charAt(r), val1 + 1);

			if (map.size() > k) {

				while (map.size() > k) {
					int val2 = map.get(s.charAt(l));
					map.put(s.charAt(l), val2 - 1);

					if (map.get(s.charAt(l)) == 0) {
						map.remove(s.charAt(l));
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

	public static int lengthOfLongestSubstringKDistinct3(String s, int k) {
		int n = s.length();

		int maxlen = 0;
		int l = 0, r = 0;

		// element -> frequency
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		while (r < n) {

			int val1 = map.getOrDefault(s.charAt(r), 0);
			map.put(s.charAt(r), val1 + 1);

			if (map.size() > k) {

				if (map.size() > k) {
					int val2 = map.get(s.charAt(l));
					map.put(s.charAt(l), val2 - 1);

					if (map.get(s.charAt(l)) == 0) {
						map.remove(s.charAt(l));
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
