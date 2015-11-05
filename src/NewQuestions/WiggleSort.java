package NewQuestions;

public class WiggleSort {

	/*
	Given a sorted array, and re-arrange it to wiggle style in one pass.
	i.e. [1] A0 >= A1 <= A2 >= A3 .... .... An.
	     [2] A0 <= A1 >= A2 <= A3 .... .... An.
	*/
	
	// [1] A0 >= A1 <= A2 >= A3 .... .... An.
	public static void wiggleSort(int[] arr) {
		   // Input checking.
		   if (arr == null || arr.length == 0) return;
		 
		   // Arrays.sort(arr).
		   int index = 0;
		   while (index < arr.length - 1) {
		       swap(arr, index, index + 1);
		       index += 2;
		   }
	}
	
	// [2] A0 <= A1 >= A2 <= A3 .... .... An.
	public static void wiggleSort2(int[] arr) {
		   // Input checking.
		   if (arr == null || arr.length == 0) return;
		 
		   // Arrays.sort(arr).
		   int index = 1;
		   while (index < arr.length - 1) {
		       swap(arr, index, index + 1);
		       index += 2;
		    }
	}
	
	// Implementation for wiggle sort with input as unsorted array

	public static void wiggleSort(int arr[], boolean startGreater) {
		for (int i = 0; i < arr.length - 1;) {
			if (startGreater) {
				if (arr[i]- arr[i + 1] <= 0){
					swap(arr, i, i + 1);
				}
			} else {
				if (arr[i]-(arr[i + 1]) >= 0) {
						swap(arr, i, i + 1);
				}
			}
			startGreater = !startGreater;
			i++;
		}
	}
	
	private static void swap(int[] arr, int first, int second) {
		   int tmp = arr[first];
		   arr[first] = arr[second];
		   arr[second] = tmp;
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,0,-1,2,-2,9,10,11,1};
		wiggleSort(arr,false);
		for(int i : arr)
			System.out.print(i + "     ");
	}

}
