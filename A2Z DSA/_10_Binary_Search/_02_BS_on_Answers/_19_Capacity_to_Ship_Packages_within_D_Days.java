package _10_Binary_Search._02_BS_on_Answers;

public class _19_Capacity_to_Ship_Packages_within_D_Days {
	public static void main(String[] args) {

		// we have to put all data in Ship and try to least max capacity of Ship
		int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int days = 5;
		int ans = leastWeightCapacity(weights, days);
		System.out.println("The minimum capacity should be: " + ans);

		int ans2 = leastWeightCapacity2(weights, days);
		System.out.println("The minimum capacity should be: " + ans2);

	}

	// Brute force
//	Time Complexity: O(N * (sum(weights[]) - max(weights[]) + 1))
	private static int leastWeightCapacity(int[] weights, int d) {

		int maxi = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < weights.length; i++) {
			sum += weights[i];
			maxi = Math.max(maxi, weights[i]);
		}

		for (int i = maxi; i <= sum; i++) {
			if (findDays(weights, i) <= d) {
				return i;
			}
		}

		return -1;
	}

	private static int findDays(int[] weights, int cap) {

		int days = 1;
		int load = 0;

		int n = weights.length;

		for (int i = 0; i < n; i++) {

			if (load + weights[i] > cap) {
				days += 1;
				load = weights[i];
			} else {
				load += weights[i];
			}

		}

		return days;
	}

	// optimal
	// Time Complexity: O(N * log(sum(weights[]) - max(weights[]) + 1))
	private static int leastWeightCapacity2(int[] weights, int d) {

		int maxi = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < weights.length; i++) {
			sum += weights[i];
			maxi = Math.max(maxi, weights[i]);
		}

		int low = maxi;
		int high = sum;

		while (low <= high) {

			int mid = (low + high) / 2;

			int numberOfDays = findDays(weights, mid);

			if (numberOfDays <= d) {
				// eliminate right half
				high = mid - 1;
			} else {
				// eliminate left half
				low = mid + 1;
			}

		}

		return low;
	}

}
