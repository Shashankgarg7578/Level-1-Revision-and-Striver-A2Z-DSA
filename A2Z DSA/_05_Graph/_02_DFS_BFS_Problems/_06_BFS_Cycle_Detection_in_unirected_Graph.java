package _05_Graph._02_DFS_BFS_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int first; //child
	int second; // parent

	public Node(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class _06_BFS_Cycle_Detection_in_unirected_Graph {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(2).add(3);
		adj.get(3).add(2);
		adj.get(3).add(1);

		boolean ans = isCycle(4, adj);
		if (ans)
			System.out.println("1");
		else
			System.out.println("0");
	}

	// using BFS level order traversal
	private static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {

		//make visited array for visited node
		boolean[] vis = new boolean[V];
		Arrays.fill(vis, false);

		//traverse all nodes
		for (int i = 0; i < V; i++) {
			if (vis[i] == false) {
				if (checkForCycle(i, vis, adj)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean checkForCycle(int s, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {

		Queue<Node> q = new LinkedList<Node>();

		q.add(new Node(s, -1));
		vis[s] = true;

		while (!q.isEmpty()) {
			int node = q.peek().first;
			int par = q.peek().second;
			q.remove();

			for (Integer it : adj.get(node)) {
				if (vis[it] == false) {
					q.add(new Node(it, node));
					vis[it] = true;
				}
				else if (par != it) {
					//parent is not same.
					return true;
				}
			}

		}

		return false;
	}

}
