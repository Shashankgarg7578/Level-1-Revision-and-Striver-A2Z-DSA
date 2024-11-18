package Recursion._1_Basic;

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

		System.out.println(i);
		i++;
		func(i, n);
	}

	private static void func2(int i, int n) {

		if (i == 0) {
			return;
		}

		i = i - 1;
		func2(i, n);
		System.out.println(i + 1);
	}

}
