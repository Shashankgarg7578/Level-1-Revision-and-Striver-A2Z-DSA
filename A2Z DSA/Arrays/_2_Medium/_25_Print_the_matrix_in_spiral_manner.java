package Arrays._2_Medium;

import java.util.ArrayList;
import java.util.List;

//blog : https://takeuforward.org/data-structure/spiral-traversal-of-matrix/
//Question : https://leetcode.com/problems/spiral-matrix/
public class _25_Print_the_matrix_in_spiral_manner {
	public static void main(String[] args) {

		// Matrix initialization.
		int[][] mat = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		List<Integer> ans = null;
		try {
			ans = printSpiral(mat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

		System.out.println();
	}

	//Optimal
	//Time Complexity: O(m x n)
	//Space Complexity: O(n) 
	public static List<Integer> printSpiral(int[][] matrix) {
		List<Integer> ans = new ArrayList<Integer>();
		
		int minr = 0;
		int minc = 0;
		int maxr = matrix.length - 1;
		int maxc = matrix[0].length - 1;
		int tc = matrix.length * matrix[0].length;
		int count = 0;

		while (count < tc) {
			for (int i = minr, j = minc; j <= maxc && count < tc; j++) {
				ans.add(matrix[i][j]);
				count++;
			}
			minr++;

			for (int i = minr, j = maxc; i <= maxr && count < tc; i++) {
				ans.add(matrix[i][j]);
				count++;
			}
			maxc--;

			for (int i = maxr, j = maxc; j >= minc && count < tc; j--) {
				ans.add(matrix[i][j]);
				count++;
			}
			maxr--;

			for (int i = maxr, j = minc; i >= minr && count < tc; i--) {
				ans.add(matrix[i][j]);
				count++;
			}
			minc++;
		}
		return ans;

	}

}
