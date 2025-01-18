package _06_LinkedList._03_Medium_Problems_Of_1d_LL;

class Node12 {
	public int data;
	public Node12 next;

	// Constructor for Node12 with data and next node
	public Node12(int data1, Node12 next1) {
		data = data1;
		next = next1;
	}

	// Constructor for Node12 with only data (next set to null)
	public Node12(int data1) {
		data = data1;
		next = null;
	}
}

public class _12_Remove_Nth_node_from_the_back_of_the_LL {
	// Function to print the linked list
	public static void printLL(Node12 head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int N = 3;
		Node12 head = new Node12(arr[0]);
		head.next = new Node12(arr[1]);
		head.next.next = new Node12(arr[2]);
		head.next.next.next = new Node12(arr[3]);
		head.next.next.next.next = new Node12(arr[4]);

		// Delete the Nth node from
		// the end and print the modified linked list
		head = DeleteNthNode12fromEnd(head, N);
		printLL(head);

		System.out.println();
		
		// Delete the Nth node from
		// the end and print the modified linked list
		head = DeleteNthNode12fromEndBySlowAndFast(head, N);
		printLL(head);
	}

	// Brute force
	private static Node12 DeleteNthNode12fromEnd(Node12 head, int N) {
		if (head == null) {
			return null;
		}

		int cnt = 0;
		Node12 temp = head;

		// Count the number of nodes in the linked list
		while (temp != null) {
			cnt++;
			temp = temp.next;
		}

		// if N is length of linkedList then we have to delete head
		if (cnt == N) {
			Node12 newhead = head.next;
			head = null;
			return newhead;
		}

		// Calculate the position of the node to delete (res)
		int res = cnt - N;
		temp = head;

		// Traverse to the node just before the one to delete
		while (temp != null) {
			res--;
			if (res == 0) {
				break;
			}
			temp = temp.next;
		}

		// Delete the Nth node from the end
		Node12 delNode = temp.next;
		temp.next = temp.next.next;
		delNode = null;
		return head;
	}

	// Brute force
	private static Node12 DeleteNthNode12fromEndBySlowAndFast(Node12 head, int N) {
		// Create two pointers, fastp and slowp
		Node12 fastp = head;
		Node12 slowp = head;

		// Move the fastp pointer N nodes ahead
		for (int i = 0; i < N; i++)
			fastp = fastp.next;

		// If fastp becomes null, the Nth node from the end is the head
		if (fastp == null)
			return head.next;
		
		// Move both pointers until fastp reaches the end
        while (fastp.next != null) {
            fastp = fastp.next;
            slowp = slowp.next;
        }

		// Delete the Nth node from the end
		Node12 delNode = slowp.next;
		slowp.next = slowp.next.next;
		delNode = null;
		return head;
	}
}
