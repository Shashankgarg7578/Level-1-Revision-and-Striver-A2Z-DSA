package _02_Recursion._1_Basic;

public class _05_Sum_of_first_N_numbers {
	public static void main(String[] args) {

		solve1(5);
		solve1(6);

		System.out.println();
		solve2(5);
		solve2(6);

		System.out.println();
		solve3(5, 0);
		solve3(6, 0);

		System.out.println();
		System.out.println(solve4(5));
		System.out.println(solve4(6));
	}

	// Using for loop
	public static void solve1(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		System.out.println("The sum of the first " + n + " numbers is: " + sum);
	}

	// using math formula
	private static void solve2(int n) {
		int sum = n * (n + 1) / 2;
		System.out.println("The sum of the first " + n + " numbers is: " + sum);
	}

	// using recursion
	private static void solve3(int i, int sum) {
		if (i <= 0) {
			System.out.println(sum);
			return;
		}

		sum += i;
		i--;
		solve3(i, sum);
	}

	// using recursion
	private static int solve4(int i) {
		if (i == 0) {
			return 0;
		}

		return i + solve4(i - 1);
	}

}
