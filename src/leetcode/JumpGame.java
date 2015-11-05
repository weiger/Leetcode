package leetcode;

public class JumpGame {
	public static boolean canJump(int[] A) {
        int i = 0;
        
        for( i = 0; i < A.length-1;){
            if(A[i] != 0)
                i = i+A[i];
            else 
                return false;
        }
        
        if(i == A.length-1)
            return true;
        
        return false;
    }
	public static void main(String[] args) {
		int[] a = {2,3,1,2,4};
		System.out.println(canJump(a));

	}

}
