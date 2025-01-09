package Graph._01_Basic_Learn;

import java.util.ArrayList;

public class _02_DFS {
	public static void main(String args[]) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		
		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(3);
		adj.get(3).add(0);
		adj.get(2).add(4);
		adj.get(4).add(2);

		ArrayList<Integer> ans = dfsOfGraph(5, adj);
		
		int n = ans.size();
		
		for (int i = 0; i < n; i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

	
	//Using Recursion
	private static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

		//for visited nodes
		boolean[] vis = new boolean[V];

		ArrayList<Integer> dfs = new ArrayList<Integer>();
		dfs(0, vis, adj, dfs);

		return dfs;
	}

	private static void dfs(int V, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfs) {

		//visited node
		vis[V] = true;
		//add in ans
		dfs.add(V);

		//traverse depth
		for (Integer a : adj.get(V)) {
			if (vis[a] == false) {
				dfs(a, vis, adj, dfs);
			}
		}

	}
}
