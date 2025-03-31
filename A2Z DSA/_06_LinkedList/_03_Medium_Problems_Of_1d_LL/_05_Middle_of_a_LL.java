package _06_LinkedList._03_Medium_Problems_Of_1d_LL;

class Node05 {
	int data;
	Node05 next;

	Node05(int data) {
		this.data = data;
		this.next = null;
	}

	Node05(int data, Node05 node) {
		this.data = data;
		this.next = node;
	}
}

public class _05_Middle_of_a_LL {
	public static void main(String[] args) {
		// Creating a sample linked list:
		Node05 head = new Node05(1);
		head.next = new Node05(2);
		head.next.next = new Node05(3);
		head.next.next.next = new Node05(4);
		head.next.next.next.next = new Node05(5);

		head.next.next.next.next.next = new Node05(6);

		// Find the middle node
		Node05 middleNode = findMiddle(head);

		// Display the value of the middle node
		System.out.println("The middle node value is: " + middleNode.data);
		
		System.out.println("The middle node value is: " + findMiddleByTortoise(head).data);
				
	}

	// Time Complexity: O(N+N/2)
//	Space Complexity : O(1) 
	// Brute force by Maths
	private static Node05 findMiddle(Node05 head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node05 temp = head;
		int count = 0;

		while (temp != null) {
			count++;
			temp = temp.next;
		}

		int mid = (count / 2) + 1;
		temp = head;

		while (temp != null) {
			mid = mid - 1;
			if (mid == 0) {
				break;
			}
			temp = temp.next;
		}

		return temp;
	}

	// TortoiseHare Method (Slow and fast pointer)
	private static Node05 findMiddleByTortoise(Node05 head) {

		Node05 slow = head;
		Node05 fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

}
