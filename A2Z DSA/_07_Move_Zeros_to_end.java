package Arrays;

import java.util.ArrayList;

//blog : https://takeuforward.org/data-structure/move-all-zeros-to-the-end-of-the-array/
//Question : https://leetcode.com/problems/move-zeroes/
public class _07_Move_Zeros_to_end {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
		int n = 10;
		int[] ans = moveZeros(n, arr);
		for (int i = 0; i < n; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println("");

		System.out.println();

		int[] arr2 = {1};
		int m = 1;
		int[] ans2 = moveZeros2(m, arr2);
		for (int i = 0; i < m; i++) {
			System.out.print(ans2[i] + " ");
		}
		System.out.println("");
	}

	// Brute Force
//	Time Complexity: O(N) + O(X) + O(N-X) ~ O(2*N), where N = total no. of elements,
//	X = no. of non-zero elements, and N-X = total no. of zeros.
//	Reason: O(N) for copying non-zero elements from the original to the temporary array. O(X) for again copying it back from the temporary to the original array. O(N-X) for filling zeros in the original array. So, the total time complexity will be O(2*N).
//
//	Space Complexity: O(N), as we are using a temporary array to solve this problem and the maximum size of the array can be N in the worst case.
//	Reason: The temporary array stores the non-zero elements. In the worst case, all the given array elements will be non-zero.
	private static int[] moveZeros(int n, int[] arr) {

		ArrayList<Integer> nzn = new ArrayList<Integer>(); // Non zero numbers
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				nzn.add(arr[i]);
			}
		}

		int nznlen = nzn.size();

		for (int i = 0; i < nznlen; i++) {
			arr[i] = nzn.get(i);
		}

		for (int i = nznlen; i < n; i++) {
			arr[i] = 0;
		}

		return arr;
	}

	// optimal : Two pointers
//	Time Complexity: O(N), N = size of the array.
//	Reason: We have used 2 loops and using those loops, we are basically traversing the array once.
//
//  Space Complexity: O(1) as we are not using any extra space to solve this problem.
	private static int[] moveZeros2(int n, int[] arr) {
       
		if(n == 1) {
			return arr;
		}
		
		int j = -1;
		
		for(int i = 0 ; i < n ; i++) {
			if(arr[i] == 0) {
				j = i;
				break;
			}
		}
		
		if( j == -1) {
			return arr;
		}
		
		for(int i = j+1 ; i < n ; i++) {
			if(arr[i] != 0) {
				swap(arr, i , j);
				j++;
			}
		}
		
		
		return arr;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}













