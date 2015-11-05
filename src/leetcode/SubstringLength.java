package leetcode;

import java.util.*;

public class SubstringLength {

	public static int Length(String s){
		
		if(s.length() == 0) return 0;
		
		int start = 0;
		int length = 0;
		
		Map<Character, Integer> ht = new HashMap<Character, Integer>();
		
		for(int i = 0; i<s.length();i++){
			
			Integer index = ht.get(s.charAt(i));
			
			if(index != null){
				if(index >= start){
					length = Math.max(length, i-start);
					start = index+1;
				}
			}
			
			ht.put(s.charAt(i), i);
			
		}
		
		length = Math.max(length, s.length()-start);
		
		return length;
	}
	
	
	
	public static void main(String[] args) {
		
		int length  = Length("qopubjguxhxdipfzwswybgfylqvjzhar");//substring : bgfylqvjzhar
		System.out.print(length);

	}

}
