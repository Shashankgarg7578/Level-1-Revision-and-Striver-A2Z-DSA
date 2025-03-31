package _07_Stack_and_Queue._03_Monotonic_Stack_Queue_Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _22_Asteroid_Collision {
	public static void main(String args[]) {
		int asteroids[] = { 4, 7, 1, 1, 2, -3, -7, 17, 15, -14, -13 };
		System.out.println(asteroidCollisionByList(asteroids));

		int[] ansArr = asteroidCollisionByStack(asteroids);
		for (int ans : ansArr) {
			System.out.print(ans + " ");
		}

	}

	public static List<Integer> asteroidCollisionByList(int[] asteroids) {

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < asteroids.length; i++) {

			if (asteroids[i] > 0) {
				//if in first list data are posotive add in ans list
				list.add(asteroids[i]);
			} else {

				// when last element is lesser then
				while (!list.isEmpty() && list.get(list.size() - 1) > 0
						&& list.get(list.size() - 1) < Math.abs(asteroids[i])) {
					list.remove(list.size() - 1);
				}

				// when both are equal
				if (!list.isEmpty() && list.get(list.size() - 1) == Math.abs(asteroids[i])) {
					list.remove(list.size() - 1);
				} else if (list.isEmpty() || list.get(list.size() - 1) < 0) {
					list.add(asteroids[i]);
				}

			}

		}

		return list;
	}

	public static int[] asteroidCollisionByStack(int[] asteroids) {

		Stack<Integer> st = new Stack<Integer>();

		for (int val : asteroids) {

			if (val > 0) {
				st.push(val);
			} else {

				// when last element is lesser then
				while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(val)) {
					st.pop();
				}

				// when both are equal
				if (!st.isEmpty() && st.peek() == Math.abs(val)) {
					st.pop();
				} else if (st.isEmpty() || st.peek() < 0) {
					st.push(val);
				}

			}
		}

		int[] ans = new int[st.size()];
		int i = ans.length - 1;
		while (i >= 0) {
			ans[i] = st.pop();
			i--;
		}

		return ans;
	}

}
