package leetcode;
import java.util.*;
public class PermutationSequence {
	public static String getPermutation(int n, int k) {

	      List<List<Character>> res = new ArrayList<List<Character>>();
	      List<Character> list = new ArrayList<Character>();
	      
	      boolean[] flag = new boolean[n];
	      
	      dfs(n,res,list,flag);
	 
	      StringBuffer buff = new StringBuffer();
	      for(int i = 0; i < res.get(k-1).size();i++)
	        buff.append(res.get(k-1).get(i));
	      
	      return buff.toString();
	        
	    }
	    
	    public static void dfs(int n,List<List<Character>> res,List<Character> list,boolean[] flag){
	        if(list.size() == n){
	            res.add(new ArrayList<Character>(list));
	            return ;
	        }
	        
	        for(int i = 1; i<=n;i++){
	            char c = (char)(i+'0');
	            if(!flag[i-1]){
	                list.add(c);
	                flag[i-1] = true;
	                dfs(n,res,list,flag);
	                list.remove(list.size()-1);
	                flag[i-1] = false;
	            }
	        }
	    }
	public static void main(String[] args) {
		int n = 3;
		String s = getPermutation(9,278082);
		System.out.print(s);
		

	}

}
