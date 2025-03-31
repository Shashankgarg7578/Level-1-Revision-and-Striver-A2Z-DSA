package _07_Stack_and_Queue._01_Learning;

public class _03_Implement_stack_using_Linkedlist {

}

class Node03 {

	int data;
	Node03 next;

	public Node03(int data) {
		this.data = data;
		this.next = null;
	}

	public Node03(int data, Node03 next) {
		this.data = data;

		this.next = next;
	}
}

class stack03 {

	Node03 top;

	int size = 0;

	public void push(int x) {
		Node03 temp = new Node03(x);

		temp.next = top;

		top = temp;

		size = size + 1;
	}

	public int pop() {
		if (top == null) {
			return -1;
		}
		
		Node03 temp = top;
		top = top.next;
		temp.next = null;
		size = size - 1;
		return temp.data;
	}

	public int top() {
		return top.data;
	}

	public int size() {
		return size;
	}

}
