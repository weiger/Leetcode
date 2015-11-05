package leetcode;

import java.util.*;
public class SingleNumberII {
	public static int singleNumber(int[] A) {
        
        Arrays.sort(A);
        for(int i : A){
        	System.out.println(i);
        }
        int res = 0,count = 1, diff = 0;
        int index = 0;
        
        for(int i = 1; i<A.length; i++){
            if(A[i-1] == A[i]){
                count++;
            }else{
                index = i;
                diff++;
            }
                
            if(count == 3){
                count = 1;
            }
            
            if(diff > 1){
                index = i-1;
                break;
            }     
        }
        System.out.println(index);
        return A[index];
    }
	public static void main(String[] args) {
		SingleNumberII test = new SingleNumberII();
		int[] a = {2,3,2,2};
		System.out.print(test.singleNumber(a));

	}

}
