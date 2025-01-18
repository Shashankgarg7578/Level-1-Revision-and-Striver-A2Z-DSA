package _06_LinkedList._03_Medium_Problems_Of_1d_LL;

import java.util.HashMap;
import java.util.Map;

class Node09 {
	int data;
	Node09 next;

	Node09(int data) {
		this.data = data;
		this.next = null;
	}

	Node09(int data, Node09 node) {
		this.data = data;
		this.next = node;
	}
}

public class _09_Length_of_Loop_in_LL {
	public static void main(String[] args) {
		// Create a linked list with a loop
		Node09 head = new Node09(1);
		Node09 second = new Node09(2);
		Node09 third = new Node09(3);
		Node09 fourth = new Node09(4);
		Node09 fifth = new Node09(5);

		// Create a loop from fifth to second
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;

		// This creates a loop
		fifth.next = second;

		int loopLength = lengthOfLoop(head);

		if (loopLength > 0) {
			System.out.println("Length of the loop: " + loopLength);
		} else {
			System.out.println("No loop found in the linked list.");
		}

		int loopLengthByTH = lengthOfLoopByTortoiseAndHare(head);

		if (loopLengthByTH > 0) {
			System.out.println("Length of the loop: " + loopLengthByTH);
		} else {
			System.out.println("No loop found in the linked list.");
		}

	}

	// Brute Force with Map
	private static int lengthOfLoop(Node09 head) {
		Node09 temp = head;

		Map<Node09, Integer> map = new HashMap<Node09, Integer>();

		int timer = 0;

		while (temp != null) {

			if (map.containsKey(temp)) {

				int loopLength = timer - map.get(temp);

				return loopLength;
			}

			map.put(temp, timer);
			temp = temp.next;
			timer++;
		}

		return 0;
	}

	// Brute Force with Map
	private static int lengthOfLoopByTortoiseAndHare(Node09 head) {
		Node09 slow = head;
		Node09 fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return findLength(slow, fast);
			}
		}

		return 0;
	}

	private static int findLength(Node09 slow, Node09 fast) {
		int cnt = 1;
		fast = fast.next;

		while (slow != fast) {
			cnt++;
			fast = fast.next;
		}

		return cnt;
	}

}
