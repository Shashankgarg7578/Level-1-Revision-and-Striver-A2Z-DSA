package _08_SlidingWindow_and_TwoPointer_Combined_Problems._02_Medium_Problems;

public class _15_Minimum_Window_Substring {
	public static void main(String[] args) {

		String s = "ddaaabbca";
		String t = "abc";
		System.out.println(minWindow(s, t));

	}

	public static String minWindow(String s, String t) {

		int minlen = Integer.MAX_VALUE;

		int sIndex = 0;

		for (int i = 0; i < s.length(); i++) {

			int[] hash = new int[256];

			int cnt = 0;

			for (int j = 0; j < t.length(); j++) {
				hash[t.charAt(j)]++;
			}

			for (int j = 0; j < s.length(); j++) {

				if (hash[s.charAt(j)] > 0) {
					cnt = cnt + 1;
				}

				hash[s.charAt(j)]--;

				if (cnt == t.length()) {
					if (j - i + 1 < minlen) {
						minlen = j - i + 1;
						sIndex = i;
						break;
					}
				}

			}

		}

		return s.substring(sIndex, sIndex + minlen);
	}

}
