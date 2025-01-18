package _06_LinkedList._02_Learn_Doubly_LinkedList;

public class DoublyNode {
	int data;
	DoublyNode next;
	DoublyNode back;

	DoublyNode(int data) {
		this.data = data;
		this.next = null;
		this.back = null;
	}

	DoublyNode(int data, DoublyNode next, DoublyNode back) {
		this.data = data;
		this.next = next;
		this.back = back;
	}
}
