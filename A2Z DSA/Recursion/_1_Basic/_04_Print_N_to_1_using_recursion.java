package Recursion._1_Basic;

public class _04_Print_N_to_1_using_recursion {
	public static void main(String[] args) {
		   // Here, let’s take the value of n to be 4.
	       int n = 4;
	       func(n,n);
	}

	private static void func(int i, int n) {
		if(i <= 0) {
			return;
		}
		
		System.out.println(i);
		i--;
		func(i, n);
	}
}
