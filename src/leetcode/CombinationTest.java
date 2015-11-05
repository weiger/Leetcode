package leetcode;
import java.util.*;
public class CombinationTest {
	 public List<List<Integer>> combine(int n, int k) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        List<Integer> list = new ArrayList<Integer>();
	        
	        dfs(n,k,1,res,list);
	        return res;
	    }
	    // n =4 k =2
	    public void dfs(int n, int k,int start, List<List<Integer>> res,List<Integer> list){
	        
	        
	        if(list.size() == k){
	            res.add(new ArrayList<Integer>(list));
	            return ;
	        }
	        
	        for(int i = start; i <= n; i++){
	            list.add(i);
	            dfs(n,k,i+1,res,list);
	            list.remove(list.size()-1);
	        }
	    }
	public static void main(String[] args) {
		CombinationTest ct = new CombinationTest();
		
		List<List<Integer>> test = ct.combine(4, 2);
		for(List<Integer> e : test)
			System.out.println(e);

	}

}
