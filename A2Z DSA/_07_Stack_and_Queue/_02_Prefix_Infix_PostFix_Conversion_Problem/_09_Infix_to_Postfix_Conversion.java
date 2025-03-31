package _07_Stack_and_Queue._02_Prefix_Infix_PostFix_Conversion_Problem;

import java.util.Stack;

//Operator :- 
//   ^    = 3
//   *,/  = 2
//   +,-  = 1
//
//Operand :- 
//   A - Z
//   a - z
//   0 - 9
//
//   prefix          Infix           postfix 
//  *+pq-mn        (p+q)*(m-n)        pq+mn-*

//Infix to postfix :-
//(A.) Iterate String and perform below operations
//   case:1 char is letter or digit :=> add in ans string 
//   case:2 char is '(' :=> add in stack
//   case:3 char is ')' :=> iterate stack and pop till '(' and add popped char in ans, after loop pop '('
//   case:4 char is operator : 
//             (a.) iterate stack and pop till current char frequency is "lesser or equal" to stack peek and
//                  add popped char in ans, 
//             (b.) after loop add current char in stack
//(B.) after iteration if stack is still not empty then pop from stack and add in ans.

public class _09_Infix_to_Postfix_Conversion {
	// Driver method
	public static void main(String[] args) {
		String exp1 = "(p+q)*(m-n)";
		System.out.println("Infix expression: " + exp1);
		System.out.println("Postfix expression: " + infixToPostfix(exp1));

		System.out.println();

		String exp2 = "a+b*(c^d-e)";
		System.out.println("Infix expression: " + exp2);
		System.out.println("Postfix expression: " + infixToPostfix(exp2));
	}

	// TC: O(N) + O(N)
	// TC: O(N) + O(N)
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
				while (!st.isEmpty() && Prev(c) <= Prev(st.peek())) {
					ans += st.pop();
				}
				st.add(c);
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
		return -1;
	}

}
