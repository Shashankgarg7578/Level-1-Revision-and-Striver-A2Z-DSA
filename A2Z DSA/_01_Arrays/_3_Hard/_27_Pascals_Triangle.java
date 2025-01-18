package _01_Arrays._3_Hard;

import java.util.ArrayList;
import java.util.List;

//blog : https://takeuforward.org/data-structure/program-to-generate-pascals-triangle/
//Question : https://leetcode.com/problems/pascals-triangle/description/

//Question Variations : 
//Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
//Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.
//Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.

public class _27_Pascals_Triangle {
	public static void main(String[] args) {
		int r1 = 5; // row number
		int c1 = 3; // col number
		int element1 = pascalTriangle(r1, c1);
		System.out.println("The element at position (r,c) is: " + element1);

		System.out.println();
		System.out.println();
		
		int n1 = 5;
		pascalTriangle2(n1);

		System.out.println();
		System.out.println();
		
		int n2 = 5;
		pascalTriangle3(n2);
		
		System.out.println();
		System.out.println();
		
		int n = 5;
        List<List<Integer>> ans = pascalTriangle4(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }

	}

	// Variation 1 : Brute force
//	Time Complexity: O(c)
//	Space Complexity: O(1)
	private static int pascalTriangle(int r, int c) {
		int element = (int) nCr(r - 1, c - 1);
		return element;
	}

	// refer blog for better understanding and formula : nCr = n! / (r! * (n-r)!)
	private static int nCr(int n, int r) {
		int res = 1;

		// calculating nCr:
		for (int i = 0; i < r; i++) {
			res = res * (n - i);
			res = res / (i + 1);
		}

		return res;
	}

	// Variation 2 : Brute force
//	Time Complexity: O(n*r)
//	Space Complexity: O(1)
	private static void pascalTriangle2(int n) {
		for (int c = 1; c <= n; c++) {
			System.out.print(nCr(n-1, c-1)+" ");
		}
	}
	
	// Variation 2 : Optimized
//	Time Complexity: O(n)
//	Space Complexity: O(1)
// refer video for math explanation :- https://www.youtube.com/watch?v=bR7mQgwQ_o8&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=20
	private static void pascalTriangle3(int n) {
		int ans = 1;
		System.out.print(ans+" ");
		for (int i = 1; i < n; i++) {
	        //we are making through of previous ans
			ans = ans * (n-i);
			ans = ans / i;
			System.out.print(ans+" ");
		}
	}

	//Variation :3 : Optimal
//	Time Complexity: O(n*n*r) ~ O(n3)
//	Space Complexity: O(1)
	private static List<List<Integer>> pascalTriangle4(int n) {
		List<List<Integer>> ansList = new ArrayList<List<Integer>>();
		for(int row = 1 ; row <= n ; row++) {
			List<Integer> tempList = new ArrayList<Integer>();
			for(int col = 1 ; col <= row ; col++) {
				tempList.add(nCr(row-1, col-1));
			}
			ansList.add(tempList);
		}
		
		return ansList;
	}

}

