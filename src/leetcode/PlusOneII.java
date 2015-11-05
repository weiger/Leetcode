package leetcode;

public class PlusOneII {

	 public static int[] plusOne(int[] digits) {
	        
	        int carry = 0,one = 1;
	        
	        for(int i = digits.length-1; i >= 0; i--){
	        	
	        	int sum = (carry+digits[i]+one);
	            digits[i] =sum %10;
	           // System.out.println(digits[i]);
	            carry = sum/10;
	            one = 0;
	        }
	        System.out.println(carry);
	        if(carry == 0) return digits;
	        
	        int[] res = new int[digits.length+1];
	        res[0] = carry;
	        
	        for(int i = 1; i <= digits.length; i++)
	            res[i] = digits[i-1];
	        
	        return res;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {9};
		
		int[] res = plusOne(nums);
		
		for(int i : res) System.out.println(i);
		System.out.println("---------------");
		System.out.println(res.length);
	}

}
