package leetcode;

import java.util.Stack;

public class LongestValidParenthese {

	public static int longestValidParentheses(String s) {
        
        if(s == null) return 0;
        
        Stack stack = new Stack();
        
        int length = s.length();
        
        StringBuffer buffer = new StringBuffer();
        
        for(int i = 0; i< length; i++){
            
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            
            if(s.charAt(i) == ')' && !stack.isEmpty()){
                buffer.append(stack.pop());
                buffer.append(')');
            }
        }
        
        return buffer.length();
        
    }
	
	public static void main(String[] args) {
		System.out.print(longestValidParentheses("(()"));

	}

}
