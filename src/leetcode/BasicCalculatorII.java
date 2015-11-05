package leetcode;
import java.util.*;

public class BasicCalculatorII {

	public static int calculator(String s){
		
		s = s.trim();
		
		if(s.length() == 0)
			return 0;
		
		int res = 0;
		Stack<Integer> stack = new Stack<>(); // keep all the values which is the result calculated
		
		char sign = '+';
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == ' ')
				continue;
			else if(!Character.isDigit(s.charAt(i))){
				sign = s.charAt(i);
			}else if(Character.isDigit(s.charAt(i))){
				int j = i+1;
				int num = s.charAt(i)-'0';
				
				while(j < s.length() && Character.isDigit(s.charAt(j))){
					num = num*10+(s.charAt(j)-'0');
					j++;
				}
				
				switch(sign){
				    case '+': stack.push(num);break;
				    case '-': stack.push(-num);break;
				    case '*': stack.push(stack.pop()*num);break;
				    case '/': stack.push(stack.pop()/num);break; 
				}
				
				i = j-1;
			}
		}
		
		for(int i : stack)
			res += i;
		
		return res;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculator(" 3+5 / 2 "));
		System.out.println(calculator(" 3/2 "));
		System.out.println(calculator("3+2*2"));
	}

}
