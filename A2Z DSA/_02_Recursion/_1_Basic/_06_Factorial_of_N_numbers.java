package _02_Recursion._1_Basic;

public class _06_Factorial_of_N_numbers {
	public static void main(String[] args) {
		int X = 5;
		int result = factorial(X);
		System.out.println("The factorial of " + X + " is " + result);
	}

	private static int factorial(int i) {
		if (i == 1) {
			return 1;
		}

		return i * factorial(i - 1);
	}

}
