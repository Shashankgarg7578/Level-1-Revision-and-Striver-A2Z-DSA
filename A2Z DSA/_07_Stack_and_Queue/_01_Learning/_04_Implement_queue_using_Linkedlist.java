package _07_Stack_and_Queue._01_Learning;

public class _04_Implement_queue_using_Linkedlist {
	public static void main(String args[]) {
		Queue04 Q = new Queue04();
		Q.push(10);
		Q.push(20);
		Q.push(30);
		Q.push(40);
		Q.push(50);
		Q.pop();
		System.out.println("The size of the Queue is " + Q.size);
		System.out.println("The Peek element of the Queue is " + Q.peek());
	}
}

class Node04 {

	int data;
	Node04 next;

	public Node04(int data) {
		this.data = data;
		this.next = null;
	}

	public Node04(int data, Node04 next) {
		this.data = data;
		this.next = next;
	}
}

class Queue04 {

	Node04 front = null;
	Node04 rear = null;
	int size = 0;

	boolean isEmpty() {
		return front == null;
	}

	int peek() {
		if (isEmpty()) {
			return -1;
		} else {
			return front.data;
		}
	}

	void push(int val) {

		Node04 temp = new Node04(val);
		if (front == null) {
			front = rear = temp;
		} else {
			rear.next = temp;
			rear = temp;
		}
		size++;

	}

	int pop() {

		if (front == null) {
			return -1;
		}

		Node04 temp = front;

		front = front.next;

		temp.next = null;
		size--;
		return temp.data;
	}

}
