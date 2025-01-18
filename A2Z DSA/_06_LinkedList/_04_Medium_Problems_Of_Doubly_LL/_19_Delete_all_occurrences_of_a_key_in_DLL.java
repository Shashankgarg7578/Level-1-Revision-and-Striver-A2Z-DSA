package _06_LinkedList._04_Medium_Problems_Of_Doubly_LL;

class DoublyNode19 {
	int data;
	DoublyNode19 next;
	DoublyNode19 back;

	DoublyNode19(int data) {
		this.data = data;
		this.next = null;
		this.back = null;
	}

	DoublyNode19(int data, DoublyNode19 next, DoublyNode19 back) {
		this.data = data;
		this.next = next;
		this.back = back;
	}
}

public class _19_Delete_all_occurrences_of_a_key_in_DLL {
	private static DoublyNode19 convertArr2DLL(int[] arr) {
		DoublyNode19 head = new DoublyNode19(arr[0]);

		DoublyNode19 prev = head;

		for (int i = 1; i < arr.length; i++) {
			DoublyNode19 temp = new DoublyNode19(arr[i], null, prev);
			prev.next = temp;

			prev = temp;
		}

		return head;
	}

	public static void printDLL(DoublyNode19 head) {
		DoublyNode19 temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 10, 4, 10, 10, 6, 10 };

		DoublyNode19 head = convertArr2DLL(arr);
		System.out.print("Orignal DLL: ");
		printDLL(head);

		System.out.println();

		head = deleteAllOccurOfX(head, 10);
		System.out.print("After delete all occrance: ");
		printDLL(head);
	}

	public static DoublyNode19 deleteAllOccurOfX(DoublyNode19 head, int x) {
		DoublyNode19 temp = head;

		while (temp != null) {
			if (temp.data == x) {
				
				//if head node is x which we have to delete
				if (temp == head) {
					head = temp.next;
				}

				DoublyNode19 nextNode = temp.next;
				DoublyNode19 prevNode = temp.back;

				if (nextNode != null) {
					nextNode.back = prevNode;
				}
				if (prevNode != null) {
					prevNode.next = nextNode;
				}
				temp = nextNode;
			} else {
				temp = temp.next;
			}
		}

		return head;
	}

}
