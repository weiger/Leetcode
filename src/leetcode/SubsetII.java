package leetcode;
import java.util.*;
public class SubsetII {

	public static List<List<Integer>> subsets(int[] num){
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();		
		
		Arrays.sort(num);
		
		dfs(num,0,res,list);
		res.add(new ArrayList<Integer>());
		return res;
	}
	
	public static void dfs(int[] num, int start,ArrayList<List<Integer>> res,ArrayList<Integer> list){	
		
		 for(int i=start; i<num.length;i++){
             list.add(num[i]);
             if(!res.contains(list)){
                 res.add(new ArrayList<Integer>(list));
     		}
             dfs(num,i+1, res,list);
             list.remove(list.size()-1);
		 }

	}
	
	public static void main(String[] args) {
		int[] a = {1,2,2};
		List<List<Integer>> res = subsets(a);
		
		for(List<Integer> st : res)
			System.out.println(st);

	}

}
