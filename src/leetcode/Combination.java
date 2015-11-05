package leetcode;
import java.util.*;
public class Combination {
	 public  List<List<Integer>> combinationSum(int[] candidates,int target) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        List<Integer> list = new ArrayList<Integer>();
	        
	        Arrays.sort(candidates);
	        
	        dfs(candidates,0,target,res,list);
	        return res;
	    }
	    
	    public  void dfs(int[] num,int start,int target,List<List<Integer>> res,List<Integer> list){
	        if(target < 0)
	            return ;
	        
	        if(0 == target){
	            if(!res.contains(list))
	                res.add(new ArrayList<Integer>(list));
	            return ;
	        }
	        
	        for(int i = start; i < num.length;i++){
	            list.add(num[i]);
	            int newsum = target - num[i];
	            dfs(num,i,newsum,res,list);
	            list.remove(list.size()-1);
	        }
	    }
	public static void main(String[] args) {
		
		Combination cc = new Combination();
		
		int[] s = {1,2,3,4,6,12};
		
		List<List<Integer>> res = cc.combinationSum(s,9);
		
		for(List<Integer> list : res)
			System.out.println(list);

	}

}
