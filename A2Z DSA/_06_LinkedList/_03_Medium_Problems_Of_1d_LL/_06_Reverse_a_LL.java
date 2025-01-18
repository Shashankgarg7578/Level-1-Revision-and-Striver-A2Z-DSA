package _06_LinkedList._03_Medium_Problems_Of_1d_LL;

import java.util.Stack;

class Node06 {
	int data;
	Node06 next;

	Node06(int data) {
		this.data = data;
		this.next = null;
	}

	Node06(int data, Node06 node) {
		this.data = data;
		this.next = node;
	}
}

//reverse a singly LL
public class _06_Reverse_a_LL {

	public static void printLinkedList(Node06 head) {
		Node06 temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Create a linked list with values 1, 3, 2, and 4
		Node06 head = new Node06(1);
		head.next = new Node06(3);
		head.next.next = new Node06(2);
		head.next.next.next = new Node06(4);

		// Print the original linked list
		System.out.print("Original Linked List: ");
		printLinkedList(head);

		// Reverse the linked list
		head = reverseLinkedListByStack(head);

		// Print the reversed linked list
		System.out.print("Reversed Linked List: ");
		printLinkedList(head);

		// Reverse the linked list
		head = reverseLinkedListByPointers(head);

		// Print the reversed linked list
		System.out.print("Reversed Linked List: ");
		printLinkedList(head);

		// Reverse the linked list
		head = reverseLinkedListByRecursion(head);

		// Print the reversed linked list
		System.out.print("Reversed Linked List: ");
		printLinkedList(head);
		
	}

	// Brute Force by Stack
	private static Node06 reverseLinkedListByStack(Node06 head) {

		Stack<Integer> st = new Stack<Integer>();
		Node06 temp = head;

		while (temp != null) {
			st.push(temp.data);
			temp = temp.next;
		}

		temp = head;
		while (temp != null) {
			temp.data = st.pop();
			temp = temp.next;
		}

		return head;
	}

	// Brute Force by Pointers
	private static Node06 reverseLinkedListByPointers(Node06 head) {
		Node06 temp = head;
		Node06 prev = null;

		while (temp != null) {
			Node06 front = temp.next;
			temp.next = prev;
			prev = temp;
			temp = front;
		}

		return prev;
	}

	// Brute Force by Recursion
	private static Node06 reverseLinkedListByRecursion(Node06 head) {
		if (head == null || head.next == null) {
			return head;
		}

		//dry run for 2 nodes only
		Node06 newHead = reverseLinkedListByRecursion(head.next);
		Node06 front = head.next;

		front.next = head;
		head.next = null;
		
		return newHead;
	}

}
