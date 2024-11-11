package Arrays;

import java.util.HashMap;
import java.util.Map;

//blog:https://takeuforward.org/data-structure/find-the-majority-element-that-occurs-more-than-n-2-times/
//Question : https://leetcode.com/problems/majority-element/
public class _16_Majority_Element_nby2_times {
	public static void main(String[] args) {
		int[] arr = { 2, 2, 1, 1, 1, 2, 2 };
		int ans = majorityElement(arr);
		System.out.println("The majority element is: " + ans);

		int ans2 = majorityElement2(arr);
		System.out.println("The majority element is: " + ans2);
		
		int ans3 = majorityElement3(arr);
		System.out.println("The majority element is: " + ans3);
	}

	// Brute force
	// Time Complexity: O(N2)
	private static int majorityElement(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			// selected element is v[i]
			int count = 0;
			for (int a : arr) {
				// counting the frequency of v[i]
				if (a == arr[i]) {
					count++;
				}
			}
			// check if frquency is greater than n/2:
			if (count > (arr.length / 2)) {
				return arr[i];
			}
		}

		return -1;
	}

	// Better
	// Time Complexity: O(N*logN) + O(N),
	// Space Complexity: O(N)
	private static int majorityElement2(int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		// key = array value, value = array index
		for (int i = 0; i < arr.length; i++) {
			int val = map.getOrDefault(arr[i], 0);
			map.put(arr[i], val + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > arr.length / 2) {
				return entry.getKey();
			}
		}

		return -1;
	}

	// Optimal :- Moore’s Voting Algorithm
	// Time Complexity: O(N) + O(N)
	// Space Complexity: O(1)
	// refer : https://www.youtube.com/watch?v=nP_ns3uSh80&list=PLgUwDviBIf0rENwdL0nEH0uGom9no0nyB&index=7
	private static int majorityElement3(int[] arr) {
		int me = -1; //majority element
		int cnt = 0; 
		
		for(int i = 0 ; i < arr.length ; i++) {
			if(cnt == 0) {
				me = arr[i];
				cnt++;
			}else if(arr[i] == me){
				cnt++;
			}else {
				cnt--;
			}
		}
			
		return me;
	}

}
