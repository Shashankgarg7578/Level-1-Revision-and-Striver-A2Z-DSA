package _09_Greedy_Algorithms._02_Medium;

import java.util.ArrayList;
import java.util.List;

public class _09_Insert_Interval {
	public static void main(String args[]) {
		int intervals[][] = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval = { 2, 5 };
		int[][] ans = insert(intervals, newInterval);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[0] + " " + ans[1]);
		}

	}

	// TC : O(N)
	// SC : O(N)
	public static int[][] insert(int[][] intervals, int[] newInterval) {

		List<int[]> result = new ArrayList<int[]>();
		int i = 0;
		int n = intervals.length;

		// left side which not require to merge
		while (i < n && intervals[i][1] < newInterval[0]) {
			result.add(intervals[i++]);
		}

		// middle which require to merge
		while (i < n && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}

		result.add(newInterval);

		// right side which not require to merge
		while (i < n) {
			result.add(intervals[i++]);

		}

		return result.toArray(new int[result.size()][]);
	}
}
