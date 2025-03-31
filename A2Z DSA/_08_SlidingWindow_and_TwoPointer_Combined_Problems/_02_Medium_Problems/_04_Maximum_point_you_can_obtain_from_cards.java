package _08_SlidingWindow_and_TwoPointer_Combined_Problems._02_Medium_Problems;

public class _04_Maximum_point_you_can_obtain_from_cards {
	public static void main(String[] args) {

		// Pick k elements from front or back but not from middle
		int[] arr = { 6, 2, 3, 4, 7, 2, 1, 7, 1 };
		int k = 4;

		System.out.println(maxScore(arr, k));

		// example :- 6, 2, 3, 4
//		              6, 2, 3, 1              
//		              6, 2, 7, 1 
//		              6, 1, 7, 1
//		              2, 1, 7, 1

	}

	// TC : O(2K)
	// SC : O(1)
	public static int maxScore(int[] cardPoints, int k) {

		int n = cardPoints.length;

		int maxSum = 0;

		int lsum = 0, rsum = 0;

		// first get sum of all k elements from front
		for (int i = 0; i <= k - 1; i++) {
			lsum = lsum + cardPoints[i];
			maxSum = Math.max(maxSum, lsum);
		}

		// now start removing from first and increase in last
		int right = n - 1;
		for (int i = k - 1; i >= 0; i--) {
			lsum = lsum - cardPoints[i];
			rsum = rsum + cardPoints[right];
			right = right - 1;
			maxSum = Math.max(maxSum, lsum + rsum);
		}

		return maxSum;
	}

}
