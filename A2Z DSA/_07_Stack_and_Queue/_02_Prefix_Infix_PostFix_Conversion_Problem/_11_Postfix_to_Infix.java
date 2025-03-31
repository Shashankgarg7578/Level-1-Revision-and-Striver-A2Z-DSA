package _07_Stack_and_Queue._02_Prefix_Infix_PostFix_Conversion_Problem;

import java.util.Stack;

public class _11_Postfix_to_Infix {

//	case 1 : if letter or digit add in stack
//	case 2 : if it is operator then pop last 2 elements from stack and then
//	         (lastSecondElement + currentOperator + lastElement )

	public static void main(String[] args) {
		String s = ("ab*c+");
		System.out.println("Postfix expression: " + s);
		System.out.print("infix expression: ");
		System.out.print(postfixToInfix(s));
	}

	// TC :- O(N) + O(N)
	// SC :- O(N)
	static String postfixToInfix(String postfix) {

		Stack<String> st = new Stack<String>();

		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);

			if (Character.isLetterOrDigit(c)) {
				st.push(c + "");
			} else {

				String t1 = st.pop();
				String t2 = st.pop();
				st.push("(" + t2 + c + t1 + ")");
			}
		}

		return st.peek();
	}

}
