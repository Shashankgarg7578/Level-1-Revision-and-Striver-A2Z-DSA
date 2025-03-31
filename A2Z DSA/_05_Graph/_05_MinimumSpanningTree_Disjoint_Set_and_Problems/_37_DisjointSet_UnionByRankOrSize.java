package _05_Graph._05_MinimumSpanningTree_Disjoint_Set_and_Problems;

import java.util.ArrayList;
import java.util.List;

class DisjointSet {

	List<Integer> rank = new ArrayList<Integer>();
	List<Integer> parent = new ArrayList<Integer>();
	List<Integer> size = new ArrayList<Integer>();

	public DisjointSet(int n) {
		for (int i = 0; i <= n; i++) {
			rank.add(0);
			parent.add(i);

			// add for size
			size.add(1);
		}
	}

	public int findUPar(int node) {
		if (node == parent.get(node)) {
			return node;
		}

		int ulp = findUPar(parent.get(node));
		parent.set(node, ulp);
		return parent.get(node);
	}

	public void unionByRank(int u, int v) {

		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);

		if (ulp_u == ulp_v) {
			return;
		}

		if (rank.get(ulp_u) < rank.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
		} else if (rank.get(ulp_v) < rank.get(ulp_u)) {
			parent.set(ulp_v, ulp_u);
		} else {
			// if both are same rank then add +1 in rank
			parent.set(ulp_v, ulp_u);
			int rankU = rank.get(ulp_u);
			rank.set(ulp_u, rankU + 1);
		}
	}

	public void unionBySize(int u, int v) {

		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);

		if (ulp_u == ulp_v) {
			return;
		}

		if (size.get(ulp_u) < size.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
			size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
		} else {
			parent.set(ulp_v, ulp_u);
			size.set(ulp_u, size.get(ulp_v) + size.get(ulp_u));
		}

	}

}

public class _37_DisjointSet_UnionByRankOrSize {
	public static void main(String[] args) {
		DisjointSet ds = new DisjointSet(7);
		ds.unionByRank(1, 2);
		ds.unionByRank(2, 3);
		ds.unionByRank(4, 5);
		ds.unionByRank(6, 7);
		ds.unionByRank(5, 6);

		// if 3 and 7 same or not
		if (ds.findUPar(3) == ds.findUPar(7)) {
			System.out.println("Same");
		} else
			System.out.println("Not Same");

		ds.unionByRank(3, 7);
		if (ds.findUPar(3) == ds.findUPar(7)) {
			System.out.println("Same");
		} else
			System.out.println("Not Same");
	}
}
