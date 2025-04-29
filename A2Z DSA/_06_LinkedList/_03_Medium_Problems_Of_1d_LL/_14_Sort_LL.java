package _06_LinkedList._03_Medium_Problems_Of_1d_LL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node14 {
	int data;
	Node14 next;

	Node14(int data, Node14 next) {
		this.data = data;
		this.next = next;
	}

	Node14(int data) {
		this.data = data;
		this.next = null;
	}
}

public class _14_Sort_LL {
	// Function to print the linked list
	public static void printLinkedList(Node14 head) {
		Node14 temp = head;
		while (temp != null) {
			// Print the data of the current node
			System.out.print(temp.data + " ");
			// Move to the next node
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Linked List: 3 2 5 4 1
		Node14 head = new Node14(3);
		head.next = new Node14(2);
		head.next.next = new Node14(5);
		head.next.next.next = new Node14(4);
		head.next.next.next.next = new Node14(1);

		System.out.print("Original Linked List: ");
		printLinkedList(head);

		// Sort the linked list
		head = sortLL(head);

		System.out.print("Sorted Linked List: ");
		printLinkedList(head);

		// Sort the linked list
		head = sortLLByMergeSort(head);

		System.out.print("Sorted Linked List: ");
		printLinkedList(head);
	}

	// Brute Force
	private static Node14 sortLL(Node14 head) {
		List<Integer> arr = new ArrayList<>();

		Node14 temp = head;

		while (temp != null) {
			arr.add(temp.data);
			temp = temp.next;
		}

		Collections.sort(arr);

		// Reassign sorted values to
		// the linked list nodes
		temp = head;
		for (int i = 0; i < arr.size(); i++) {
			// Update the node's data
			// with the sorted values
			temp.data = arr.get(i);
			// Move to the next node
			temp = temp.next;
		}

		// Return the head of the
		// sorted linked list
		return head;
	}

	// Optimal By Merge Sort
	private static Node14 sortLLByMergeSort(Node14 head) {
		if (head == null || head.next == null) {
			return head;
		}

		// Find the middle of the list
		// using the findMiddle function
		Node14 middle = findMiddle(head);

		// Divide the list into two halves
		Node14 right = middle.next;
		middle.next = null;

		Node14 left = head;

		// Recursively sort the left and right halves
		left = sortLLByMergeSort(left);
		right = sortLLByMergeSort(right);

		// Merge the sorted halves using the
		// mergeTwoSortedLinkedLists function
		return mergeTwoSortedLinkedLists(left, right);
	}

	private static Node14 mergeTwoSortedLinkedLists(Node14 list1, Node14 list2) {
		// Create a dummy node to serve
		// as the head of the merged list
		Node14 dummyNode = new Node14(-1);
		Node14 temp = dummyNode;

		while (list1 != null && list2 != null) {
			// Compare elements of both lists and
			// link the smaller node to the merged list
			if (list1.data <= list2.data) {
				temp.next = list1;
				list1 = list1.next;
			} else {
				temp.next = list2;
				list2 = list2.next;
			}
			// Move the temporary pointer
			// to the next node
			temp = temp.next;
		}

		// If any list still has remaining
		// elements, append them to the merged list
		if (list1 != null) {
			temp.next = list1;
		} else {
			temp.next = list2;
		}

		return dummyNode.next;
	}

	private static Node14 findMiddle(Node14 head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node14 slow = head;
		Node14 fast = head.next;

		// Move the fast pointer twice
		// as fast as the slow pointer
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

}
