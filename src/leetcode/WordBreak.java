package leetcode;
import java.util.*;
public class WordBreak {

	public static boolean wordBreak(String s, Set<String> dict) {
        
        if(s == null)
            return false;
        
        Set<String> set = new HashSet<String>();
        StringBuffer buffer = new StringBuffer();
        int start = 0;
        for(int i = 0; i < s.length();i++){
            String sub = s.substring(start,i+1);
            if(dict.contains(sub)&&!set.contains(sub)){  
            	set.add(sub);
               // buffer.append(sub);
                start = i+1;
            }
        }
        
        for(String st : set)
        	buffer.append(st);
        
        if(buffer.length() == s.length())
            return true;
        return false;
        
    }

	public static void main(String[] args) {
		String s = "aaaaaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("aaaa");
		dict.add("aaa");
		
		System.out.println(wordBreak(s,dict));

	}

}
