package _06_LinkedList._03_Medium_Problems_Of_1d_LL;

import java.util.HashMap;
import java.util.Map;

class Node07 {
	int data;
	Node07 next;

	Node07(int data) {
		this.data = data;
		this.next = null;
	}

	Node07(int data, Node07 node) {
		this.data = data;
		this.next = node;
	}
}

public class _07_Detect_a_loop_in_LL {
	public static void main(String[] args) {
		// Create a sample linked list
		// with a loop for testing
		Node07 head = new Node07(1);
		Node07 second = new Node07(2);
		Node07 third = new Node07(3);
		Node07 fourth = new Node07(4);
		Node07 fifth = new Node07(5);

		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		// Create a loop
		fifth.next = third;

		// Check if there is a loop in the linked list
		if (detectLoop(head)) {
			System.out.println("Loop detected in the linked list.");
		} else {
			System.out.println("No loop detected in the linked list.");
		}

		System.out.println();

		// Check if there is a loop in the linked list
		if (detectLoopByTortoiseAndHare(head)) {
			System.out.println("Loop detected in the linked list.");
		} else {
			System.out.println("No loop detected in the linked list.");
		}

		// No need to explicitly free memory
		// in Java; the garbage collector handles it
	}

	// Brute Force with Map
	private static boolean detectLoop(Node07 head) {
		Node07 temp = head;

		Map<Node07, Integer> map = new HashMap<Node07, Integer>();

		while (temp != null) {

			if (map.containsKey(temp)) {
				return true;
			}

			map.put(temp, 1);
			temp = temp.next;
		}

		return false;
	}

	// Tortoise and Hare Algorithm
	private static boolean detectLoopByTortoiseAndHare(Node07 head) {
		Node07 slow = head;
		Node07 fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

}
