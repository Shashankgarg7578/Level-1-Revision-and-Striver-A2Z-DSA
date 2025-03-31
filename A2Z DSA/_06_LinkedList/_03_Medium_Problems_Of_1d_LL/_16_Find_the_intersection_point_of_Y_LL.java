package _06_LinkedList._03_Medium_Problems_Of_1d_LL;

import java.util.HashSet;

class Node16 {
	int num;
	Node16 next;

	Node16(int val) {
		num = val;
		next = null;
	}
}

public class _16_Find_the_intersection_point_of_Y_LL {

	// utility function to insert node at the end of the linked list
	static Node16 insertNode16(Node16 head, int val) {
		Node16 newNode16 = new Node16(val);

		if (head == null) {
			head = newNode16;
			return head;
		}

		Node16 temp = head;
		while (temp.next != null)
			temp = temp.next;

		temp.next = newNode16;
		return head;
	}

	static void printList(Node16 head) {
		while (head.next != null) {
			System.out.print(head.num + "->");
			head = head.next;
		}
		System.out.println(head.num);
	}

	public static void main(String args[]) {
		// creation of both lists
		Node16 head = null;
		head = insertNode16(head, 1);
		head = insertNode16(head, 3);
		head = insertNode16(head, 1);
		head = insertNode16(head, 2);
		head = insertNode16(head, 4);
		Node16 head1 = head;
		head = head.next.next.next;
		Node16 headSec = null;
		headSec = insertNode16(headSec, 3);
		Node16 head2 = headSec;
		headSec.next = head;
		// printing of the lists
		System.out.print("List1: ");
		printList(head1);
		System.out.print("List2: ");
		printList(head2);
		
		// checking if intersection is present
		Node16 answerNode16 = intersectionPresentByHeadsChange(head1, head2);
		if (answerNode16 == null)
			System.out.println("No intersection\n");
		else
			System.out.println("The intersection point is " + answerNode16.num);

	}

	// Brute force by Set
	static Node16 intersectionPresent(Node16 head1, Node16 head2) {
		HashSet<Node16> st = new HashSet<Node16>();

		Node16 temp = head1;
		while (temp != null) {
			st.add(temp);
			temp = temp.next;
		}

		temp = head2;
		while (temp != null) {

			if (st.contains(temp)) {
				return temp;
			}

			temp = temp.next;
		}

		return null;
	}

	// Better Approach by length difference
	static Node16 intersectionPresentByDiff(Node16 head1, Node16 head2) {

		// total length of list1
		Node16 t1 = head1;
		int n1 = 0;
		while (t1 != null) {
			n1++;
			t1 = t1.next;
		}

		// total length of list2
		Node16 t2 = head2;
		int n2 = 0;
		while (t2 != null) {
			n2++;
			t2 = t2.next;
		}

		if (n1 < n2) {
			return collisionPoint(head1, head2, n2 - n1);
		} else {
			return collisionPoint(head2, head1, n1 - n2);
		}

	}

	private static Node16 collisionPoint(Node16 t1, Node16 t2, int d) {

		while (d > 0) {
			d--;
			t2 = t2.next;
		}

		while (t1 != t2) {
			t1 = t1.next;
			t2 = t2.next;
		}

		return t1;
	}

	// Optimal (Change heads together when null)
	static Node16 intersectionPresentByHeadsChange(Node16 head1, Node16 head2) {

		if (head1 == null || head2 == null) {
			return null;
		}
		
		Node16 t1 = head1;
		Node16 t2 = head2;

		while (t1 != t2) {
			t1 = t1.next;
			t2 = t2.next;

			if (t1 == t2) {
				return t1;
			}

			if (t1 == null) {
				t1 = head2;
			}

			if (t2 == null) {
				t2 = head1;
			}
		}

		return t1;
	}

}
