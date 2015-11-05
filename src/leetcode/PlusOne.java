package leetcode;

public class PlusOne {

	public static int[] plusOne(int[] digits) {
        
        int[] res = new int[digits.length+1];
        int[] tres = new int[digits.length];
        int count = 0;
        int one = 1,len = res.length - 1;
        
        for(int i = digits.length-1; i>=0; i--){
            int sum = digits[i] + one + count;
            if(sum == 10){
                res[len--] = 0;
                one = 0;
                count = 1;
            }else{
                res[len--] = sum;
                one = 0;
                count = 0;
            }
        }
        if(count == 1){
            res[0] = 1; 
            return res;
        }
        
        for(int i = 1; i < res.length; i++)
        	tres[i-1] = res[i];
        return tres;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] a = {9,9,9,9};
        int[] res = plusOne(a);
        for(int i :res)
         System.out.println(i);
	}

}
