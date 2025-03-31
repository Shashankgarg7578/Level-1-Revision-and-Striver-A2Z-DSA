package _07_Stack_and_Queue._02_Prefix_Infix_PostFix_Conversion_Problem;

import java.util.Stack;

// 1. Reverse the give infix expression and change ( to ) and ) to (.
// 2. Infix to Postfix under some controller condition
// 3. Reverse the answer

//when we are doing operations in this if we don't have ^ then just add in to stack

public class _10_Infix_to_Prefix_Conversion {

	public static void main(String[] args) {
		String s = ("(p+q)*(c-d)");
//		String s = ("(A+B)*C-D+F");
		System.out.println("Infix expression: " + s);
		System.out.print("Prefix expression: ");
		System.out.print(infixToPrefix(s.toCharArray()));
	}

	static String infixToPrefix(char[] infix) {
		int l = infix.length;

		// reverse infix
		String infixRev = reverseString(infix, 0, l - 1);

		infix = infixRev.toCharArray();

		// Replace ( with ) and vice versa
		for (int i = 0; i < l; i++) {
			if (infix[i] == '(') {
				infix[i] = ')';
				continue;
			}
			if (infix[i] == ')') {
				infix[i] = '(';
			}
		}

		String infixToPostfix = infixToPostfix(new String(infix));

		String prefix = reverseString(infixToPostfix.toCharArray(), 0, infixToPostfix.length()-1);
		
		
		return prefix;
	}

	// Reverse the letters of the word
	static String reverseString(char str[], int start, int end) {

		// Temporary variable to store character
		char temp;
		while (start < end) {
			// Swapping the first and last character
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
		return String.valueOf(str);
	}

	static String infixToPostfix(String exp) {

		Stack<Character> st = new Stack<Character>();
		String ans = "";

		for (int i = 0; i < exp.length(); i++) {

			char c = exp.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				ans += c;
			} else if (c == '(') {
				st.push(c);
			} else if (c == ')') {
				while (!st.isEmpty() && st.peek() != '(') {
					ans += st.pop();
				}
				st.pop(); // pop '(' in the end
			} else {
				
				if(!st.isEmpty()) {
					while((c == '^' && Prev(c) <= Prev(st.peek()) )    
							||  (Prev(c) < Prev(st.peek()))) {
						ans += st.pop();
					}
				}
				
				st.push(c);
			}

		}

		while (!st.isEmpty()) {
			ans += st.pop();
		}

		return ans;
	}

	static int Prev(char ch) {
		switch (ch) {
		case '-':
			return 1;
		case '+':
			return 1;

		case '/':
			return 2;
		case '*':
			return 2;

		case '^':
			return 3;

		}
		return 0;
	}

}
