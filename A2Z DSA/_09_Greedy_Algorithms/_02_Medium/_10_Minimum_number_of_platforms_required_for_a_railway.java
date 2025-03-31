package _09_Greedy_Algorithms._02_Medium;

import java.util.Arrays;

public class _10_Minimum_number_of_platforms_required_for_a_railway {
	public static void main(String[] args) {

		int[] arr = { 900, 945, 955, 1100, 1500, 1800 };
		int[] dep = { 920, 1200, 1130, 1150, 1900, 2000 };
		int n = arr.length;
		int totalCount = countPlatforms(n, arr, dep);
		System.out.println("Minimum number of Platforms required " + totalCount);
	}

	// understand in easy way :- https://www.youtube.com/watch?v=Ls_AYoz1IX0

	// which time is less take first that , if train is arrival then increase count
	// if train departure then count decrease

	// TC : O(nlogn)
	// SC : O(1)
	private static int countPlatforms(int n, int[] arr, int[] dep) {
		Arrays.sort(arr);
		Arrays.sort(dep);

		int ans = 0;

		int count = 0;

		int i = 0; // this pointer is on arr means arrival
		int j = 0;// this pointer is on dep means departure
		while (i < n) {

			if (arr[i] < dep[j]) {
				count = count + 1;
				ans = Math.max(ans, count);
				i++;
			} else if (arr[i] > dep[j]) {
				count = count - 1;
				j++;

			}

		}

		return ans;
	}
}
