package NewQuestions;

import java.util.Arrays;

public class _3SumSmaller {

	/*
	 * Given an array of n integers nums and a target, find the number of index 
	 * triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + 
	 * nums[j] + nums[k] < target.

		For example, given nums = [-2, 0, 1, 3], and target = 2.

		Return 2. Because there are two triplets which sums are less than 2:

		[-2, 0, 1]
		[-2, 0, 3]
		Follow up:  Could you solve it in O(n^2) runtime?
	 */
	
	public static int threeSumSmaller(int[]nums, int target){
		if(nums.length == 0) return 0;
		
		Arrays.sort(nums);
		
		int count = 0;
		
		for(int i = 0; i < nums.length; i++){
			int j = i+1, k = nums.length-1;
			
			while(j < k){
				int sum = nums[i]+nums[j]+nums[k];
				
				if(sum >= target){
					k--;
				}else{
					count += k-j;
					j++;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2,0,1,3};
		System.out.println(threeSumSmaller(nums,2));
	}

}
