package Graph._04_Shortest_Path_Algos_and_Problems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class _25_Djisktra_Algo_by_PriorityQueue {
	public static void main(String[] args) throws IOException {
		int V = 3, E = 3, S = 2;
		ArrayList<Integer> node1 = new ArrayList<Integer>() {
			{
				add(1);
				add(1);
			}
		};
		ArrayList<Integer> node2 = new ArrayList<Integer>() {
			{
				add(2);
				add(6);
			}
		};
		ArrayList<Integer> node3 = new ArrayList<Integer>() {
			{
				add(2);
				add(3);
			}
		};
		ArrayList<Integer> node4 = new ArrayList<Integer>() {
			{
				add(0);
				add(1);
			}
		};
		ArrayList<Integer> node5 = new ArrayList<Integer>() {
			{
				add(1);
				add(3);
			}
		};
		ArrayList<Integer> node6 = new ArrayList<Integer>() {
			{
				add(0);
				add(6);
			}
		};

		ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>() {
			{
				add(node1);
				add(node2);
			}
		};
		ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>() {
			{
				add(node3);
				add(node4);
			}
		};
		ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>() {
			{
				add(node5);
				add(node6);
			}
		};
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>() {
			{
				add(inter1); // for 1st node
				add(inter2); // for 2nd node
				add(inter3); // for 3rd node
			}
		};
		// add final values of adj here.
		int[] res = dijkstra(V, adj, S);

		for (int i = 0; i < V; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();

	}

	private static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {

		// for sorting on the basis of distance
		PriorityQueue<Pair02> pq = new PriorityQueue<Pair02>((x, y) -> x.distance - y.distance);

		// same as visited array but here for minimum weight path
		int[] distArr = new int[v];

		for (int i = 0; i < v; i++) {
			distArr[i] = (int) 1e9;
		}

		distArr[s] = 0;

		// add pair(distance, src)
		pq.add(new Pair02(0, s));

		while (pq.size() != 0) {
			int dist = pq.peek().distance;
			int node = pq.peek().node;
			pq.remove();

			for (int i = 0; i < adj.get(node).size(); i++) {
				// get new adj node wt, and node
				int edgeWeight = adj.get(node).get(i).get(1);
				int adjNode = adj.get(node).get(i).get(0);

				// check new weight and last weight
				if (dist + edgeWeight < distArr[adjNode]) {
					distArr[adjNode] = dist + edgeWeight;
					pq.add(new Pair02(distArr[adjNode], adjNode));
				}
			}

		}

		return distArr;
	}
}

class Pair02 {
	int node;
	int distance;

	public Pair02(int distance, int node) {
		this.node = node;
		this.distance = distance;
	}

}
