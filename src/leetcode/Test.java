package leetcode;
import java.util.*;

public class Test {
	 public List<String> generateParenthesis(int n) {
	        List res=new ArrayList(); 
	        String tem=""; 
	        generate(res,tem,0,0,n); 
	        return res;

	    } 
	    public static void generate(List res,String tem,int left,int right,int n) {
	    
	       if(left==n&&right==n){
	           res.add(tem);
	           return;
	        }
	        if(left<right)   return;
	        if(left==n){
	           generate(res,tem+')',left,right+1,n);
	           return;
	        }
	        generate(res,tem+'(',left+1,right,n);//计算左边的数目和右边的数目
	        generate(res,tem+')',left,right+1,n);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test ts = new Test();
		 ts.generateParenthesis(3);
		
	}

}
