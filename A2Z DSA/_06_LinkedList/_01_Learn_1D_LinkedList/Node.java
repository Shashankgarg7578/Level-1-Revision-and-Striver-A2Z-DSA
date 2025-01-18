package _06_LinkedList._01_Learn_1D_LinkedList;

public class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}

	Node(int data, Node node) {
		this.data = data;
		this.next = node;
	}
}
