package NewQuestions;
import java.util.*;

public class PalindromePermutationI {

	/*
	 * Given a string, determine if a permutation of the string could 
	 * 	form a palindrome.

		For example,
		"code" -> False, "aab" -> True, "carerac" -> True. 
	 */
	public static boolean canPermutePalindrome(String s) {
        if(s.length() == 0)
        	return false;
        
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        
        for(int i = 0; i < s.length(); i++){
        	Integer elem = map.get(s.charAt(i));
        	if(elem != null)
        		map.remove(s.charAt(i));
        	else
        		map.put(s.charAt(i),1);
        }
        if(map.size() > 1) return false;
        
        return true;
    }
	
	// 利用count array統計每個字數出現的次數, 出現奇數次的最多只能有一個
		public static boolean canPermutePalindrome2(String s){
			if(s.length() == 0 || s.length() == 1)
				return true;
			
			int odd = 0;
			int[] count = new int[256];
			for(int i = 0; i < s.length(); i++){
				count[s.charAt(i)]++;
		
				if(count[s.charAt(i)]%2 == 1)
					odd++;
				else
					odd--;
			}
			
			return (odd == 0 || odd == 1) ? true : false;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canPermutePalindrome("carerac"));
		System.out.println(canPermutePalindrome("aab"));
		System.out.println(canPermutePalindrome("code"));
	}

}
