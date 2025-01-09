package Graph._02_DFS_BFS_Problems;

import java.util.ArrayList;

public class _07_DFS_Cycle_Detection_in_unirected_Graph {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(2).add(3);
		adj.get(3).add(2);

		boolean ans = isCycle(4, adj);
		if (ans)
			System.out.println("1");
		else
			System.out.println("0");
	}

	private static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean[] vis = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (vis[i] == false) {
				if (dfs(i, -1, vis, adj)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean dfs(int v, int par, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {

		vis[v] = true;

		for (int it : adj.get(v)) {
			if (vis[it] == false) {
				if (dfs(it, v, vis, adj)) {
					return true;
				}
			} else if (it != par) {
				return true;
			}
		}
		return false;
	}
}
