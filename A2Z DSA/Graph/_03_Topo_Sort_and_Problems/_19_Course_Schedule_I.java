package Graph._03_Topo_Sort_and_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _19_Course_Schedule_I {
	public static void main(String[] args) {
		int N = 4;
		int[][] prerequisites = new int[3][2];
		prerequisites[0][0] = 1;
		prerequisites[0][1] = 0;

		prerequisites[1][0] = 2;
		prerequisites[1][1] = 1;

		prerequisites[2][0] = 3;
		prerequisites[2][1] = 2;

		boolean ans = isPossible(N, prerequisites);
		if (ans)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	private static boolean isPossible(int V, int[][] prerequisites) {

		int n = prerequisites.length;

		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < n; i++) {
			adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}

		int[] indegree = new int[V];
		for (int i = 0; i < V; i++) {
			for (int it : adj.get(i)) {
				indegree[it]++;
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}

		int cnt = 0;
		while (!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			cnt++;

			for (int it : adj.get(node)) {

				indegree[it]--;
				if (indegree[it] == 0) {
					q.add(it);
				}
			}

		}

		return (V == cnt);
	}
}
