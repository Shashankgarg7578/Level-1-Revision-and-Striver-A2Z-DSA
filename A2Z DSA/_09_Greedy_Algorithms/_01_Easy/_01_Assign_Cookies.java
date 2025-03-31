package _09_Greedy_Algorithms._01_Easy;

import java.util.Arrays;

public class _01_Assign_Cookies {
	public static void main(String[] args) {

		// In this we have given greed(childs) and cookiesizes ,
//		so we have to assign max childs to cookies which can be there size or bigger
		int[] greed = { 1, 5, 3, 3, 4 };
		int[] cookieSize = { 4, 2, 1, 2, 1, 3 };

		System.out.print("Array Representing Greed: ");
		for (int i = 0; i < greed.length; i++) {
			System.out.print(greed[i] + " ");
		}
		System.out.println();

		System.out.print("Array Representing Cookie Size: ");
		for (int i = 0; i < cookieSize.length; i++) {
			System.out.print(cookieSize[i] + " ");
		}

		int ans = findContentChildren(greed, cookieSize);

		System.out.println();
		System.out.println("No. of kids assigned cookies " + ans);
		System.out.println();
	}

	// we will use two pointer
	// TC : O(N logN + M logM + M)
	// SC : O(1)
	private static int findContentChildren(int[] greed, int[] cookieSize) {

		int n = greed.length;
		int m = cookieSize.length;

		Arrays.sort(greed);
		Arrays.sort(cookieSize);

		int l = 0;// it is on cookie array
		int r = 0;// it is on greed array

		while (l < m && r < n) {

			if (greed[r] <= cookieSize[l]) {
				r++;
			}
			l++;
		}

		return r;
	}
}
