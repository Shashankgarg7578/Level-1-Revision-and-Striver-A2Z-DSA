package _07_Stack_and_Queue._4_Implementation_Problems;

import java.util.ArrayList;
import java.util.Stack;

public class _26_Stock_span_problem {

	public static void main(String[] args) {
		StockSpannerOptimal ssbf = new StockSpannerOptimal();
		System.out.println(ssbf.next(7));
		System.out.println(ssbf.next(2));
		System.out.println(ssbf.next(1));
		System.out.println(ssbf.next(3));
		System.out.println(ssbf.next(3));
		System.out.println(ssbf.next(1));
		System.out.println(ssbf.next(8));

	}

}

class StockSpannerBruteForce {

	ArrayList<Integer> arr;

	public StockSpannerBruteForce() {
		arr = new ArrayList<Integer>();
	}

	// TC:- O(N)
	// SC:- O(total number of next till now)
	public int next(int price) {

		arr.add(price);

		int cnt = 1;

		for (int i = arr.size() - 2; i >= 0; i--) {
			if (arr.get(i) <= price) {
				cnt++;
			} else {
				break;
			}

		}

		return cnt;
	}

}

class StockSpannerOptimal {

	class Pair {
		int price;
		int index;

		Pair(int price, int index) {
			this.price = price;
			this.index = index;
		}

	}

	Stack<Pair> st;
	int idx = -1;

	public StockSpannerOptimal() {
		st = new Stack<>();
	}

	// same as Previous Greater element
	public int next(int price) {

		int ans = 0;

		idx = idx + 1;

		while (!st.isEmpty() && st.peek().price <= price) {
			st.pop();
		}

		if (st.isEmpty()) {
			ans = idx - (-1);
		} else {
			ans = idx - st.peek().index;
		}
		st.push(new Pair(price, idx));

		return ans;
	}

}
