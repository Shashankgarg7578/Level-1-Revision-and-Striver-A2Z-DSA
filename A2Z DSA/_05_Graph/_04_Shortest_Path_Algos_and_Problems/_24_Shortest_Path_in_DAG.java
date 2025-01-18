package _05_Graph._04_Shortest_Path_Algos_and_Problems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

//related to "DFS by stack" and Q23 Algo
public class _24_Shortest_Path_in_DAG {
	
	public static void main(String[] args) throws IOException {
		int n = 6; //vertices
		int m = 7; //edges
//		                 src, dest, weight
		int[][] edge = { { 0, 1, 2 }, 
				         { 0, 4, 1 }, 
				         { 4, 5, 4 }, 
				         { 4, 2, 2 }, 
				         { 1, 2, 3 }, 
				         { 2, 3, 6 }, 
				         { 5, 3, 1 } };
		
		int res[] = shortestPath(n, m, edge);
		for (int i = 0; i < n; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
	}

	private static int[] shortestPath(int N, int M, int[][] edge) {
		
		ArrayList<ArrayList<Pair>> adjList = new ArrayList<ArrayList<Pair>>();
		
		for(int i = 0 ; i < N;i++) {
			ArrayList<Pair> temp = new ArrayList<Pair>();
		    adjList.add(temp);
		}
		
		
		for (int i = 0; i < M; i++) {
			int u = edge[i][0];
			int v = edge[i][1];
			int wt = edge[i][2];

			adjList.get(u).add(new Pair(v, wt));
		}
	
		//first step to use topo sort by DFS
		int vis[] = new int[N];
		Stack<Integer> st = new Stack<Integer>();
		
		for(int i = 0 ; i <N;i++) {
			if(vis[i] == 0) {
				topoSort(i, adjList, vis, st);
			}
		}
		
		//second step to check path on the basis of weights
		int[] dist = new int[N];
		for(int i= 0; i < N;i++) {
			dist[i] = (int) 1e9;
		}
		
		dist[0] = 0;
		while(!st.isEmpty()) {
		  int node = st.peek();
		  st.pop();
		  
		  for(Pair pair : adjList.get(node)) {
			  int v = pair.first;
			  int wt = pair.second;
			  
			  if(dist[node] + wt < dist[v]) {
				  dist[v] = dist[node] + wt;
			  }  
		  }
		}

		for (int i = 0; i < N; i++) {
			if (dist[i] == 1e9)
				dist[i] = -1;
		}
		
		
		return dist;
	}

	private static void topoSort(int node, ArrayList<ArrayList<Pair>> adjList, int[] vis, Stack<Integer> st) {
		vis[node] = 1;

		for (Pair pair : adjList.get(node)) {
			if (vis[pair.first] == 0) {
				topoSort(pair.first, adjList, vis, st);
			}
		}

		st.push(node);
	}

}

class Pair {
	int first;  //negibour node
	int second; //weight

	Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}