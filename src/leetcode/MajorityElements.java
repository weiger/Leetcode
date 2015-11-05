package leetcode;

import java.util.*;

public class MajorityElements {

	
	public static int majority(int[] a){
		if(a.length == 0)
			return 0;
		
	    Arrays.sort(a);
	    
		int max = 0;
		int count = 1;
		int index = 0;
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		 for(int i = 0; i<a.length;i++){
			 Integer element = map.get(a[i]);
			 if(element != null){
				 count++;
				 if(max < count){
					 max = count;
					 index = i;
				 }
			 }else{
				 map.put(a[i], i);
				 count = 1;
			 }
		 }
		 
		 return a[index];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,4,2,3,2,2,2,2};
		System.out.print(majority(a));
	}

}
