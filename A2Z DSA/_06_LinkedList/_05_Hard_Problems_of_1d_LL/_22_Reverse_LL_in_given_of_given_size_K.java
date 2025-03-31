package _06_LinkedList._05_Hard_Problems_of_1d_LL;

class Node22 {
	int data;
	Node22 next;

	Node22(int data) {
		this.data = data;
		this.next = null;
	}

	Node22(int data, Node22 node) {
		this.data = data;
		this.next = node;
	}
}

public class _22_Reverse_LL_in_given_of_given_size_K {
	// Function to print the linked list
	static void printLinkedList(Node22 head) {
		Node22 temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Create a linked list with
		// values 5, 4, 3, 7, 9 and 2
		Node22 head = new Node22(5);
		head.next = new Node22(4);
		head.next.next = new Node22(3);
		head.next.next.next = new Node22(7);
		head.next.next.next.next = new Node22(9);
		head.next.next.next.next.next = new Node22(2);

		// Print the original linked list
		System.out.print("Original Linked List: ");
		printLinkedList(head);

		// Reverse the linked list
		head = kReverse(head, 4);

		// Print the reversed linked list
		System.out.print("Reversed Linked List: ");
		printLinkedList(head);
	}

	private static Node22 kReverse(Node22 head, int k) {

		Node22 temp = head;
		
		Node22 prevLast = null;
		
		while (temp != null) {
			Node22 kthNode = getKthNode(temp, k);

			// we don't have k elements left
			if (kthNode == null) {
				if (prevLast != null) {
					prevLast.next = temp;
				}

				break;
			}

			// take ref for next time reverse
			Node22 nextNode = kthNode.next;
			// current k nodes , last node point to null
			kthNode.next = null;

			reverseLinkedListByPointers(temp);

			if (temp == head) {
				// this only for first time
				// because head will be changed
				head = kthNode;
			} else {
				// attach previous list to new reversed list
				prevLast.next = kthNode;
			}

			// remember last node of prev list
			prevLast = temp;
			// move for new list creation
			temp = nextNode;

		}

		return head;
	}

	private static Node22 getKthNode(Node22 temp, int k) {

		k = k - 1;

		while (temp != null && k > 0) {
			k--;
			temp = temp.next;
		}

		return temp;
	}

	private static void reverseLinkedListByPointers(Node22 head) {
		Node22 temp = head;
		
		Node22 prev = null;
				
		while(temp != null) {
			Node22 front = temp.next;
			temp.next = prev;
			prev = temp;
			temp = front;
		}
	}

}
