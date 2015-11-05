package leetcode;

import java.util.*;

public class Median {
	
	
	public static double findMedianSortedArrays(int A[], int B[]) {
		
		List<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < A.length;i++)
			temp.add(A[i]);
		
		for(int i = 0; i < B.length;i++)
			temp.add(B[i]);
	    
		Collections.sort(temp);
		
		for(int i = 0; i<temp.size();i++)
			System.out.print(temp.get(i));
		System.out.print("\n");
		
		int mid = (0+temp.size()-1)/2;;
		System.out.println(mid);
		
		double result = 0;
		
		if(temp.size()%2 == 0){
			System.out.println(temp.get(mid));
			System.out.println(temp.get(mid+1));
			result =(double) (temp.get(mid)+temp.get(mid+1))/2;				
		}else{
			result = temp.get(mid); 
		}
		return result;
	}
	public static void main(String[] args) {
		
		int A[] = {1,2,3,4,5};
		int B[] = {2,3,6,7,8,10};
		double median = findMedianSortedArrays(A,B);
		System.out.print(median);
		

	}

}
