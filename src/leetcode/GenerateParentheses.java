package leetcode;
import java.util.*;

public class GenerateParentheses {
	 public static List<String> generateParenthesis(int n){
		 List<String> res = new ArrayList<String>();
		 if(n == 0) return res;
		 String s = "";
		 dfs(n,s,0,0,res);
		 return res;
	 }
	 
	 public static void dfs(int n, String s, int left, int right, List<String> res){
		 if(left == n && right == n){
			 	res.add(s);
			 	return ;
		 }
		 if(left < right) return ;
		 
		 if(left == n){
			 dfs(n,s+")",left, right+1,res);
			 return ;
		 }
		 
		 dfs(n,s+"(",left+1,right,res);
		 dfs(n,s+")",left,right+1,res);
	 }
	 
	public static void main(String[] args) {
		int n = 4;
		List<String> s = generateParenthesis(n);
		for(String ss : s)
			System.out.println(ss);

	}

}
