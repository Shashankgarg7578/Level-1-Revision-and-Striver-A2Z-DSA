package _10_Binary_Search._02_BS_on_Answers;

public class _20_Kth_Missing_Positive_Number {

	public static void main(String[] args) {
		int[] vec = { 4, 7, 9, 10 };
		int n = vec.length;
		int k = 4;
//		kth missing number means in above 1 , 2, 3, 4, 5, 6, 7, 8, 9, 10
//     		                  missing :=  1 , 2, 3,  , 4, 5,    6,
		int ans = missingK(vec, n, k);
		System.out.println("The missing number is: " + ans);

		int ans2 = missingK2(vec, n, k);
		System.out.println("The missing number is: " + ans2);

	}

	// Brute force
	// Time Complexity: O(N)
	private static int missingK(int[] vec, int n, int k) {

		for (int i = 0; i < n; i++) {
			if (vec[i] <= k) {
				k++;
			} else {
				break;
			}
		}

		return k;
	}

	// we have to do some math derivation here so use YouTube video
    //Optimal
	private static int missingK2(int[] vec, int n, int k) {
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			int missing = vec[mid] - (mid + 1);

			if (missing < k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return k + high + 1; // this is derivative
	}

}
