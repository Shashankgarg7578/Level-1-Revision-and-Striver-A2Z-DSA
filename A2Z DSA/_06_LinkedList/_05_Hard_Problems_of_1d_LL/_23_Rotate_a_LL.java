package _06_LinkedList._05_Hard_Problems_of_1d_LL;

class Node23 {
	int data;
	Node23 next;

	Node23(int data) {
		this.data = data;
		this.next = null;
	}

	Node23(int data, Node23 node) {
		this.data = data;
		this.next = node;
	}
}

public class _23_Rotate_a_LL {
	// utility function to print list
	static void printList(Node23 head) {
		while (head.next != null) {
			System.out.print(head.data + "->");
			head = head.next;
		}
		System.out.println(head.data);

	}

	static Node23 insertNode(Node23 head, int val) {
		Node23 newNode = new Node23(val);
		if (head == null) {
			head = newNode;
			return head;
		}
		Node23 temp = head;
		while (temp.next != null)
			temp = temp.next;

		temp.next = newNode;
		return head;
	}

	public static void main(String args[]) {
		Node23 head = null;
		// inserting Node23
		head = insertNode(head, 1);
		head = insertNode(head, 2);
		head = insertNode(head, 3);
		head = insertNode(head, 4);
		head = insertNode(head, 5);

		System.out.println("Original list: ");
		printList(head);

		int k = 2;
		Node23 newHead = rotateRight(head, k); // calling function for rotating right of the nodes by k times

		System.out.println("After " + k + " iterations: ");
		printList(newHead); // list after rotating nodes

	}

	private static Node23 rotateRight(Node23 head, int k) {

		if (head == null || k == 0) {
			return head;
		}

		Node23 tail = head;

		int len = 1;

		while (tail.next != null) {
			tail = tail.next;
			len = len + 1;
		}

		if (k % len == 0) {
			return head;
		}

		k = k % len;

		tail.next = head;

		Node23 newLastNode = findNthNode(head, len - k);

		head = newLastNode.next;
		newLastNode.next = null;
		
		return head;
	}

	private static Node23 findNthNode(Node23 temp, int k) {
		int cnt = 1;

		while (temp != null) {
			if (cnt == k) {
				return temp;
			}
			cnt++;
			temp = temp.next;
		}

		return temp;
	}
}
