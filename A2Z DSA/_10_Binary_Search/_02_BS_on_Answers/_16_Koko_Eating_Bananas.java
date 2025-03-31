package _10_Binary_Search._02_BS_on_Answers;

public class _16_Koko_Eating_Bananas {
	public static void main(String[] args) {
		int[] v = { 7, 15, 6, 3 };
		int h = 8;
		int ans = minimumRateToEatBananas(v, h);
		System.out.println("Koko should eat at least " + ans + " bananas/hr.");

		int ans2 = minimumRateToEatBananas2(v, h);
		System.out.println("Koko should eat at least " + ans2 + " bananas/hr.");
	}

	// Brute force for explore al from 1 banana/hour to n banana/hour
//	Time Complexity: O(max(a[]) * N)
//	Space Complexity: O(1)
	private static int minimumRateToEatBananas(int[] v, int h) {

		int maxi = findMax(v);

		for (int i = 0; i < maxi; i++) {

			int reqTime = calculateTotalHours(v, i);
			if (reqTime <= h) {
				return i;
			}
		}

		return maxi;
	}

	private static int calculateTotalHours(int[] v, int h) {

		int totalH = 0;

		for (int i = 0; i < v.length; i++) {

			totalH += Math.ceil(((double) v[i] / (double) h));
		}

		return totalH;
	}

	private static int findMax(int[] V) {
		int maxi = Integer.MIN_VALUE;

		for (int i = 0; i < V.length; i++) {
			maxi = Math.max(maxi, V[i]);
		}

		return maxi;
	}

	// Optimal by Binary Search because it is in range 1 to Max
	private static int minimumRateToEatBananas2(int[] v, int h) {

		int low = 1;
		int high = findMax(v);

		while (low <= high) {
			int mid = (low + high) / 2;

			int totalH = calculateTotalHours(v, mid);

			if (totalH <= h) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

}
