package _08_SlidingWindow_and_TwoPointer_Combined_Problems._02_Medium_Problems;

import java.net.URISyntaxException;

public class _10_Number_of_substring_containing_all_three_character {

	public static void main(String[] args) throws URISyntaxException {

		//started new variety
// In this we have to return only that substring in which all 3 char are involved
		String s = "bbacba";

		System.out.println(numberOfSubstrings(s));
		System.out.println(numberOfSubstrings2(s));
		System.out.println(numberOfSubstrings3(s));

	}

	// TC : O(N^2)
	// SC : O(1)
	public static int numberOfSubstrings(String s) {
		int n = s.length();
		int cnt = 0;

		for (int i = 0; i < n; i++) {

			int[] hashArr = new int[3];

			for (int j = i; j < n; j++) {

				hashArr[s.charAt(j) - 'a'] = 1;

				if ((hashArr[0] + hashArr[1] + hashArr[2]) == 3) {
					cnt = cnt + 1;
				}
			}
		}

		return cnt;
	}

	// TC : O(N^2)
	// SC : O(1)
	public static int numberOfSubstrings2(String s) {
		int n = s.length();
		int cnt = 0;

		for (int i = 0; i < n; i++) {

			int[] hashArr = new int[3];

			for (int j = i; j < n; j++) {

				hashArr[s.charAt(j) - 'a'] = 1;

				if ((hashArr[0] + hashArr[1] + hashArr[2]) == 3) {
					// for not go above if we already found
					cnt = cnt + (n - j);
					break;
				}
			}
		}

		return cnt;
	}

	// we have to use approach is all substring which end on a index means reverse
	// thing as above
	// TC : O(N)
	// SC : O(1)
	public static int numberOfSubstrings3(String s) {
		int cnt = 0;

		// for store last seen index a ,b, c
		int lastseen[] = { -1, -1, -1 };

		for (int i = 0; i < s.length(); i++) {

			lastseen[s.charAt(i) - 'a'] = i;

			if (lastseen[0] != -1 && lastseen[1] != -1 && lastseen[2] != -1) {
				cnt = cnt + (1 + Math.min(lastseen[0], Math.min(lastseen[1], lastseen[2])));
			}

		}

		return cnt;
	}

}
