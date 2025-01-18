package _06_LinkedList._03_Medium_Problems_Of_1d_LL;

class Node15 {
	int data;
	Node15 next;

	Node15(int data, Node15 next) {
		this.data = data;
		this.next = next;
	}

	Node15(int data) {
		this.data = data;
		this.next = null;
	}
}

public class _15_Sort_a_LL_of_0_1_and_2_by_changing_links {
	public static void printLinkedList(Node15 head) {
		Node15 temp = head;
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
		Node15 head = new Node15(1);
		head.next = new Node15(0);
		head.next.next = new Node15(1);
		head.next.next.next = new Node15(2);
		head.next.next.next.next = new Node15(0);
		head.next.next.next.next.next = new Node15(2);
		head.next.next.next.next.next.next = new Node15(1);

		System.out.print("Original Linked List: ");
		printLinkedList(head);

		// Sort the linked list
		head = sort012LL(head);

		System.out.print("Sorted Linked List: ");
		printLinkedList(head);

		// Sort the linked list
		head = sort012LLByLinks(head);

		System.out.print("Sorted Linked List: ");
		printLinkedList(head);
	}

	// Brute force by count
	private static Node15 sort012LL(Node15 head) {
		Node15 temp = head;

		int cnt0 = 0, cnt1 = 0, cnt2 = 0;

		while (temp != null) {
			if (temp.data == 0) {
				cnt0++;
			} else if (temp.data == 1) {
				cnt1++;
			} else if (temp.data == 2) {
				cnt2++;
			}
			temp = temp.next;
		}

		temp = head;
		while (temp != null) {
			if (cnt0 > 0) {
				temp.data = 0;
				cnt0--;
			} else if (cnt1 > 0) {
				temp.data = 1;
				cnt1--;
			} else if (cnt2 > 0) {
				temp.data = 2;
				cnt2--;
			}
			temp = temp.next;
		}

		return head;
	}

	private static Node15 sort012LLByLinks(Node15 head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node15 zeroHead = new Node15(-1);
		Node15 zero = zeroHead;
		Node15 oneHead = new Node15(-1);
		Node15 one = oneHead;
		Node15 twoHead = new Node15(-1);
		Node15 two = twoHead;

		Node15 temp = head;

		while (temp != null) {
			if (temp.data == 0) {
				zero.next = temp;
				zero = zero.next;
			} else if (temp.data == 1) {
				one.next = temp;
				one = one.next;
			} else if (temp.data == 2) {
				two.next = temp;
				two = two.next;
			}
			temp = temp.next;
		}
		
		
		
		zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
		one.next = twoHead.next;
		two.next = null;
		
		Node15 newHead = zeroHead.next;
		return newHead;
	}

}



















