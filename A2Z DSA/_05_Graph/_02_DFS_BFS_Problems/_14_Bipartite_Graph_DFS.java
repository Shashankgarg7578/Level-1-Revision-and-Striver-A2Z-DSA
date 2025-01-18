package _05_Graph._02_DFS_BFS_Problems;

import java.util.ArrayList;

public class _14_Bipartite_Graph_DFS {
	public static void main(String[] args) {
		// V = 4, E = 4
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(0).add(3);
		adj.get(3).add(0);
		adj.get(1).add(3);
		adj.get(3).add(1);
		adj.get(2).add(3);
		adj.get(3).add(2);

		boolean ans = isBipartite(4, adj);
		if (ans)
			System.out.println("1");
		else
			System.out.println("0");
	}

	public boolean isBipartite(int[][] graph) {
		int V = graph.length;
		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < graph.length; i++) {
			adjlist.add(new ArrayList<Integer>());
		}

		for (int u = 0; u < V; u++) {
			for (int v : graph[u]) {
				adjlist.get(u).add(v);
				adjlist.get(v).add(u);
			}
		}

		return isBipartite(graph.length, adjlist);
	}

	private static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {

		int[] color = new int[V];

		for (int i = 0; i < V; i++) {
			color[i] = -1;
		}

		for (int i = 0; i < V; i++) {
			if (color[i] == -1) {
				if (!dfs(i, 0, color, adj)) {
					return false;
				}
			}

		}

		return true;
	}

	private static boolean dfs(int nodeIdx, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {

		color[nodeIdx] = col;

		for (int it : adj.get(nodeIdx)) {
			if (color[it] == -1) {
				if (!dfs(it, 1 - col, color, adj)) {
					return false;
				}
        	}
			else if (color[it] == col) {
				return false;
			}
		}

		return true;
	}
}
