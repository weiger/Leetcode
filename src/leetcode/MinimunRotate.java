package leetcode;

public class MinimunRotate {

	public int findMin(int[] num) {
        int start = 0, end = num.length - 1;
        int min = Integer.MAX_VALUE;
        
       int res = minElement(num,start,end,min);
       
       return res;
    }
	
	public int minElement(int[] num,int start,int end,int min){
		int left = 0, right = 0,mid = 0;
		while(start <= end){
        	mid = (start + end)/2;
        	if(num[mid] <= min)
        		min = num[mid];	
        	left = minElement(num,start,mid-1,min);
       	    right = minElement(num,mid+1,end,min);
       	    break;
		}
		
        int res = Math.min(left, right);

		return res;
	}
	public static void main(String[] args) {
		MinimunRotate mr = new MinimunRotate();
		int[] num = {4,5,6,7,1,2};
		System.out.println(mr.findMin(num));

	}

}
