package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	public static List<List<Integer>> permutations(int[] num){
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();				
		
		boolean[] flag = new boolean[num.length];
		Arrays.sort(num);
		dfs(num,flag,res,list);

		return res;
	}
	
	public static void dfs(int[] num, boolean[] start,ArrayList<List<Integer>> res,ArrayList<Integer> list){	
		 
		if(list.size() == num.length){
			if(!res.contains(list))
				res.add(new ArrayList<Integer>(list));
  			return ;
  		}
		 for(int i=0; i<num.length;i++){
			 if(!start[i]){
	             list.add(num[i]);  
	             start[i] = true;
	             dfs(num,start, res,list);
	             list.remove(list.size()-1);
	             start[i] = false;
			 }
		 }
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,1};
		List<List<Integer>> res = permutations(a);
		
		for(List<Integer> st : res)
			System.out.println(st);


	}

}
