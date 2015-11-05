package NewQuestions;

public class VerifyProOrderSequence {

	
	public static boolean isValid(int[] preorder){
		int low = Integer.MIN_VALUE, i = -1;
	    for (int p : preorder) {
	        if (p < low)
	            return false;
	        while (i >= 0 && p > preorder[i])
	            low = preorder[i--];
	        preorder[++i] = p;
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {5,3,1,2,4,7,6};
		System.out.println(isValid(nums));
	}

}
