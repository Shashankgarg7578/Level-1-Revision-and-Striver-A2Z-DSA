package _02_Recursion._1_Basic;

public class _08_string_palindrome_or_not {
	public static void main(String[] args) {
		// Example string.
		String s = "madam";
		System.out.println(palindrome(0, s));
	}

//	Time Complexity: O(N) 
//	Space Complexity: O(1)
	private static boolean palindrome(int i, String s) {

		if (i >= s.length() / 2) {
			return true;
		}

		if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
			return false;
		}

		return palindrome(i + 1, s);
	}
}
