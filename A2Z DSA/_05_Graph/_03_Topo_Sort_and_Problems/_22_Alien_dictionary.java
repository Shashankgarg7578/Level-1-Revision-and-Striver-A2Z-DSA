package _05_Graph._03_Topo_Sort_and_Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _22_Alien_dictionary {
	public static void main(String[] args) {
		int N = 5; // number of elements in array
		int K = 4; //number of diff chars
		String[] dict = { "baa", "abcd", "abca", "cab", "cad" };

		String ans = findOrder(dict, N, K);

		for (int i = 0; i < ans.length(); i++) {
			System.out.print(ans.charAt(i) + " ");
		}
		System.out.println("");
	}


	public static String findOrder(String[] dict, int N, int K) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			adj.add(new ArrayList<>());
		}

//		compare 2-2 elements like bubble sort make adjList(Graph)
		for (int i = 0; i < N - 1; i++) {
			String s1 = dict[i];
			String s2 = dict[i + 1];
			int len = Math.min(s1.length(), s2.length());
			for (int ptr = 0; ptr < len; ptr++) {
				if (s1.charAt(ptr) != s2.charAt(ptr)) {
					adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
					break;
				}
			}
		}

		//newly made graph or adjList find topoSort
		List<Integer> topo = topoSort(K, adj);
		String ans = "";
		for (int it : topo) {
			ans = ans + (char) (it + (int) ('a'));
		}

		return ans;

	}
	
	private static List<Integer> topoSort(int V, List<List<Integer>> adj) {
		int indegree[] = new int[V];
		for (int i = 0; i < V; i++) {
			for (int it : adj.get(i)) {
				indegree[it]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < V; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		List<Integer> topo = new ArrayList<>();
		while (!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			topo.add(node);
			// node is in your topo sort
			// so please remove it from the indegree

			for (int it : adj.get(node)) {
				indegree[it]--;
				if (indegree[it] == 0)
					q.add(it);
			}
		}

		return topo;
	}


}
