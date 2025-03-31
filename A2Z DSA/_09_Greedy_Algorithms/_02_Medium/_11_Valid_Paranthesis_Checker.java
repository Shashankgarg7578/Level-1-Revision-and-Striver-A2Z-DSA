package _09_Greedy_Algorithms._02_Medium;

public class _11_Valid_Paranthesis_Checker {

	public static void main(String[] args) {
		String s1 = "()*)*()";
		System.out.println(checkValidString(s1));

		String s2 = "(**(";
		System.out.println(checkValidString(s2));

	}

	// first try with recursion, DP or Space Optimization
//its a greedy solution so if dont understand try out or watch video after 15:13

	// TC: O(N)
	// SC : O(1)
	static public boolean checkValidString(String s) {

		int min = 0, max = 0;

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch == '(') {
				min = min + 1;
				max = max + 1;
			} else if (ch == ')') {
				min = min - 1;
				max = max - 1;
			} else {
				min = min - 1;
				max = max + 1;
			}

			if (min < 0) {
				min = 0;
			}

			if (max < 0) {
				return false;
			}
		}

		return (min == 0);
	}
}
