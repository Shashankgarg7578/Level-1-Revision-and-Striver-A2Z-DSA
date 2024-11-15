package Arrays._3_Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//blog : https://takeuforward.org/data-structure/majority-elementsn-3-times-find-the-elements-that-appears-more-than-n-3-times-in-the-array/
//Question : https://leetcode.com/problems/majority-element-ii/

// it is updated Question of Q.16 which is in Medium
public class _28_Majority_Element_n_by_3_times {

	public static void main(String[] args) {
		int[] arr1 = { 3, 2, 2, 2, 3 };

		List<Integer> ans1 = majorityElement(arr1);
		System.out.print("The majority elements are: ");
		for (int i = 0; i < ans1.size(); i++) {
			System.out.print(ans1.get(i) + " ");
		}
		System.out.println();
		
		int[] arr2 = { 11, 33, 33, 11, 33, 11 };
		List<Integer> ans2 = majorityElement2(arr2);
		System.out.print("The majority elements are: ");
		for (int i = 0; i < ans2.size(); i++) {
			System.out.print(ans2.get(i) + " ");
		}
		System.out.println();
		
	}

	// Brute force
	// Time Complexity: O(N2)
	// Space Complexity: O(1)
	private static List<Integer> majorityElement(int[] arr) {
		int n = arr.length;
		List<Integer> ans = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {

			// selected element is arr[i]: Checking if arr[i] is not already a part of the  answer:
			if (ans.size() == 0 || ans.get(0) != arr[i]) {
				int cnt = 0;

				for (int tempVal : arr) {
					// counting the frequency of arr[i]
					if (tempVal == arr[i]) {
						cnt++;
					}
				}

				// check if frequency is greater than n/3:
				if (cnt > (n / 3)) {
					ans.add(arr[i]);
				}
			}

			if (ans.size() == 2) {
				break;
			}
		}

		return ans;
	}

	// Better
	// Time Complexity:
	// Space Complexity:
	private static List<Integer> majorityElement2(int[] arr) {
		int n = arr.length;
		List<Integer> ans = new ArrayList<Integer>();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int min = (int) (n/3) + 1;
		
		for (int i = 0; i < n; i++) {

			int val = map.getOrDefault(arr[i], 0);
			map.put(arr[i], val+1);
			
			if(map.get(arr[i]) == min) {
				ans.add(arr[i]);
			}
			
			if(ans.size() == 2) break;
		}

		return ans;
	}

	//Optimal : In Q.16 we need only 1 element , and here we need 2 elements,
    //	        that's why same algo will use here with 2 variables
	//Time Complexity: O(N) + O(N)
	//Space Complexity: O(1)
    public static List<Integer> majorityElement3(int []v) {
        int n = v.length; //size of the array

        int cnt1 = 0, cnt2 = 0; // counts
        int el1 = Integer.MIN_VALUE; // element 1
        int el2 = Integer.MIN_VALUE; // element 2

        // applying the Extended Boyer Moore's Voting Algorithm:
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && el2 != v[i]) {
                cnt1 = 1;
                el1 = v[i];
            } else if (cnt2 == 0 && el1 != v[i]) {
                cnt2 = 1;
                el2 = v[i];
            } else if (v[i] == el1) cnt1++;
            else if (v[i] == el2) cnt2++;
            else {
                cnt1--; cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>(); // list of answers

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        cnt1 = 0; cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == el1) cnt1++;
            if (v[i] == el2) cnt2++;
        }

        int mini = (int)(n / 3) + 1;
        if (cnt1 >= mini) ls.add(el1);
        if (cnt2 >= mini) ls.add(el2);

        // Uncomment the following line
        // if it is told to sort the answer array:
        //Collections.sort(ls); //TC --> O(2*log2) ~ O(1);

        return ls;
    }
	
}




















