package _02_Recursion._1_Basic;

public class _03_Print_1_to_N_using_recursion {
	public static void main(String[] args) {
		int n = 4;

		func(0, n);
		System.out.println();
		func2(n, n);
	}

	private static void func(int i, int n) {

		if (i >= n) {
			return;
		}

		i++;
		System.out.println(i);
		func(i, n);
	}

	// Using Backtracking
	private static void func2(int i, int n) {

		if (i == 0) {
			return;
		}

		func2(i - 1, n);
		System.out.println(i);
	}

}
