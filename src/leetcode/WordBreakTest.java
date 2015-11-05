package leetcode;
import java.util.*;
public class WordBreakTest {
	public static boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0)
            return false;
        
       // List<String> dictlist = new ArrayList<String>(dict);
        
        /*
        int len = 0;
        for(int i = 0; i < dictlist.size();i++){
            if(s.contains(dictlist.get(i))){
                len += dictlist.get(i).length();
                dictlist.remove(i);
                i--;
            }
        }
        */
        
        boolean[] flag = new boolean[s.length()+1];
        flag[0] = true;
        
        for(int i = 0; i < s.length();i++){
            StringBuffer sub = new StringBuffer(s.substring(0,i+1));
            for(int j = 0; j <= i; j++){
                if(flag[j] && dict.contains(sub.toString())){  
                  flag[i+1] = true;
                  break;
                }
                sub.deleteCharAt(0);
            }
        }
        
        return flag[s.length()];

    }
	public static void main(String[] args) {
		/*
		String s = "leetcode";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		*/
		/*
		String s = "bb";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("bbb");
		dict.add("bbbb");
*/
		String s = "aaaaaaa";
		Set<String> dict = new HashSet<String>();
		dict.add("aaaa");
		dict.add("aaa");
		
		System.out.println(wordBreak(s, dict));

	}

}
