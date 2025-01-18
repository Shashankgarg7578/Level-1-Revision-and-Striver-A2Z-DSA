package _02_Recursion._1_Basic;

public class _13_Find_First_Occrance {
	public static void main(String[] args) {

		int[] arr = { 2, 3, 6, 9, 8, 3, 2, 6, 2, 4 };

		int target = 9;

		int ans = findFirstOcc(0, target, arr);

		System.out.print(ans);

	}

	private static int findFirstOcc(int idx, int target, int[] arr) {

		if (idx == arr.length) {
			return -1;
		}

		if (arr[idx] == target) {
			return idx;
		}

		return findFirstOcc(idx + 1, target, arr);
	}
}
