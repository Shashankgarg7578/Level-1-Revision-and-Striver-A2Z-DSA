package _02_Recursion._1_Basic;

public class _12_tower_of_hanoi {
	public static void main(String[] args) {
		int n = 3; // total number of disks
		char ch1 = 'A';
		char ch2 = 'B';
		char ch3 = 'C';

		toh(n, ch1, ch2, ch3);
	}

	private static void toh(int n, char ch1, char ch2, char ch3) {

		if (n == 0) {
			return;
		}

		toh(n - 1, ch1, ch3, ch2);
		System.out.println(n + " disk -> " + "move [" + ch1 + "->" + ch2 + "]");
		toh(n - 1, ch3, ch2, ch1);
	}
}
