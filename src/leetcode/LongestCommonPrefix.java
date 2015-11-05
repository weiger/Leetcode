package leetcode;

public class LongestCommonPrefix {
	
	public static String longestCommonPrefix(String[] strs) {
        
        String pivot = strs[0];
        
        
        for(int i = 1; i < strs.length; i++){
        	int t = 0, p = 0, index = 0;
        	String res = "";
        	String element = strs[i];
        	
        	while(t < pivot.length() && p < element.length()){
        		if(pivot.charAt(index) == element.charAt(index))
        			res += pivot.charAt(index);
        		else
        			break;
        		index++;
    			t++;
    			p++;	
        	}
        		
        	pivot = res;
        }
        
        return pivot;  
    }
	
	public static void main(String[] args) {
		String[] s = {"aaacdesf","aaacdeeeeee", "aaacd"};
		System.out.println(longestCommonPrefix(s));

	}

}
