package leetcode;
import java.util.*;
public class Subsets {

	public static List<List<Integer>> subset(int[] num){
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		dfs(num,0,res,list);
		res.add(list);
		
		return res;
	}
	
	public static void dfs1(int[] num,int start,ArrayList<List<Integer>> res,ArrayList<Integer> list){
		if (start<num.length) {
			dfs1(num, start+1, res, list);
			list.add(num[start]);
			dfs1(num, start+1, res, list);
			list.remove(list.size()-1);
		}
		else {
			res.add(new ArrayList<Integer>(list));
		}
	}
	
	public static void dfs(int[] num,int start,ArrayList<List<Integer>> res,ArrayList<Integer> list){
		
		for(int i = start; i<num.length;i++){
			list.add(num[i]);			
			res.add(new ArrayList<Integer>(list));
			dfs(num,i+1,res,list);
			list.remove(list.size()-1);
			
		}
	}
	
	public static void main(String[] args) {
		int[] a = {0,1,2};
		List<List<Integer>> res = subset(a);
		
		for(List<Integer> st : res)
			System.out.println(st);

	}

}
