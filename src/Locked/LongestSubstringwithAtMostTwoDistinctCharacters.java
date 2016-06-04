package Locked;
import java.util.*;

public class LongestSubstringwithAtMostTwoDistinctCharacters {

	/*
	Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

	For example, Given s = “eceba”,

	T is "ece" which its length is 3.
	*/
	
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() == 0) return 0;
        
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        
        int pre = 0, maxLen = 0;
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
                
                while(map.size() > 2){
                    char cc = s.charAt(pre++);
                    
                    if(map.get(cc) > 1)
                        map.put(cc, map.get(cc)-1);
                    else
                        map.remove(cc);
                }
            }
            maxLen = Math.max(maxLen, i-pre+1);
        }
        
        return maxLen;
    }
	
	public int lengthOfLongestSubstringTwoDistinctTwoPointers(String s) {
        int start = 0, j = -1, maxLen = 0;
        String res = "";
        for (int k = 1; k < s.length(); k++) {
        	
        	// duplicate characters
            if (s.charAt(k) == s.charAt(k - 1)) continue;
            
            // are not the same char
            // 1) 
            if (j >= 0 && s.charAt(j) != s.charAt(k)) {
                maxLen = Math.max(k - start, maxLen);
                res = s.substring(start,k);
                start = j + 1; 
            }
            // 2)  move j to the previous position of current index
            j = k - 1;  
        }
        return Math.max(s.length() - start, maxLen);
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
