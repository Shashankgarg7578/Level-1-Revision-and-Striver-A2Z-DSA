package _06_LinkedList._02_Learn_Doubly_LinkedList;

public class _03_Doubly_LinkedList {
	public static void main(String[] args) {
		int[] arr = { 12, 5, 6, 8, 4, 10 };
		// Convert the array to a doubly linked list
		DoublyNode head = convertArr2DLL(arr);

		// Print the doubly linked list
		System.out.print("Convert Array to DLL : ");
		printDLL(head);

		// All Insert Nodes Functions for DLL
		System.out.println();
		System.out.println();
		System.out.print("Insert before head Node from DLL : ");
		head = insertBeforeHeadInDLL(head, 1);
		printDLL(head);

		System.out.println();
		System.out.println();
		System.out.print("Insert before tail Node from DLL : ");
		head = insertBeforeTailInDLL(head, 9);
		printDLL(head);

		System.out.println();
		System.out.println();
		int k = 3;
		int ele = 16;
		System.out.print("Insert before kth-" + k + " Node from DLL : ");
		head = insertBeforeKthInDLL(head, k, ele);
		printDLL(head);

		System.out.println();
		System.out.println();
		System.out.print("Insert before Node from DLL : ");
		insertBeforeNodeInDLL(head.next, 32);
		printDLL(head);

		// All delete Nodes Functions for DLL
		System.out.println();
		System.out.println();
		System.out.print("Delete head Node from DLL : ");
		head = deleteHeadInDLL(head);
		printDLL(head);

		System.out.println();
		System.out.println();
		System.out.print("Delete tail Node from DLL : ");
		head = deleteTailInDLL(head);
		printDLL(head);

		System.out.println();
		System.out.println();
		int kth = 4;
		System.out.print("Delete Kth:" + kth + " Node from DLL : ");
		head = deleteKthNodeInDLL(head, kth);
		printDLL(head);

		System.out.println();
		System.out.println();
		System.out.print("Delete Node from DLL : ");
		deleteNode(head.next);
		printDLL(head);

	}

	private static DoublyNode convertArr2DLL(int[] arr) {
		DoublyNode head = new DoublyNode(arr[0]);

		DoublyNode prev = head;

		for (int i = 1; i < arr.length; i++) {
			DoublyNode temp = new DoublyNode(arr[i], null, prev);
			prev.next = temp;

			prev = temp;
		}

		return head;
	}

	private static DoublyNode insertBeforeHeadInDLL(DoublyNode head, int ele) {
		DoublyNode newNode = new DoublyNode(ele);
		newNode.next = head;
		head.back = newNode;

		return newNode;
	}

	private static DoublyNode insertBeforeTailInDLL(DoublyNode head, int ele) {

		if (head.next == null) {
			return insertBeforeHeadInDLL(head, ele);
		}

		DoublyNode tail = head;
		while (tail.next != null) {
			tail = tail.next;
		}

		DoublyNode prev = tail.back;
		DoublyNode newNode = new DoublyNode(ele, tail, prev);
		prev.next = newNode;
		tail.back = newNode;

		return head;
	}

	private static DoublyNode insertBeforeKthInDLL(DoublyNode head, int k, int ele) {
		if (k == 1) {
			return insertBeforeHeadInDLL(head, ele);
		}

		DoublyNode temp = head;
		int cnt = 0;
		while (temp != null) {
			cnt++;
			if (cnt == k) {
				break;
			}
			temp = temp.next;
		}

		DoublyNode prev = temp.back;
		DoublyNode newNode = new DoublyNode(ele, temp, prev);

		prev.next = newNode;
		temp.back = newNode;
		return head;
	}

	// this never asked for insert the head
	private static void insertBeforeNodeInDLL(DoublyNode head, int ele) {
		DoublyNode prev = head.back;
		DoublyNode newNode = new DoublyNode(ele, head, prev);
		prev.next = newNode;
		head.back = newNode;
	}

	private static DoublyNode deleteHeadInDLL(DoublyNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		DoublyNode prev = head;
		head = head.next;

		head.back = null;
		prev.next = null;

		return head;
	}

	private static DoublyNode deleteTailInDLL(DoublyNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		DoublyNode tail = head;

		while (tail.next != null) {
			tail = tail.next;
		}

		DoublyNode newTail = tail.back;
		newTail.next = null;

		tail.back = null;
		return head;
	}

	private static DoublyNode deleteKthNodeInDLL(DoublyNode head, int k) {
		if (head == null) {
			return null;
		}

		DoublyNode temp = head;
		int cnt = 0;

		// first stop on Kth element index start from 1
		while (temp != null) {
			cnt++;
			if (cnt == k) {
				break;
			}

			temp = temp.next;
		}

		DoublyNode prev = temp.back; // prev temp node
		DoublyNode front = temp.next;// after temp node

		if (prev == null && front == null) {
			return null;
		} else if (prev == null) {
			return deleteHeadInDLL(head);
		} else if (front == null) {
			return deleteTailInDLL(head);
		} else {

			prev.next = front;
			front.back = prev;

			temp.next = null;
			temp.back = null;

			return head;
		}
	}

	// it is for deleting a node which you provide with out head
	// this never asked for delete the head
	static void deleteNode(DoublyNode temp) {

		DoublyNode prev = temp.back;
		DoublyNode front = temp.next;

		// we don't have last node
		if (front == null) {
			prev.next = null;

			temp.back = null;
			return;
		}

		prev.next = front;
		front.back = prev;

		temp.next = temp.back = null;
		return;
	}

	public static void printDLL(DoublyNode head) {
		DoublyNode temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
}
