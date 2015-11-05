package leetcode;

public class RotatedArray {
	 public static int search(int[] A, int target) {
	        
	        int start = 0, end = A.length - 1;
	        while(start <= end){
	            int mid = (start + end)/2;
	            
	            if(A[mid] == target){
	                return mid;
	            }else if(A[mid] > target){
	                if(A[start] < target){
	                    end = mid-1;
	                }else if(A[start] > target){
	                    start++;
	                }else{
	                	return start;
	                }
	                
	            }else{
	                if(A[end] > target)
	                    start = mid+1;
	                else if(A[end]< target)
	                    end--;
	                else
	                	return end;
	            }
	        }
	        
	        return -1;
	    }
	public static void main(String[] args) {
		int[] a = {3,4,5,6,7,0,1,2};
		//int[] a = {1,3};
		System.out.println(search(a,5));

	}

}
