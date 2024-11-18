package Recursion._1_Basic;

public class _09_Fibonacci_Number {
	public static void main(String[] args) {

// fib numbers : 0 1 1 2 3 5 8 13

		// Here, let’s take the value of N to be 4.
		int N = 4;

		fibonacci1(N);

		fibonacci2(N);

		System.out.println(fibonacci3(N));

	}

	// Brute force
//	Time Complexity: O(n)+O(n)
//	Space Complexity: O(n)
	static void fibonacci1(int n) {
		if (n == 0) {
			System.out.println(0);
		} else {
			int fib[] = new int[n + 1];
			fib[0] = 0;
			fib[1] = 1;
			for (int i = 2; i <= n; i++) {
				fib[i] = fib[i - 1] + fib[i - 2];
			}
			System.out.println("The Fibonacci Series up to " + n + "th term:");
			for (int i = 0; i <= n; i++) {
				System.out.print(fib[i] + " ");
			}
		}
	}

	// Better space comp
	// Time Complexity: O(N)
	// Space Complexity: O(1)
	static void fibonacci2(int n) {
		if (n == 0) {
			System.out.println("The Fibonacci Series up to " + n + "th term:");
			System.out.print(0);
		} else {
			int secondLast = 0;
			int last = 1;
			System.out.println("The Fibonacci Series up to " + n + "th term:");
			System.out.print(secondLast + " " + last + " ");
			int cur;
			for (int i = 2; i <= n; i++) {
				cur = last + secondLast;
				secondLast = last;
				last = cur;
				System.out.print(cur + " ");
			}
		}
	}

	// with recursion
//	Time Complexity: O(2^N)
//	Space Complexity: O(N) 
	static int fibonacci3(int N) {
		// Base Condition.
		if (N <= 1) {

			return N;
		}

		// Problem broken down into 2 functional calls
		// and their results combined and returned.
		int last = fibonacci3(N - 1);
		int slast = fibonacci3(N - 2);

		return last + slast;

	}

}
