package _09_Greedy_Algorithms._02_Medium;

import java.util.Arrays;

public class _08_Non_overlapping_Intervals {
	public static void main(String args[]) {
		int intervals[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		int ans = eraseOverlapIntervals(intervals);
		System.out.println(ans);
	}

	// same as previous one
	public static int eraseOverlapIntervals(int[][] intervals) {

		// sort on the basis of end time
		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

		int cnt = 1;

		int lastEndTime = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {

			if (intervals[i][0] >= lastEndTime) {
				cnt = cnt + 1;
				lastEndTime = intervals[i][1];
			}
		}

		return intervals.length - cnt;
	}
}
