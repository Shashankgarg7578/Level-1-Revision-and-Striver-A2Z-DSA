package _09_Greedy_Algorithms._01_Easy;

public class _02_Lemonade_Change {
	public static void main(String[] args) {

		// in this problem we have to cut only 5rs for every index element
		// and other we have to give if we have
//		5  -> +
//		10 -> (-5), (+10)
//		20 -> (+20) , -(10,5) OR -(5,5,5)

		int[] bills = { 5, 5, 5, 10, 20 };

		System.out.print("Queues of customers: ");
		for (int bill : bills) {
			System.out.print(bill + " ");
		}
		System.out.println();

		boolean ans = lemonadeChange(bills);
		if (ans)
			System.out.println("It is possible to provide change for all customers.");
		else
			System.out.println("It is not possible to provide change for all customers.");
	}

	// TC : O(N)
	// SC : O(1)
	private static boolean lemonadeChange(int[] bills) {

		int five = 0;
		int ten = 0;

		for (int i = 0; i < bills.length; i++) {

			if (bills[i] == 5) {

				five = five + 1;

			} else if (bills[i] == 10) {

				if (five > 0) {
					ten = ten + 1;
					five = five - 1;
				} else {
					return false;
				}

			} else {

				if (five > 0 && ten > 0) {
					five--;
					ten--;
				} else if (five >= 3) {
					five = five - 3;
				} else {
					return false;
				}
			}

		}

		return true;
	}
}
