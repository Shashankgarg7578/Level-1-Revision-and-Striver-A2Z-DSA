package _05_Graph._01_Basic_Learn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _01_BFS_LevelOrderTraversal {
	public static void main(String args[]) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(4);
		adj.get(4).add(0);
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(1).add(3);
		adj.get(3).add(1);

		ArrayList<Integer> ans = bfsOfGraph(5, adj);
		int n = ans.size();
		for (int i = 0; i < n; i++) {
			System.out.print(ans.get(i) + " ");
		}
	}

	// Level Order Traversal
	private static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> bfs = new ArrayList<Integer>();

		Queue<Integer> q = new LinkedList<Integer>();
		//for all visited nodes
		boolean[] vis = new boolean[V];

		q.add(0);

		vis[0] = true;

		while (!q.isEmpty()) {

			Integer tempVal = q.poll();
		
			//add in bfs
			bfs.add(tempVal);

			//traverse child's and add in queue.
			for (int a : adj.get(tempVal)) {
				if (vis[a] == false) {
					q.add(a);
					vis[a] = true;
				}
			}
		}

		return bfs;
	}
}
