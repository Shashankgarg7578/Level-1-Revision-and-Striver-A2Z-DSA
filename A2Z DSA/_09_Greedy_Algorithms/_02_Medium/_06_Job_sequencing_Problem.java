package _09_Greedy_Algorithms._02_Medium;

import java.util.Arrays;

public class _06_Job_sequencing_Problem {

	static class Job {
		int id, deadline, profit;

		Job(int x, int y, int z) {
			this.id = x;
			this.deadline = y;
			this.profit = z;
		}
	}

	public static void main(String[] args) {

		// as we have given JOBS we have to maximize the profit for max days
		Job[] arr = new Job[4];
		arr[0] = new Job(1, 4, 20);
		arr[1] = new Job(2, 1, 10);
		arr[2] = new Job(3, 2, 40);
		arr[3] = new Job(4, 2, 30);

		// function call
		int[] res = JobScheduling(arr, 4);
		System.out.println(res[0] + " " + res[1]);

	}

	// for better understanding see the video
	// TC : O(N log N) + O(N*M).
	// SC : O(N log N )
	private static int[] JobScheduling(Job[] arr, int n) {

		// sort on the basis of Profit because we have to take max profit
		Arrays.sort(arr, (a, b) -> b.profit - a.profit);

		int maxiDeadline = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].deadline > maxiDeadline) {
				maxiDeadline = arr[i].deadline;
			}
		}

		// for storing job id's for that dayIndex
		int[] result = new int[maxiDeadline + 1];

		Arrays.fill(result, -1);

		int cnt = 0; // count job id's, how much we full filled
		int maxProfit = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = arr[i].deadline; j > 0; j--) {
				if (result[j] == -1) {
					cnt = cnt + 1;
					maxProfit = maxProfit + arr[i].profit;
					result[j] = i;
					break;
				}
			}
		}

		int[] ans = new int[2];
		ans[0] = cnt;
		ans[1] = maxProfit;
		return ans;
	}

}
