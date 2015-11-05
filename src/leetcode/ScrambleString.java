package leetcode;
import java.util.*;

public class ScrambleString {
	public static boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        
        if(s1.length() == 1 && s2.length() == 1)
            return s1.charAt(0) == s2.charAt(0);
        
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        
        if(!new String(str1).equals(new String(str2)))
            return false;
       
       if(s1.equals(s2))
            return true;

        for(int i = 1; i < s1.length();i++){
            String ss1 = s1.substring(0,i);
            String ss11 = s1.substring(i);
            
            String ss2 = s2.substring(0,i);
            String ss22 = s2.substring(i);
            
            if(isScramble(ss1,ss2)&&isScramble(ss11,ss22))
                return true;
            
            ss2 = s2.substring(0, s2.length() - i);
            ss22 = s2.substring(s2.length() - i);
            if(isScramble(ss1, ss22) && isScramble(ss11, ss2))
             return true;
        }
        return false;
    }
	public static void main(String[] args) {
		System.out.print(isScramble("great","rgtae"));

	}

}
