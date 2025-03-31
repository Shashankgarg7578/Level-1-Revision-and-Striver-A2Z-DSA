package _06_LinkedList._03_Medium_Problems_Of_1d_LL;

import java.util.ArrayList;

class Node11 {
	int data;
	Node11 next;

	Node11(int data) {
		this.data = data;
		this.next = null;
	}

	Node11(int data, Node11 node) {
		this.data = data;
		this.next = node;
	}
}

public class _11_Segrregate_odd_and_even_nodes_in_LL {

	public static void printLinkedList(Node11 head) {
		Node11 temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Create a linked list with
		// values 1, 5, 2, 5, and 1 (15251, a palindrome)
		Node11 head = new Node11(1);
		head.next = new Node11(2);
		head.next.next = new Node11(3);
		head.next.next.next = new Node11(4);
		head.next.next.next.next = new Node11(5);

		// Print the original linked list
		System.out.print("Original Linked List: ");
		printLinkedList(head);

		Node11 newHead = SegregatetoOddEven(head);
		System.out.print("Segregate to Odd even: ");
		printLinkedList(newHead);

		Node11 newHead2 = SegregatetoOddEvenByPointers(head);
		System.out.print("Segregate to Odd even: ");
		printLinkedList(newHead2);

	}

	// Brute force
	private static Node11 SegregatetoOddEven(Node11 head) {

		if (head == null || head.next == null) {
			return head;
		}

		ArrayList<Integer> list = new ArrayList<Integer>();

		Node11 temp = head;
		// add odd elements
		while (temp != null && temp.next != null) {
			list.add(temp.data);
			temp = temp.next.next;
		}
		if (temp != null) {
			list.add(temp.data);
		}
		
		
		temp = head.next;
		// add even elements
		while (temp != null && temp.next != null) {
			list.add(temp.data);
			temp = temp.next.next;
		}
		if (temp != null) {
			list.add(temp.data);
		}

		// again fill values from List to LL
		int i = 0;
		temp = head;
		while (temp != null) {
			temp.data = list.get(i);
			i++;
			temp = temp.next;
		}

		return head;
	}

	// Optimal
	private static Node11 SegregatetoOddEvenByPointers(Node11 head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node11 odd = head;
		Node11 even = head.next;
		Node11 evenHead = head.next;

		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			even.next = even.next.next;

			odd = odd.next;
			even = even.next;
		}

		odd.next = evenHead;

		return head;
	}

}
