package leetcode;
import java.util.*;

public class FistMissingPositive {
	 public static int firstMissingPositive(int[] A) {
	        if(A.length == 0)
	            return 1;
	        
	        Set<Integer> set = new HashSet<Integer>();
	        for(int i:A)
	        	set.add(i);
	        
	        Integer[] B = set.toArray(new Integer[set.size()]);
	        
	        Arrays.sort(B);
	        
	        int index = -1;
	        
	        for(int i = 0; i < B.length; i++){
	            if(B[i] > 0){
	                index = i;
	                break;
	            }
	        }
	        int num = 1;
	        if(index < 0)
	            return 1;
	        else{
	            if(B[index] > 1)
	                return 1;
	            else if(B[index] == num){
	                while(++index < B.length){
	                    num++;
	                    if(B[index] == num) 
	                        continue;
	                    else
	                        break;
	                }
	            }
	        }
	        if(index == B.length)
	        	num++;
	        
	        return num;
	    }
	public static void main(String[] args) {
		int[] a = {3,2,-1,1,4};
		int[] b = {3,4,-1,1};
		int[] c = {1,2,2,1,0};
		System.out.print(firstMissingPositive(c));

	}

}
