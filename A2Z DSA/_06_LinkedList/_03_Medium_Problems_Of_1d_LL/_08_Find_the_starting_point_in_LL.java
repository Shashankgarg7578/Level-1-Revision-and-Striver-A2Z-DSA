package _06_LinkedList._03_Medium_Problems_Of_1d_LL;

import java.util.HashMap;
import java.util.Map;

class Node08 {
	int data;
	Node08 next;

	Node08(int data) {
		this.data = data;
		this.next = null;
	}

	Node08(int data, Node08 node) {
		this.data = data;
		this.next = node;
	}
}

public class _08_Find_the_starting_point_in_LL {
	public static void main(String[] args) {
		// Create a sample linked list with a loop
		Node08 node1 = new Node08(1);
		Node08 node2 = new Node08(2);
		node1.next = node2;
		Node08 node3 = new Node08(3);
		node2.next = node3;
		Node08 node4 = new Node08(4);
		node3.next = node4;
		Node08 node5 = new Node08(5);
		node4.next = node5;

		// Make a loop from node5 to node2
		node5.next = node2;

		// Set the head of the linked list
		Node08 head = node1;

		// Detect the loop in the linked list
		Node08 loopStartNode = detectLoopStartingPoint(head);

		if (loopStartNode != null) {
			System.out.println("Loop detected. Starting node of the loop is: " + loopStartNode.data);
		} else {
			System.out.println("No loop detected in the linked list.");
		}

		// Detect the loop in the linked list
		Node08 loopStartNodeOptimal = detectLoopStartingPointByTortoiseAndHare(head);

		if (loopStartNodeOptimal != null) {
			System.out.println("Loop detected. Starting node of the loop is: " + loopStartNodeOptimal.data);
		} else {
			System.out.println("No loop detected in the linked list.");
		}

	}

	// Brute Force
	private static Node08 detectLoopStartingPoint(Node08 head) {

		Node08 temp = head;

		Map<Node08, Integer> map = new HashMap<Node08, Integer>();

		while (temp != null) {

			if (map.containsKey(temp)) {
				return temp;
			}

			map.put(temp, 1);
			temp = temp.next;
		}

		return null;
	}

	// slow fast pointer by Tortoise and Hare Algorithm
	private static Node08 detectLoopStartingPointByTortoiseAndHare(Node08 head) {

		Node08 slow = head;
		Node08 fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast) {
				slow = head;

				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}

		return null;
	}
}
