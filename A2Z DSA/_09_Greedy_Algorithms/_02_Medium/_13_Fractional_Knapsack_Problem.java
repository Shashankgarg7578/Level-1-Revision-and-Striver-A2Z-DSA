package _09_Greedy_Algorithms._02_Medium;

import java.util.Arrays;
import java.util.Comparator;

public class _13_Fractional_Knapsack_Problem {

	static class Item {
		int value, weight;

		Item(int x, int y) {
			this.value = x;
			this.weight = y;
		}
	}

	static class ItemComparator implements Comparator<Item> {

		@Override
		public int compare(Item a, Item b) {
			double r1 = (double) (a.value) / (double) (a.weight);
			double r2 = (double) (b.value) / (double) (b.weight);

			if (r1 < r2) {
				return 1;
			} else if (r1 > r2) {
				return -1;
			} else {
				return 0;
			}

		}

	}

	public static void main(String args[]) {
		int n = 3, weight = 50;
		Item arr[] = { new Item(100, 20), new Item(60, 10), new Item(120, 30) };
		double ans = fractionalKnapsack(weight, arr, n);
		System.out.println("The maximum value is " + ans);
	}

//	Time Complexity: O(n log n + n). O(n log n) to sort the items and O(n) to iterate through all the items for calculating the answer.
//	Space Complexity: O(1), no additional data structure has been used.
	private static double fractionalKnapsack(int weight, Item[] arr, int n) {

		// sort on the basis of there pair devide value
		Arrays.sort(arr, new ItemComparator());

		int currWeight = 0;
		double finalValue = 0.0;

		// take max values and in end if anything little left and calculate from end on
		// the basis of lefted value
		for (int i = 0; i < arr.length; i++) {
			if (currWeight + arr[i].weight <= weight) {
				currWeight += arr[i].weight;
				finalValue += arr[i].value;
			} else {
				int remain = weight - currWeight;
				finalValue += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
				break;
			}

		}

		return finalValue;
	}

}
