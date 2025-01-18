package _06_LinkedList._01_Learn_1D_LinkedList;

import java.util.Arrays;
import java.util.List;

public class _02_Insertion_and_deletion_in_LL {

	public static void main(String[] args) {
		// Sample array and value for insertion
		List<Integer> arr = Arrays.asList(12, 8, 5, 7);
		int val = 100;

		// Creating a linked list with initial elements from the array
		Node head = new Node(arr.get(0));
		head.next = new Node(arr.get(1));
		head.next.next = new Node(arr.get(2));
		head.next.next.next = new Node(arr.get(3));

		// All Insert Node Functions
		head = insertHead(head, val);
		System.out.print("After Insert value in Head :");
		printLL(head);

		System.out.println();
		System.out.println();
		head = insertTail(head, 23);
		System.out.print("After Insert value in Tail :");
		printLL(head);

		System.out.println();
		System.out.println();
		int idx = 3;
		head = insertNodeByIdx(head, 26, idx);
		System.out.print("After Insert value in Idx-" + 2 + " :");
		printLL(head);

		System.out.println();
		System.out.println();
		head = insertBeforeValue(head, 9, 7);
		System.out.print("After Insert befor value-" + 7 + " :");
		printLL(head);

		// All delete Node Functions
		System.out.println();
		System.out.println();
		head = deleteHead(head);
		System.out.print("After delete value in Head :");
		printLL(head);

		System.out.println();
		System.out.println();
		head = deleteTail(head);
		System.out.print("After delete value in Tail :");
		printLL(head);

		System.out.println();
		System.out.println();
		head = deleteNodeByIdx(head, 1);
		System.out.print("After delete value by Idx :");
		printLL(head);

		System.out.println();
		System.out.println();
		head = deleteNodeByVal(head, 8);
		System.out.print("After delete value by Val :");
		printLL(head);
	}

	private static Node insertHead(Node head, int val) {
		Node temp = new Node(val, head);
		return temp;
	}

	private static Node insertTail(Node head, int val) {
		if (head == null) {
			return new Node(val);
		}

		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		Node newNode = new Node(val);
		temp.next = newNode;

		return head;
	}

	private static Node insertNodeByIdx(Node head, int ele, int idx) {

		if (head == null) {
			if (idx == 1) {
				return new Node(ele);
			} else {
				return head;
			}
		}

		if (idx == 1) {
			insertHead(head, ele);
		}

		int cnt = 0;
		Node temp = head;

		while (temp != null) {
			cnt++;

			// stop on one index before
			if (cnt == idx - 1) {
				Node newNode = new Node(ele);
				newNode.next = temp.next;

				temp.next = newNode;
				return head;
			}

			temp = temp.next;
		}

		return head;
	}

	// insert element before Node value
	private static Node insertBeforeValue(Node head, int ele, int val) {

		if (head == null) {
			// because no such ele in the LL
			return null;
		}

		if (head.data == val) {
			insertHead(head, ele);
		}

		Node temp = head;

		while (temp.next != null) {

			// stop on one element before
			if (temp.next.data == val) {
				Node newNode = new Node(ele);
				newNode.next = temp.next;

				temp.next = newNode;
				return head;
			}

			temp = temp.next;
		}

		return head;
	}

	private static Node deleteHead(Node head) {
		if (head == null) {
			return head;
		}
		head = head.next;
		return head;
	}

	private static Node deleteTail(Node head) {
		if (head == null || head.next == null) {
			return null;
		}

		Node temp = head;

		while (temp.next.next != null) {
			temp = temp.next;
		}

		temp.next = null;

		return head;
	}

	private static Node deleteNodeByIdx(Node head, int k) {
		if (head == null) {
			return head;
		}

		if (k == 1) {
			deleteHead(head);
		}

		int cnt = 0;
		Node temp = head;
		Node prev = temp;

		while (temp != null) {
			cnt++;
			if (cnt == k) {
				prev.next = prev.next.next;
				break;
			}
			prev = temp;
			temp = temp.next;
		}

		return head;
	}

	// delete Node without head given
	public void deleteNode(Node node) {
		node.data = node.next.data;
		node.next = node.next.next;
	}

	private static Node deleteNodeByVal(Node head, int val) {
		if (head == null) {
			return head;
		}

		if (head.data == val) {
			head = deleteHead(head);
		}

		Node temp = head;
		Node prev = temp;

		while (temp != null) {
			if (temp.data == val) {
				prev.next = prev.next.next;
				break;
			}
			prev = temp;
			temp = temp.next;
		}

		return head;
	}

	public static void printLL(Node head) {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
