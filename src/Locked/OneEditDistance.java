package Locked;

public class OneEditDistance {

	/* 
	 * Given two strings S and T, determine if they are both one edit distance apart.
	 */
	
	public boolean isOneEditDistance(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        
        if(sLen == 0) return tLen == 1;
        if(tLen == 0) return sLen == 1;
        
        if(sLen > tLen)
            return isOneEditDistance(t,s);
        
        int diff = tLen - sLen;
        
        // 长度差大于1
        if(diff > 1) return false;
        
        int i = 0;
        
        while(i < sLen && s.charAt(i) == t.charAt(i)){
            i++;
        }
        
        // 长度差等于1
        if(i == sLen) return i == tLen-1;  // a, ab
        
        // 长度差等于0
        if(diff == 0) i++;     // adcde, abcde   true
        
        while(i < sLen && s.charAt(i) == t.charAt(i+diff))
            i++;
            
        return i == sLen;    // a, ba true
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
