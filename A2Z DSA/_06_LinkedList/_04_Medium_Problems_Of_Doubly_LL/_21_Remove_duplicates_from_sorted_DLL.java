package _06_LinkedList._04_Medium_Problems_Of_Doubly_LL;

class DoublyNode21 {
	int data;
	DoublyNode21 next;
	DoublyNode21 back;

	DoublyNode21(int data) {
		this.data = data;
		this.next = null;
		this.back = null;
	}

	DoublyNode21(int data, DoublyNode21 next, DoublyNode21 back) {
		this.data = data;
		this.next = next;
		this.back = back;
	}
}

public class _21_Remove_duplicates_from_sorted_DLL {

	public static void printDLL(DoublyNode21 head) {
		DoublyNode21 temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	private static DoublyNode21 convertArr2DLL(int[] arr) {
		DoublyNode21 head = new DoublyNode21(arr[0]);

		DoublyNode21 prev = head;

		for (int i = 1; i < arr.length; i++) {
			DoublyNode21 temp = new DoublyNode21(arr[i], null, prev);
			prev.next = temp;

			prev = temp;
		}

		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 1, 1, 2, 3, 3, 4 };

		DoublyNode21 head = convertArr2DLL(arr);
		System.out.print("Orignal DLL: ");
		printDLL(head);

		head = removeDuplicates(head);
		System.out.println();
		printDLL(head);
	}

	//DLL should be in sorted order.
	private static DoublyNode21 removeDuplicates(DoublyNode21 head) {
		DoublyNode21 temp = head;
		
		while(temp != null  && temp.next != null) {
			DoublyNode21 nextNode = temp.next;
			
			//if both are same then increase nextNode index
			while(nextNode != null && nextNode.data == temp.data) {
				nextNode = nextNode.next;
			}
			
			temp.next = nextNode;
			if(nextNode != null) {
				nextNode.back = temp;
			}
			
			temp= temp.next;
		}
		
		return head;
	}
}

