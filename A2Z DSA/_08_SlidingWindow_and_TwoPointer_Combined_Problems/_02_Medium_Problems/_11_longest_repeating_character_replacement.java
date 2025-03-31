package _08_SlidingWindow_and_TwoPointer_Combined_Problems._02_Medium_Problems;

import java.net.URISyntaxException;

public class _11_longest_repeating_character_replacement {

	public static void main(String[] args) throws URISyntaxException {

// In this we are able to replace 2 Different Char in Substring with any Char for make Longest repeating
		String s = "AABABBA";
		int k = 2;
		System.out.println(characterReplacement(s, k));
		System.out.println(characterReplacement2(s, k));
		System.out.println(characterReplacement3(s, k));
		System.out.println(characterReplacement4(s, k));

	}

	public static int characterReplacement(String s, int k) {

		int maxlen = 0;

		for (int i = 0; i < s.length(); i++) {
			int[] hashArr = new int[26];
			int maxf = 0;// max frequency

			for (int j = i; j < s.length(); j++) {
				hashArr[s.charAt(j) - 'A']++;

				maxf = Math.max(maxf, hashArr[s.charAt(j) - 'A']);

				int changesRequired = (j - i + 1) - maxf;
				if (changesRequired <= k) {
					maxlen = Math.max(maxlen, j - i + 1);
				}

			}

		}

		return maxlen;
	}

	// TC : O(2N) * 26
	// SC : O(26)
	public static int characterReplacement2(String s, int k) {

		int l = 0, r = 0, maxlen = 0, maxf = 0;

		int[] hash = new int[26];

		while (r < s.length()) {

			hash[s.charAt(r) - 'A']++;

			maxf = Math.max(maxf, hash[s.charAt(r) - 'A']);

			// shirink the data
			while ((r - l + 1) - maxf > k) {
				hash[s.charAt(l) - 'A']--;
				maxf = 0;
				for (int i = 0; i <= 25; i++) {
					maxf = Math.max(maxf, hash[i]);
				}
				l = l + 1;
			}

			if ((r - l + 1) - maxf <= k) {
				maxlen = Math.max(maxlen, r - l + 1);
			}

			r++;
		}

		return maxlen;
	}

	// TC : O(2N)
	// SC : O(26)
	public static int characterReplacement3(String s, int k) {

		int l = 0, r = 0, maxlen = 0, maxf = 0;

		int[] hash = new int[26];

		while (r < s.length()) {

			hash[s.charAt(r) - 'A']++;

			maxf = Math.max(maxf, hash[s.charAt(r) - 'A']);

			// shirink the data
			while ((r - l + 1) - maxf > k) {
				hash[s.charAt(l) - 'A']--;
				l = l + 1;
			}

			if ((r - l + 1) - maxf <= k) {
				maxlen = Math.max(maxlen, r - l + 1);
			}

			r++;
		}

		return maxlen;
	}

	// Optimal
	public static int characterReplacement4(String s, int k) {

		int l = 0, r = 0, maxlen = 0, maxf = 0;

		int[] hash = new int[26];

		while (r < s.length()) {

			hash[s.charAt(r) - 'A']++;

			maxf = Math.max(maxf, hash[s.charAt(r) - 'A']);

			// shirink the data
			if ((r - l + 1) - maxf > k) {
				hash[s.charAt(l) - 'A']--;
				l = l + 1;
			}

			if ((r - l + 1) - maxf <= k) {
				maxlen = Math.max(maxlen, r - l + 1);
			}

			r++;
		}

		return maxlen;
	}

}
