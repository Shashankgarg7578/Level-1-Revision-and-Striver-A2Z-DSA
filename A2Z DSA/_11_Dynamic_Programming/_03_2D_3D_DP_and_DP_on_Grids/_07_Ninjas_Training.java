package _11_Dynamic_Programming._03_2D_3D_DP_and_DP_on_Grids;

import java.util.Arrays;

public class _07_Ninjas_Training {
	public static void main(String args[]) {
		// Define the points for each activity on each day
//		                     t1, t2, t3
		int[][] points = { { 10, 40, 70 }, // day1
				           { 20, 50, 80 }, // day2
				           { 30, 60, 90 } // day3
		                 };

		int n = points.length; // Get the number of days
		System.out.println(ninjaTrainingByRecursion(n - 1, 3, points)); // Calculate and print the maximum points

		int dp[][] = new int[n][4];
		for (int[] row : dp)
			Arrays.fill(row, -1);

		// Start the recursive calculation from the last day (n - 1) with the last
		// activity (3)
		System.out.println(ninjaTrainingByDpMemo(n - 1, 3, points, dp));
		System.out.println(ninjaTrainingByDpTabu(n,points));
		System.out.println(ninjaTrainingByDpTabuSpaceOpt(n,points));

		
	}
	
	//In this Greedy(always take max) Fails :- 
	

//	0 -> 1st task data is used previously
//	1 -> 2st task data is used previously
//	2 -> 3st task data is used previously
//	3 -> No one is used previously

	// bottom up approach
	private static int ninjaTrainingByRecursion(int day, int lastUsedTask, int[][] points) {

		// base case when we come to first day
		if (day == 0) {
			int maxi = 0;
			for (int task = 0; task < 3; task++) {
				if (task != lastUsedTask) {
					maxi = Math.max(maxi, points[0][task]);
				}
			}
			return maxi;
		}

		int maxi = 0;

		for (int task = 0; task < 3; task++) {
			if (task != lastUsedTask) {
				int point = points[day][task] + ninjaTrainingByRecursion(day - 1, task, points);
				maxi = Math.max(maxi, point);
			}
		}

		return maxi;
	}

	// bottom up approach
	private static int ninjaTrainingByDpMemo(int day, int lastUsedTask, int[][] points, int[][] dp) {
		
		if (dp[day][lastUsedTask] != -1) {
			return dp[day][lastUsedTask];
		}

		// base case when we come to first day
		if (day == 0) {
			int maxi = 0;
			for (int task = 0; task < 3; task++) {
				if (task != lastUsedTask) {
					maxi = Math.max(maxi, points[0][task]);
				}
			}
			return dp[day][lastUsedTask] = maxi;
		}

		// for previous days count task points
		int maxi = 0;
		for (int task = 0; task < 3; task++) {
			if (task != lastUsedTask) {
				int point = points[day][task] + ninjaTrainingByDpMemo(day - 1, task, points, dp);
				maxi = Math.max(maxi, point);
			}
		}

		return dp[day][lastUsedTask] = maxi;
	}

	// Top-Down approach
	private static int ninjaTrainingByDpTabu(int n, int[][] points) {
		int[][] dp = new int[n][4];

		// don't choose same index , this is base case in memoization
		dp[0][0] = Math.max(points[0][1], points[0][2]);
		dp[0][1] = Math.max(points[0][0], points[0][2]);
		dp[0][2] = Math.max(points[0][0], points[0][1]);
		dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

		for (int day = 1; day < n; day++) {
			for (int last = 0; last < 4; last++) {
				dp[day][last] = 0;
				for (int task = 0; task < 3; task++) {
					if (task != last) {
						int activity = points[day][task] + dp[day - 1][task];

						dp[day][last] = Math.max(dp[day][last], activity);

					}
				}
			}
		}

		return dp[n - 1][3];
	}
	
	// Top-Down approach with space optimization
	private static int ninjaTrainingByDpTabuSpaceOpt(int n, int[][] points) {
		int[] prev = new int[4];

		// don't choose same index because
		prev[0] = Math.max(points[0][1], points[0][2]);
		prev[1] = Math.max(points[0][0], points[0][2]);
		prev[2] = Math.max(points[0][0], points[0][1]);
		prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

		for (int day = 1; day < n; day++) {
			int[] temp = new int[4];
			for (int last = 0; last < 4; last++) {
				temp[last] = 0;
				for (int task = 0; task < 3; task++) {
					if (task != last) {
						int activity = points[day][task] + prev[task];

						temp[last] = Math.max(temp[last], activity);

					}
				}
			}
			prev = temp;
		}

		return prev[3];
	}

}
