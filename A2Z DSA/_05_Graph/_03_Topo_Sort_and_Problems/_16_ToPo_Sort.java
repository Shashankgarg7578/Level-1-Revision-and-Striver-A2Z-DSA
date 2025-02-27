package _05_Graph._03_Topo_Sort_and_Problems;

import java.util.ArrayList;
import java.util.Stack;

public class _16_ToPo_Sort {
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

	//topo sort used for directed graph
	private static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {

		int[] vis = new int[v];

		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < v; i++) {
			if(vis[i] == 0) {
				dfs(i, adj, vis, st);
			}
		}

		int ans[] = new int[v];
		int i = 0;
		while (!st.isEmpty()) {
			ans[i] = st.peek();
			i++;
			st.pop();
		}

		return ans;
	}

	private static void dfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st) {
		
		vis[i] = 1;
		
		for(Integer it : adj.get(i)) {
			if(vis[i] == 0) {
				dfs(it, adj,vis,st);
			}
		}
		
		st.add(i);
	}
}
