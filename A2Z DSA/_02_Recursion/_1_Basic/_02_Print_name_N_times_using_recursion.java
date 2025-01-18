package _02_Recursion._1_Basic;

public class _02_Print_name_N_times_using_recursion {
	public static void main(String[] args) {
		// Here, let’s take the value of n to be 4.
		int n = 4;
		func(1, n);	
	}

	private static void func(int i, int n) {
		if (i > n) {
			return;
		}

		System.out.println("Shashank Garg");
		i = i + 1;
		func(i, n);
	}
	
}
