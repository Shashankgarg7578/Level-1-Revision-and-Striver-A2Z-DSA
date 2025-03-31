package _07_Stack_and_Queue._01_Learning;

public class _01_Implement_Stack_using_Arrays {
	public static void main(String[] args) {

		stack01 s = new stack01();
		s.push(6);
		s.push(3);
		s.push(7);
		System.out.println("Top of the stack before deleting any element " + s.top());
		System.out.println("Size of the stack before deleting any element " + s.size());
		System.out.println("The element deleted is " + s.pop());
		System.out.println("Size of the stack after deleting an element " + s.size());
		System.out.println("Top of the stack after deleting an element " + s.top());
	}
}

class stack01 {

	int size = 1000;

	int[] arr = new int[size];

	int top = -1;

	void push(int x) {
		if (top >= size) {
			System.out.println("Stack limit is full");
		}
		top++;
		arr[top] = x;
	}

	int pop() {
		if (top == -1) {
			System.out.println("Stack is Empty");
			return -1;
		}
		int x = arr[top];
		top--;
		return x;
	}

	int top() {
		if (top == -1) {
			System.out.println("Stack is Empty");
			return -1;
		}
		return arr[top];
	}

	int size() {
		return top + 1;
	}

}