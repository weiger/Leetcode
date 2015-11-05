package leetcode;
import java.util.*;

public class BasicCalculator {

	public static int calculate(String s) {
        
		if(s.length() == 0) return 0;
		 
		Stack<Integer> stack = new Stack<Integer>(); // keep sign whether is positive or negative
		stack.push(1);
		stack.push(1);
		
		int res = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' ')
				continue;
			else if(Character.isDigit(s.charAt(i))){
				int j = i+1, num = s.charAt(i)-'0';
				
				while(j < s.length() && Character.isDigit(s.charAt(j))){
					num = num*10+(s.charAt(j)-'0');
					j++;
				}
				
				res += stack.pop()*num;
				i = j-1;
			}else if(s.charAt(i) == '+' || s.charAt(i) == '('){
				stack.push(stack.peek());
			}else if(s.charAt(i) == '-'){
				stack.push(stack.peek()*(-1));
			}else if(s.charAt(i) == ')'){
				stack.pop();
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "(1+(4+5+2)-3)+(6+8)";
		String c = "1 - 11";
		String str = " 2-1 + 2 ";
		System.out.println(calculate(str));
	}

}
