package leetcode;

public class Factorial {

	public static long factorial(int n){
		
		long sum = 1l;
		for(int i = 1;i<=n;i++){
			sum *=i;
		}
		return sum;
	}
	
	 public static int trailingZeroes(int n) {
	        
	        long result = factorial(n);
	        
	        int count = 0;
	        long reminder = 0;
	        
	        while(reminder == 0){
	            reminder = result % 10;
	            
	            if(reminder == 0)
	                count++;
	                
	            result = result /10;
	        }
	        
	        return count;
	    }
	
	public static void main(String[] args) {
		

		long result = factorial(20);
        int count = 0;
       // while(result%10 == 0){
        //	count++;
        	//result = result/10;
        //}
     
		System.out.print(result);

	}

}
