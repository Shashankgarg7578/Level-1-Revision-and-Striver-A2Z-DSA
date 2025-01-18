package _05_Graph._04_Shortest_Path_Algos_and_Problems;

import java.util.LinkedList;
import java.util.Queue;

public class _26_Shortest_path_in_a_binary_maze {
	public static void main(String[] args) {
	       
        int[] source={0,1};
        int[] destination={2,2};
        
        int[][] grid= {{1, 1, 1, 1},
                       {1, 1, 0, 1},
                       {1, 1, 1, 1},
                       {1, 1, 0, 0},
                       {1, 0, 0, 1}};

        int res = shortestPath(grid, source, destination);
        
        System.out.print(res);
        System.out.println();
    }

	private static int shortestPath(int[][] grid, int[] source, int[] destination) {

		Queue<tuple> q = new LinkedList<tuple>();

		int n = grid.length;
		int m = grid[0].length;

		int dist[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dist[i][j] = (int) 1e9;
			}
		}

		dist[source[0]][source[1]] = 0;
		q.add(new tuple(0, source[0], source[1]));

		int dr[] = { -1, 0, 1, 0 };
		int dc[] = { 0, 1, 0, -1 };

		while (!q.isEmpty()) {
			tuple tuple = q.peek();
			q.remove();

			int dis = tuple.first;
			int r = tuple.second;
			int c = tuple.third;

			// for all 4 direction
			for (int i = 0; i < 4; i++) {
				int newr = dr[i] + r;
				int newc = dc[i] + c;

				if (newr >= 0 && newc >= 0 && newr < n && newc < m && grid[newr][newc] == 1
						&& dist[newr][newc] > dis + 1) {

					// assign small values
					dist[newr][newc] = dis + 1;

					if (newr == destination[0] && newc == destination[1]) {
						return dis + 1;
					}

					q.add(new tuple(dis + 1, newr, newc));
				}

			}
		}

		return -1;
	}
}

class tuple { 
    int first; //distance
    int second;//row
    int third; //col
    tuple(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}
