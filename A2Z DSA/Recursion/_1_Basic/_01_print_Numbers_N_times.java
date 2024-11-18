package Recursion._1_Basic;

public class _01_print_Numbers_N_times {

	public static void main(String[] args) {
		print();
	}

	static int cnt = 0;
	private static void print() {
		
		if(cnt == 3) {
			return;
		}
		cnt++;
		System.out.println(cnt);
		print();
	}

}
