package _07_Stack_and_Queue._01_Learning;

import java.util.LinkedList;
import java.util.Queue;

public class _05_Implement_Stack_using_Queue {
	public static void main(String[] args) {
		stack05 s = new stack05();
		s.push(3);
		s.push(2);
		s.push(4);
		s.push(1);
		System.out.println("Top of the stack: " + s.top());
		System.out.println("Size of the stack before removing element: " + s.size());
		System.out.println("The deleted element is: " + s.pop());
		System.out.println("Top of the stack after removing element: " + s.top());
		System.out.println("Size of the stack after removing element: " + s.size());
	}
}

class stack05 {
	Queue<Integer> q = new LinkedList<Integer>();

	void push(int x) {

		q.add(x);

		// remove till before last which we added just now
		for (int i = 0; i < q.size() - 1; i++) {
			q.add(q.remove());
		}
	}

	int pop() {
		return q.remove();
	}

	int top() {
		return q.peek();
	}

	int size() {
		return q.size();
	}

}
