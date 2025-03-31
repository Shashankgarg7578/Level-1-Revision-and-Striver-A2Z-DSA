package _09_Greedy_Algorithms._01_Easy;

import java.util.Arrays;

//this is called CPU scheduling
public class _03_Shortest_Job_first {

//	SFJ :- Scheduling policy that selects the waiting process with the smallest execution time to execute next

	public static void main(String[] args) {
		int[] jobs = { 4, 3, 7, 1, 2 };
		// p1 p2 p3 p4 p5

//		0-----1-----3-----6------10----17
//		  p4     p5    p2    p1     p3

//		p4 - 0
//		p5 - 1
//		p2 - 3
//		p1 - 6
//		p3 - 10
//    sum  = 20 

		System.out.print("Array Representing Job Durations: ");
		for (int i = 0; i < jobs.length; i++) {
			System.out.print(jobs[i] + " ");
		}
		System.out.println();

		float ans = shortestJobFirst(jobs);
		System.out.println("Average waiting time: " + ans);
	}

	private static float shortestJobFirst(int[] jobs) {

		Arrays.sort(jobs);

		float waitTime = 0;
		int totalTime = 0;
		int n = jobs.length;

		for (int i = 0; i < n; i++) {

			waitTime += totalTime;
			totalTime += jobs[i];
		}

		return (waitTime / n);
	}

}
