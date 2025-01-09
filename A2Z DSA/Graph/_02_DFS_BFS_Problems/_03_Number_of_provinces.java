package Graph._02_DFS_BFS_Problems;

import java.util.ArrayList;

public class _03_Number_of_provinces {
	public static void main(String[] args) {

		// adjacency matrix
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

		adj.add(new ArrayList<Integer>());
		adj.get(0).add(0, 1);
		adj.get(0).add(1, 0);
		adj.get(0).add(2, 1);
		adj.add(new ArrayList<Integer>());
		adj.get(1).add(0, 0);
		adj.get(1).add(1, 1);
		adj.get(1).add(2, 0);
		adj.add(new ArrayList<Integer>());
		adj.get(2).add(0, 1);
		adj.get(2).add(1, 0);
		adj.get(2).add(2, 1);

		System.out.println(numProvinces(adj, 3));
	}

	//using DFS
	private static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {

		//make new adjacency list
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<Integer>());
		}

		//add all data in adjList
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (adj.get(i).get(j) == 1 && i != j) {
					adjList.get(i).add(j);
					adjList.get(j).add(i);
				}
			}
		}

		int cnt = 0;
       //make for visited nodes
		int vis[] = new int[V];
		for (int i = 0; i < V; i++) {
			if (vis[i] == 0) {
				cnt++;
				//go in depth
				dfs(i, adjList, vis);
			}
		}

		return cnt;
	}

	private static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis) {

		vis[node] = 1;

		for (Integer it : adjList.get(node)) {
			if (vis[it] == 0) {
				dfs(it, adjList, vis);
			}
		}
	}
}
