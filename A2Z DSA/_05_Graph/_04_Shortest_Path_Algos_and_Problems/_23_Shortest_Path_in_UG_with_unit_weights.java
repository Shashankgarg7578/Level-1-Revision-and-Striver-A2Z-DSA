package _05_Graph._04_Shortest_Path_Algos_and_Problems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Undirected Graph in which Unit Weight is 1 for every edge
public class _23_Shortest_Path_in_UG_with_unit_weights {
	
	public static void main(String[] args) throws IOException {
		int n = 9; //vertices
		int m = 10; //edges
		int[][] edge = { { 0, 1 }, 
				         { 0, 3 }, 
				         { 3, 4 }, 
				         { 4, 5 }, 
				         { 5, 6 }, 
				         { 1, 2 }, 
				         { 2, 6 }, 
				         { 6, 7 }, 
				         { 7, 8 }, 
				         { 6, 8 } };

		int res[] = shortestPath(edge, n, m, 0);
		for (int i = 0; i < n; i++) {
			System.out.print(res[i] + " ");
		}
		System.out.println();
	}

	private static int[] shortestPath(int[][] edge, int n, int m, int src) {
		
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		
		//make adjList on the basis of given Vertices
		for(int i = 0 ; i< n; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		//fill those adjList vertices index by edge connection
		for(int i = 0 ;i<m ; i++) {
			adjList.get(edge[i][0]).add(edge[i][1]);
			adjList.get(edge[i][1]).add(edge[i][0]);
		}

		//distance array same as visited array
		int dist[] = new int[n];
		for(int i = 0; i < n; i++) {
			dist[i] = (int) 1e9;
		}
		
		//initialize with 0 as source index
		dist[src] = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		
		while(!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			
			for(int it: adjList.get(node)) {
				if (dist[node] + 1 < dist[it]) {
                   dist[it] = dist[node] + 1;
                   q.add(it);
				}
			}
		}
		
		
		for(int i = 0 ; i < n ;i++) {
			if(dist[i] == 1e9) {
				dist[i] =-1;
			}
		}
		
		return dist;
	}
}
