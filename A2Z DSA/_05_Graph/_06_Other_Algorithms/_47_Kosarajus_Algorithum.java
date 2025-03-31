package _05_Graph._06_Other_Algorithms;

import java.util.ArrayList;
import java.util.Stack;

//Step1:-Sort all the nodes according to their finishing time : means ToPo Sort
//Step2:-Reverse all the edges of the entire graph
//Step3:-Perform the DFS and count the no. of different DFS calls to get the no. of SCC
public class _47_Kosarajus_Algorithum {
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = { { 1, 0 }, { 0, 2 }, { 2, 1 }, { 0, 3 }, { 3, 4 } };
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < n; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
		}

		int ans = kosaraju(n, adj);
		System.out.println("The number of strongly connected components is: " + ans);
	}

	public static int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {

//		Step1:Sort all the nodes according to their finishing time : means ToPo Sort
		int[] vis = new int[V];
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < V; i++) {
			if (vis[i] == 0) {
				dfs(i, vis, adj, st);
			}
		}

		ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < V; i++) {
			adjT.add(new ArrayList<Integer>());
		}

//      Step2:-Reverse all the edges of the entire graph
		for (int i = 0; i < V; i++) {
			vis[i] = 0;
			for (Integer it : adj.get(i)) {
				// i -> it
				// it -> i
				adjT.get(it).add(i);
			}
		}

		//Step3:-Perform the DFS and count the no. of different DFS calls to get the no. of SCC
		int scc = 0;
		while (!st.isEmpty()) {
			int node = st.peek();
			st.pop();
			if (vis[node] == 0) {
				scc++;
				dfs3(node, vis, adjT);
			}
		}
		return scc;
	}

	private static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
		vis[node] = 1;
		for (Integer it : adj.get(node)) {
			if (vis[it] == 0) {
				dfs(it, vis, adj, st);
			}
		}
		st.push(node);
	}

	private static void dfs3(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
		vis[node] = 1;
		for (Integer it : adjT.get(node)) {
			if (vis[it] == 0) {
				dfs3(it, vis, adjT);
			}
		}
	}
}
