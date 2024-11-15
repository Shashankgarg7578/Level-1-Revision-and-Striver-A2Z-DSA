package Arrays._2_Medium;

//blog :https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/ 
// Question : https://leetcode.com/problems/next-permutation/
public class _20_Next_Permutation {
	public static void main(String[] args) {
		int[] arr = { 2, 1, 5, 4, 3, 0, 0 };
		int[] ans = nextGreaterPermutation(arr);

		System.out.print("The next permutation is: [");
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
		System.out.println("]");
	}

	// Brute force
//	Step 1: Find all possible permutations of elements present and store them.
//	Step 2: Search input from all possible permutations.
//	Step 3: Print the next permutation present right after it.

	// Better :- In C++ there is function for next_permutation.

	// Optimal
//	Time Complexity: O(3N)
//	Space Complexity: O(1)
	private static int[] nextGreaterPermutation(int[] arr) {
		int idx = -1;

		// Step 1: Find the break point: find dip(where increasing order from last
		// break) from last
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] < arr[i + 1]) {
				idx = i;
				break;
			}
		}

		// If break point does not exist:
		if (idx == -1) {
			// reverse the whole array:
			reverseArr(arr, 0, arr.length - 1);
			return arr;
		}

		// Step 2: Find the next greater element and swap it with arr[ind]:
		for (int i = arr.length - 1; i > idx; i--) {
			if (arr[i] > arr[idx]) {
				int temp = arr[i];
				arr[i] = arr[idx];
				arr[idx] = temp;
				break;
			}
		}
		//Step 3: reverse the right half: for make small number
		reverseArr(arr, idx + 1, arr.length - 1);
		
		return arr;
	}

	private static void reverseArr(int[] arr, final int a, final int b) {
		int i = a;
		int j = b;

		while (i < j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;

			i++;
			j--;
		}

	}

}
