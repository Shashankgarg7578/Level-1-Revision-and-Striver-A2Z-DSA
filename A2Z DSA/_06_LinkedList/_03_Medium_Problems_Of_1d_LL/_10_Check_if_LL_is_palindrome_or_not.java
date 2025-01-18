package _06_LinkedList._03_Medium_Problems_Of_1d_LL;

import java.util.Stack;

class Node10 {
	int data;
	Node10 next;

	Node10(int data) {
		this.data = data;
		this.next = null;
	}

	Node10(int data, Node10 node) {
		this.data = data;
		this.next = node;
	}
}

public class _10_Check_if_LL_is_palindrome_or_not {
	public static void printLinkedList(Node10 head) {
		Node10 temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Create a linked list with
		// values 1, 5, 2, 5, and 1 (15251, a palindrome)
		Node10 head = new Node10(1);
		head.next = new Node10(5);
		head.next.next = new Node10(2);
		head.next.next.next = new Node10(5);
		head.next.next.next.next = new Node10(1);

		// Print the original linked list
		System.out.print("Original Linked List: ");
		printLinkedList(head);

		// Check if the linked list is a palindrome
		if (isPalindromeByStack(head)) {
			System.out.println("The linked list is a palindrome.");
		} else {
			System.out.println("The linked list is not a palindrome.");
		}

		// Check if the linked list is a palindrome
		if (isPalindromeByRecursion(head)) {
			System.out.println("The linked list is a palindrome.");
		} else {
			System.out.println("The linked list is not a palindrome.");
		}
	}

	// Brute Force
	//Time Complexity: O(2 * N) 
	//Space Complexity: O(N) 
	private static boolean isPalindromeByStack(Node10 head) {
		Stack<Integer> st = new Stack<Integer>();

		Node10 temp = head;

		while (temp != null) {
			st.push(temp.data);
			temp = temp.next;
		}

		temp = head;
		while (temp != null) {
			if (st.peek() != temp.data) {
				return false;
			}
			st.pop();
			temp = temp.next;
		}

		return true;
	}

	//Time Complexity: O (2* N)
	//Space Complexity: O(1)
	public static boolean isPalindromeByRecursion(Node10 head) {
		// Check if the linked list is
		// empty or has only one node
		if (head == null || head.next == null) {
			// It's a palindrome by definition
			return true;
		}

		// Initialize two pointers, slow and fast,
		// to find the middle of the linked list
		Node10 slow = head;
		Node10 fast = head;

		// Traverse the linked list to find the
		// middle using slow and fast pointers
		while (fast.next != null && fast.next.next != null) {
			// Move slow pointer one step at a time
			slow = slow.next;

			// Move fast pointer two steps at a time
			fast = fast.next.next;
		}

		// Reverse the second half of the
		// linked list starting from the middle
		Node10 newHead = reverseLinkedList(slow.next);

		// Pointer to the first half
		Node10 first = head;

		// Pointer to the reversed second half
		Node10 second = newHead;
		while (second != null) {
			// Compare data values of
			// nodes from both halves

			// If values do not match, the
			// list is not a palindrome
			if (first.data != second.data) {

				// Reverse the second half back
				// to its original state
				reverseLinkedList(newHead);

				// Not a palindrome
				return false;
			}

			// Move the first pointer
			first = first.next;

			// Move the second pointer
			second = second.next;
		}

		// Reverse the second half back
		// to its original state
		reverseLinkedList(newHead);

		// The linked list is a palindrome
		return true;
	}

	// Function to reverse a linked list
	// using the recursive approach
	public static Node10 reverseLinkedList(Node10 head) {
		// Check if the list is empty or has only one node
		if (head == null || head.next == null) {

			// No change is needed;
			// return the current head
			return head;
		}

		// Recursive step: Reverse the remaining
		// part of the list and get the new head
		Node10 newHead = reverseLinkedList(head.next);

		// Store the next node in 'front'
		// to reverse the link
		Node10 front = head.next;

		// Update the 'next' pointer of 'front' to
		// point to the current head, effectively
		// reversing the link direction
		front.next = head;

		// Set the 'next' pointer of the
		// current head to 'null' to
		// break the original link
		head.next = null;

		// Return the new head obtained
		// from the recursion
		return newHead;
	}

}
