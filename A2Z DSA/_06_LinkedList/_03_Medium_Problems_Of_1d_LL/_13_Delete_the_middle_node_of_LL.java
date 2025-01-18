package _06_LinkedList._03_Medium_Problems_Of_1d_LL;

class Node13 {
	int data;
	Node13 next;

	Node13(int data, Node13 next) {
		this.data = data;
		this.next = next;
	}

	Node13(int data) {
		this.data = data;
		this.next = null;
	}
}

public class _13_Delete_the_middle_node_of_LL {
	static void printLL(Node13 head) {
		Node13 temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		// Creating a sample linked list:
		Node13 head = new Node13(1);
		head.next = new Node13(2);
		head.next.next = new Node13(3);
		head.next.next.next = new Node13(4);
		head.next.next.next.next = new Node13(5);

		// Display the original linked list
		System.out.print("Original Linked List: ");
		printLL(head);

		// Deleting the middle node
		head = deleteMiddle(head);

		// Displaying the updated linked list
		System.out.print("Updated Linked List: ");
		printLL(head);
		
		// Deleting the middle node
		head = deleteMiddleBySlowAndFast(head);

		// Displaying the updated linked list
		System.out.print("Updated Linked List: ");
		printLL(head);
	}

	private static Node13 deleteMiddle(Node13 head) {

		if (head == null || head.next == null) {
			return null;
		}

		Node13 temp = head;
		int n = 0;

		while (temp != null) {
			n++;
			temp = temp.next;
		}

		// Calculate the index of the middle node
		int res = n / 2;
		temp = head;

		// Loop to find the middle node to delete
		while (temp != null) {

			res--;

			// If the middle node is found
			if (res == 0) {
				Node13 middle = temp.next;

				// Adjust pointers to skip the middle node
				temp.next = temp.next.next;

				break;
			}
			// Move to the next node
			// in the linked list
			temp = temp.next;
		}
		// Return the head of the
		// modified linked list
		return head;
	}

	//Optimal
	private static Node13 deleteMiddleBySlowAndFast(Node13 head) {
		if (head == null || head.next == null) {
			return null;
		}

		// Initialize slow and fast pointers
		Node13 slow = head;
		Node13 fast = head;
		fast = head.next.next;

		// Move 'fast' pointer twice as fast as 'slow'
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Delete the middle node by skipping it
		if (slow.next != null) {
			slow.next = slow.next.next;
		}
		return head;
	}

}
