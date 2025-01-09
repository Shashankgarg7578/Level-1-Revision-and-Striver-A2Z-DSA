package Graph._03_Topo_Sort_and_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class _20_Course_Schedule_II {
	public static void main(String[] args) {
		int N = 4; //total 4 vertices
		int M = 3; // only in 3 index have values
		ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			prerequisites.add(i, new ArrayList<>());
		}

		prerequisites.get(0).add(0);
		prerequisites.get(0).add(1);

		prerequisites.get(1).add(1);
		prerequisites.get(1).add(2);

		prerequisites.get(2).add(2);
		prerequisites.get(2).add(3);

		int[] ans = findOrder(N, M, prerequisites);

		for (int task : ans) {
			System.out.print(task + " ");
		}
		System.out.println("");
	}

	private static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		//for all vertices
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}

		//for only given values 
		for (int i = 0; i < m; i++) {
			adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
		}

		int V = adj.size();
		
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

		
//		int topo[] = new int[V];
		
		ArrayList<Integer> tempAns = new ArrayList<Integer>();
		int i = 0;
		while (!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			tempAns.add(node);
//			topo[i] = node;
//			i++;

			for (int it : adj.get(node)) {

				indegree[it]--;
				if (indegree[it] == 0) {
					q.add(it);
				}
			}

		}

		if(i == V) {
			Collections.reverse(tempAns);
			return tempAns.stream().mapToInt(a -> i).toArray();
		}
		
		int arr[] = {};
		
		return arr;
	}
}
