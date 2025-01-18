package _06_LinkedList._04_Medium_Problems_Of_Doubly_LL;

import java.util.ArrayList;

class DoublyNode20 {
	int data;
	DoublyNode20 next;
	DoublyNode20 back;

	DoublyNode20(int data) {
		this.data = data;
		this.next = null;
		this.back = null;
	}

	DoublyNode20(int data, DoublyNode20 next, DoublyNode20 back) {
		this.data = data;
		this.next = next;
		this.back = back;
	}
}

public class _20_Find_pairs_with_given_sum_in_DLL {

	public static void printDLL(DoublyNode20 head) {
		DoublyNode20 temp = head;

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	private static DoublyNode20 convertArr2DLL(int[] arr) {
		DoublyNode20 head = new DoublyNode20(arr[0]);

		DoublyNode20 prev = head;

		for (int i = 1; i < arr.length; i++) {
			DoublyNode20 temp = new DoublyNode20(arr[i], null, prev);
			prev.next = temp;

			prev = temp;
		}

		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 9 };

		DoublyNode20 head = convertArr2DLL(arr);
		System.out.print("Orignal DLL: ");
		printDLL(head);

		ArrayList<ArrayList<Integer>> ans = findPairsWithGivenSumByTwoPointer(5, head);
		System.out.println();
		for (ArrayList<Integer> it : ans) {
			System.out.println(it);
		}

	}

	// Brute force
	public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, DoublyNode20 head) {

		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		DoublyNode20 temp1 = head;

		while (temp1 != null) {
			DoublyNode20 temp2 = temp1.next;

			while (temp2 != null && (temp1.data + temp2.data <= target)) {
				if (temp1.data + temp2.data == target) {
					ArrayList<Integer> data = new ArrayList<Integer>();
					data.add(temp1.data);
					data.add(temp2.data);
					ans.add(data);
				}
				temp2 = temp2.next;
			}

			temp1 = temp1.next;

		}

		return ans;
	}

	// Optimal
	public static ArrayList<ArrayList<Integer>> findPairsWithGivenSumByTwoPointer(int target, DoublyNode20 head) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

		if (head == null)
			return ans;

		DoublyNode20 left = head;
		DoublyNode20 right = findTail(head);

		while (left.data < right.data) {
			if (left.data + right.data == target) {
				ArrayList<Integer> data = new ArrayList<Integer>();
				data.add(left.data);
				data.add(right.data);
				ans.add(data);

				left = left.next;
				right = right.back;
			} else if (left.data + right.data < target) {
				left = left.next;
			} else {
				right = right.back;
			}
		}

		return ans;
	}

	public static DoublyNode20 findTail(DoublyNode20 head) {
		DoublyNode20 tail = head;

		while (tail.next != null) {
			tail = tail.next;
		}

		return tail;
	}

}
