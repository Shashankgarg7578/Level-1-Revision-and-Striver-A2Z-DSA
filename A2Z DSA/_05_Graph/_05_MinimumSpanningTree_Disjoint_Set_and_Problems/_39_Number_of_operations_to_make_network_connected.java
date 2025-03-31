package _05_Graph._05_MinimumSpanningTree_Disjoint_Set_and_Problems;

public class _39_Number_of_operations_to_make_network_connected {
	public static void main(String[] args) {
		int V = 9;
		int[][] edge = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 2, 3 }, { 4, 5 }, { 5, 6 }, { 7, 8 } };

		int ans = Solve(V, edge);
		System.out.println("The number of operations needed: " + ans);
	}

	private static int Solve(int n, int[][] edge) {

		DisjointSet ds = new DisjointSet(n);

		// count extra edges
		int cntExtra = 0;

		int m = edge.length;

		for (int i = 0; i < m; i++) {
			int u = edge[i][0];
			int v = edge[i][1];

			// for find same parent then
			// that pair is extra
			if (ds.findUPar(u) == ds.findUPar(v)) {
				cntExtra++;
			} else {
				ds.unionBySize(u, v);
			}
		}

		// connected components
		int cntC = 0;

		for (int i = 0; i < n; i++) {
			// for check connected component
			if (ds.parent.get(i) == i) {
				cntC++;
			}
		}

		// because we need 1 less edge count then component
		int ans = cntC - 1;

		if (cntExtra >= ans) {
			return ans;
		}

		return -1;
	}
}
