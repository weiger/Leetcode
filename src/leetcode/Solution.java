package leetcode;

import java.awt.*;
import java.awt.List;
import java.util.*;

public class Solution {
	    public static int removeDuplicates(int[] A) {
	    	 if(A.length == 0) return 0;
	         
	         Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	         ArrayList<Integer> list = new ArrayList<Integer>();
	         
	         for(int i = 0; i<A.length;i++){
	             Integer element = map.get(A[i]);
	             
	             if(element != null)
	                 map.put(A[i],++element);
	             else
	                 map.put(A[i],1);
	         }
	         
	         Set<Integer> set = map.keySet();
	         for(Integer i : set){
	             if(map.get(i) == 1)
	                 list.add(i);
	             if(map.get(i) >= 2){
	                 list.add(i);
	                 list.add(i);
	             }
	         }
	         
	         //Collections.sort(list);
	         
	        for(int i : list)
	        	System.out.println(i);
	        return list.size();
	    }

	public static void main(String[] args) {
		int[] a = {1,1,1,2,2,3};
		int result = removeDuplicates(a);
		System.out.print(result);

	}

}
