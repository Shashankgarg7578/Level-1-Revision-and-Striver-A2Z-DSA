package _06_LinkedList._01_Learn_1D_LinkedList;

public class _01_LinkedList_Representation {
	public static void main(String[] args) {
		int[] arr = { 2, 5, 8, 7 };
		// Create a Node 'x' with the first element of the array
		Node x = new Node(arr[0]);
		// Create a reference 'y' pointing to the same Node 'x'
		Node y = x;
		// Print the reference 'y', which represents the memory address of the Node 'x'
		System.out.print("Define Node :- " + y.data);

		System.out.println();
		System.out.println();
		int[] arr2 = { 2, 3, 4, 5, 6 };
		Node head = convertArrToLL(arr2);
		System.out.print("Convert Array to LL :- " + head.data);

		System.out.println();
		System.out.println();
		System.out.print("Print Linked List :- ");
		printLL(head);

		System.out.println();
		System.out.println();
		System.out.println("Length-LL :- " + lengthOfLL(head));

		System.out.println();
		System.out.println();
		System.out.println("Check Value exist :- " + checkIfPresent(head, 8));

		System.out.println();
		System.out.println();

	}

	public static Node convertArrToLL(int[] arr) {
		Node head = new Node(arr[0]);

		Node mover = head;

		for (int i = 1; i < arr.length; i++) {
			Node temp = new Node(arr[i]);
			mover.next = temp;
			mover = temp;
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

	public static int lengthOfLL(Node head) {
		Node temp = head;
		int cnt = 0;

		while (temp != null) {
			cnt++;
			temp = temp.next;
		}
		return cnt;
	}

	public static int checkIfPresent(Node head, int val) {
		Node temp = head;

		while (temp != null) {
			if (temp.data == val) {
				// found
				return 1;
			}
			temp = temp.next;
		}

		// not found
		return 0;
	}

}
