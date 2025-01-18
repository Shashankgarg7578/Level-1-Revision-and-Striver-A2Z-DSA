package _02_Recursion._1_Basic;

public class _11_print_zig_zag {

	public static void main(String[] args) {
		printZigZag(2);
	}

	private static void printZigZag(int n) {

		if (n == 0) {
			return;
		}

		System.out.println("Pre: " + n);
		printZigZag(n - 1);
		System.out.println("In: " + n);
		printZigZag(n - 1);
		System.out.println("Post: " + n);

	}

}
