package Arrays._1_Easy;

//blog : https://takeuforward.org/data-structure/find-the-largest-element-in-an-array/
//Question : https://www.geeksforgeeks.org/problems/largest-element-in-array4009/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=largest-element-in-array
public class _01_LargestElementInAnArray {

	public static void main(String[] args) {
		int arr1[] = { 2, 5, 1, 3, 0 };
		int arr2[] = { 8, 10, 5, 7, 9 };

		System.out.println("Bruite Force");
		System.out.println("The Largest element in the array is: " + sort(arr1));
		System.out.println("The Largest element in the array is: " + sort(arr2));
		
		System.out.println("Optimal Approach");
		System.out.println("The Largest element in the array is: " + optimalSort(arr1));
		System.out.println("The Largest element in the array is: " + optimalSort(arr2));
	}

	//Brute Force
//	Time Complexity: O(N*log(N))
//	Space Complexity: O(n)
	public static int sort(int[] arr) {

		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr.length-1 - i ; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr[arr.length-1];
	}

	// Optimal
//	Time Complexity: O(N)
//	Space Complexity: O(1)
	public static int optimalSort(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
             if(arr[i] > max) {
            	 max = arr[i];
             }			
		}

		return max;
	}



}
