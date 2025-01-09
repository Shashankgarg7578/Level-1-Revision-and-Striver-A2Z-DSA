package Graph._02_DFS_BFS_Problems;

import java.util.ArrayList;

public class _15_Cycle_Detection_in_Directed_Graph_DFS {
	public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        boolean ans = isCyclic(V, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");

    }

	private static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		
		int[] vis = new int[V];
		int[] patsVis = new int[V];
		
		
		for(int i = 0 ; i < V; i++) {
			if(vis[i] == 0) {
				if(dfsCheck(i, adj, vis, patsVis)) return true;
			}
		}
		
		
		return false;
	}

	private static boolean dfsCheck(int i, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] patsVis) {
		vis[i] = 1;
		patsVis[i] = 1;
		
		for(int it : adj.get(i)) {
			if(vis[i] == 0) {
				if(dfsCheck(it, adj, vis, patsVis)) return true;
			}
			else if(patsVis[i] == 1) return true;
			
		}
		
		
		return false;
	}
}
