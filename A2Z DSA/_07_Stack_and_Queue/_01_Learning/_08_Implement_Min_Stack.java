package _07_Stack_and_Queue._01_Learning;

import java.util.Stack;

public class _08_Implement_Min_Stack {
	public static void main(String[] args) {
		MinStack02 ms = new MinStack02();
		ms.push(10);
		ms.push(30);
		System.out.println(ms.getMin());
		ms.push(9);
		System.out.println(ms.getMin());
		ms.push(6);
		System.out.println(ms.getMin());
		ms.pop();
		ms.push(60);
		System.out.println(ms.getMin());
	}
}

class Pair08 {
	int x; // array current value
	int y; // minimum value among all till now

	Pair08(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

//here we are Storing a Pair so it will take more Space
//Time Complexity: O(1)
//Space Complexity: O(2N)
class MinStack01 {

	Stack<Pair08> st;

	public MinStack01() {
		st = new Stack<Pair08>();
	}

	public void push(int x) {
		int min;

		if (st.isEmpty()) {
			min = x;
		} else {
			min = Math.min(x, st.peek().y);
		}
		st.push(new Pair08(x, min));
	}

	// remove last pair
	public void pop() {
		st.pop();
	}

	public int top() {
		return st.peek().x;
	}

	public int getMin() {
		return st.peek().y;
	}
}

//in this we don't store pair instead we will use simple Math's
//Time Complexity: O(1)
//Space Complexity: O(N)
class MinStack02 {

	Stack<Long> st;

	Long mini;

	public MinStack02() {
		st = new Stack<Long>();
		mini = Long.MAX_VALUE;
	}

	public void push(int x) {
		Long val = Long.valueOf(x);

		if (st.isEmpty()) {
			mini = val;
			st.add(val);
		} else {
			if (val < mini) {
				st.push(2 * val - mini); // this formula we have to remember
				mini = val;
			} else {
				st.add(val);
			}
		}
	}

	public void pop() {
		if (st.isEmpty()) {
			return;
		} else {
			Long val = st.pop();
			if (val < mini) {
				mini = 2 * mini - val; // this formula we have to remember
			}
		}
	}

	public int top() {
		if (st.isEmpty()) {
			return -1;
		} else {
			Long val = st.peek();
			if (val < mini) {
				return mini.intValue();
			}

			return val.intValue();
		}
	}

	public int getMin() {
		return mini.intValue();
	}

}
