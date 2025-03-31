package _05_Graph._05_MinimumSpanningTree_Disjoint_Set_and_Problems;

import java.util.ArrayList;
import java.util.PriorityQueue;

class Pair {
	int node;
	int distance;

	public Pair(int distance, int node) {
		this.node = node;
		this.distance = distance;
	}
}

//Minimum Spanning Tree :- 
//(A.) Tree in which we have N node & N-1 edges & all nodes are reachcable from each other.
//(B.) In MST we explore all trees and which Tree have minimum sum that is our MST
//(C.) For find MST  we will use 2 Algos:- (a.) Prims (b.) Kruskal's

public class _36_Prims_Algorithum {
	public static void main(String[] args) {
		int V = 5;
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
		int[][] edges = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 2, 1 }, { 2, 3, 2 }, { 3, 4, 1 }, { 4, 2, 2 } };

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<ArrayList<Integer>>());
		}

		for (int i = 0; i < 6; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int w = edges[i][2];

			ArrayList<Integer> tmp1 = new ArrayList<Integer>();
			ArrayList<Integer> tmp2 = new ArrayList<Integer>();
			tmp1.add(v);
			tmp1.add(w);

			tmp2.add(u);
			tmp2.add(w);

			adj.get(u).add(tmp1);
			adj.get(v).add(tmp2);
		}

		int sum = spanningTree(V, adj);
		System.out.println("The sum of all the edge weights: " + sum);
	}

	private static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {

		// sort on the basis of weight
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

		int[] vis = new int[V];

		pq.add(new Pair(0, 0));

		int sum = 0;

		while (pq.size() > 0) {
			int wt = pq.peek().distance;
			int node = pq.peek().node;

			pq.remove();

			// skip already visited node
			if (vis[node] == 1)
				continue;

			vis[node] = 1;
			sum += wt;

			for (int i = 0; i < adj.get(node).size(); i++) {
				int edW = adj.get(node).get(i).get(1);
				int adjNode = adj.get(node).get(i).get(0);
				if (vis[adjNode] == 0) {
					pq.add(new Pair(edW, adjNode));
				}

			}

		}

		return sum;
	}
}
