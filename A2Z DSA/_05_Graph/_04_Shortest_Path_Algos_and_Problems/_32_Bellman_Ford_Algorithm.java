package _05_Graph._04_Shortest_Path_Algos_and_Problems;

import java.util.ArrayList;
import java.util.Arrays;

//same as djisktra but here we will relax all edges till N-1 times. 
//this we are using for negative cycles. because in djisktra algo it goes in infinity loop
public class _32_Bellman_Ford_Algorithm {
	public static void main(String[] args) {
		int V = 6;
		int S = 0;
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
			{
				add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
				add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
				add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
				add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
				add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
				add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
				add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
			}
		};

		int[] dist = bellman_ford(V, edges, S);
		for (int i = 0; i < V; i++) {
			System.out.print(dist[i] + " ");
		}
		System.out.println("");
	}

	// Time Complexity: O(V*E), where V = no. of vertices and E = no. of Edges.
	// Space Complexity: O(V) for the distance array which stores the minimized distances.
	private static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int s) {
		int dist[] = new int[V];
		for (int i = 0; i < V; i++) {
			dist[i] = (int) (1e8);
		}
		// for first node
		dist[0] = 0;

		// we have to relax all edges every-time till V-1 time.
		for (int i = 0; i < V - 1; i++) {
			for (ArrayList<Integer> it : edges) {
				int u = it.get(0);
				int v = it.get(1);
				int wt = it.get(2);

				if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
					dist[v] = dist[u] + wt;
				}

			}
		}

		// this is for if we have cycle
		for (ArrayList<Integer> it : edges) {
			int u = it.get(0);
			int v = it.get(1);
			int wt = it.get(2);

			if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
				int temp[] = new int[1];
				temp[0] = -1;
				return temp;
			}

		}

		return dist;
	}
}
