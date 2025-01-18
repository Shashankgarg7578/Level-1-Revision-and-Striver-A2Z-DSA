package _05_Graph._03_Topo_Sort_and_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _17_Kahns_Algorithm {
	public static void main(String[] args) {
		int V = 6;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(2).add(3);
		adj.get(3).add(1);
		adj.get(4).add(0);
		adj.get(4).add(1);
		adj.get(5).add(0);
		adj.get(5).add(2);

		int[] ans = topoSort(V, adj);
		for (int node : ans) {
			System.out.print(node + " ");
		}
		System.out.println("");
	}

	//using BFS, used for directed graph
	private static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {

		int indegree[] = new int[v];
		for (int i = 0; i < v; i++) {
			for (int it : adj.get(i)) {
				indegree[it]++;
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		// add all 0 elements index in queue.
		for (int i = 0; i < v; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}

		// this is for ans
		int[] topo = new int[v];
		int i = 0;

		while (!queue.isEmpty()) {
			int node = queue.peek();
			queue.remove();
			topo[i] = node;
			i++;

			for (int it : adj.get(node)) {
				indegree[it]--;
				if (indegree[it] == 0) {
					queue.add(it);
				}
			}
		}

		return topo;
	}
}
