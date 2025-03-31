package _07_Stack_and_Queue._01_Learning;

import java.util.Stack;

public class _06_Implement_Queue_using_Stack {
	public static void main(String args[]) {
		MyQueue01 q = new MyQueue01();
		q.push(3);
		q.push(4);
		System.out.println("The element poped is " + q.pop());
		q.push(5);
		System.out.println("The top element is " + q.peek());
		System.out.println("The size of the queue is " + q.size());

	}
}

//pop efficient
class MyQueue01 {

	Stack<Integer> s1, s2;

	public MyQueue01() {
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}

	public void push(int x) {
		while (!s1.isEmpty()) {
			s2.add(s1.pop());
		}

		s1.add(x);

		while (!s2.isEmpty()) {
			s1.add(s2.pop());
		}
	}

	public int pop() {
		if (s1.isEmpty()) {
			return -1;
		}

		int val = s1.pop();
		return val;

	}

	public int peek() {
		if (s1.isEmpty()) {
			return -1;
		}
		return s1.peek();
	}

	public boolean empty() {
		return s1.isEmpty();
	}

	public int size() {
		return s1.size();
	}

}

//push efficient
class MyQueue02 {

	Stack<Integer> s1, s2;

	public MyQueue02() {
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}

	public void push(int x) {
		s1.add(x);
	}

	public int pop() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.add(s1.pop());
			}
		}

		return s2.pop();
	}

	public int peek() {
		if (s2.isEmpty()) {
			while (!s1.isEmpty()) {
				s2.add(s1.pop());
			}
		}

		return s2.peek();
	}

	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}

	public int size() {
		return s1.size() + s2.size();
	}

}
