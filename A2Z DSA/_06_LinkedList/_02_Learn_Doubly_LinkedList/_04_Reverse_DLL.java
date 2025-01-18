package _06_LinkedList._02_Learn_Doubly_LinkedList;

import java.util.Stack;

public class _04_Reverse_DLL {
	public static void main(String[] args) {
		int[] arr = { 12, 5, 6, 8, 4 };
		// Convert the array to a doubly linked list
		DoublyNode head = convertArr2DLL(arr);

		// Print the doubly linked list
		System.out.println();
		System.out.print("Doubly Linked List Initially : ");
		print(head);

		System.out.println();
		System.out.print("Doubly Linked List After Stack Reverse : ");
		head = reverseDLLByStack(head);
		print(head);
		

		System.out.println();
		System.out.print("Doubly Linked List After Stack Reverse : ");
		head = reverseDLLBySwapPointers(head);
		head = reverseDLLBySwapPointers(head);
		print(head);
		
	}

	// Brute Force by 2 pass
	private static DoublyNode reverseDLLByStack(DoublyNode head) {

		Stack<Integer> st = new Stack<Integer>();
		DoublyNode temp = head;
		while (temp != null) {
			st.push(temp.data);
			temp = temp.next;
		}

		temp = head;
		while (temp != null) {
			temp.data = st.pop();
			temp = temp.next;
		}

		return head;
	}

	// Brute Force by 2 pass
	private static DoublyNode reverseDLLBySwapPointers(DoublyNode head) {

		if(head == null || head.next == null) {
			return head;
		}
		
		DoublyNode prev = null;
		DoublyNode curr = head;
		
		while(curr != null) {
			
			prev = curr.back;
			curr.back = curr.next;
			
			curr.next = prev;
			
			//because after pointers are swapped, next is now back.
			curr = curr.back;
		}
		
		
		return prev.back;
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

	private static void print(DoublyNode head) {
		while (head != null) {
			// Print the data in the current node
			System.out.print(head.data + " ");
			// Move to the next node
			head = head.next;
		}
		System.out.println();
	}

}
