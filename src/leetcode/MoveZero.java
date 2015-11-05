package leetcode;

public class MoveZero {

	public static void moveAllZeros(int[] nums){
		if(nums.length == 0)
			return ;
		
		int start = 0, end = nums.length-1;
		
		while(start <= end){
			if(nums[start] != 0)
				start++;
			else if(nums[end] == 0)
				end--;
			else if(nums[start] == 0 && nums[end] != 0){
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
				start++;
				end--;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0, 0,0,1, 0, 3, 12,0,0};
		moveAllZeros(nums);
		for(int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + "   ");
	}

}
