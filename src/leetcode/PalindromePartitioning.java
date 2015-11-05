package leetcode;
import java.util.*;
public class PalindromePartitioning {

	// public List<List<String>> partition(String s) {
	   public int partition(String s){
	        List<List<String>> res = new ArrayList<List<String>> ();
	        List<String> item = new ArrayList<String>();
	        
	        
	       // if(s.length()==0||s==null)
	         //    return res;
	        
	         //Arrays.sort(num);
	        
	         dfs(s,0,item,res);
	         int min = res.get(0).size();
	         for(int i = 1; i < res.size();i++){
	             int count = res.get(i).size();
	             if(count < min)
	                min = count;
	         }
	         
	         
	         return min-1;

	    }
	    
	    public void dfs(String s, int start, List<String> item,List<List<String>> res){
	          
	          if(start == s.length()){
	            res.add(new ArrayList<String>(item));
	            return ;
	          }
	       
	          for(int i=start; i<s.length();i++){
	        	  String sub = s.substring(start,i+1);
	              if(isPalindrome(sub)){
	                item.add(sub);
	                dfs(s,i+1, item,res);
	                item.remove(item.size()-1);
	              }
	          }
	     }
	     
	     public boolean isPalindrome(String s){
	         int len = s.length()-1;
	         StringBuffer buffer = new StringBuffer();
	         for(int i = len; i>=0;i--){
	             buffer.append(s.charAt(i));
	         }
	         
	         if(s.equals(buffer.toString()))
	            return true;
	        
	        return false;
	     }
	
	public static void main(String[] args) {
		String s = "aab";
		//String s = "deadeffed";
		PalindromePartitioning pp = new PalindromePartitioning();
		//List<List<String>> strlist = pp.partition(s);
		int strlist = pp.partition(s);
		//for(List<String> ls : strlist)
		//	System.out.println(ls);
		System.out.println(strlist);
	}

}
