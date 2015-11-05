package NewQuestions;
import java.util.*;

public class EncodeAndDecodeStrings {

	/*
	 * Design an algorithm to encode a list of strings to a string. 
	 * The encoded string is then sent over the network and is decoded back 
	 * to the original list of strings.
	 * 
	 * https://aquahillcf.wordpress.com/2015/09/06/leetcode-encode-and-decode-strings/
	 */
	
	// Encodes a list of strings to a single string. 
    public String encode(List<String> strs) { 
        if(strs == null || strs.size() == 0) return ""; 
        StringBuilder sb = new StringBuilder(); 
        for(String str : strs){ 
            sb.append(str.length()).append("#").append(str).append("#"); 
        } 
        System.out.println(sb.toString());  
        return sb.toString(); 
    } 
  
    // Decodes a single string to a list of strings. 
    public List<String> decode(String s) { 
        List<String> list = new ArrayList<String>(); 
        if(s == null || s.length() ==0) return list; 
          
        int i = 0; 
        int start = 0; 
        while(start < s.length() && (i = s.indexOf("#",start))!= -1){  // 以start为起点的第一个出现＃的index
            int len = Integer.parseInt(s.substring(start, i)); 
            i++; 
            String str = s.substring(i, i+len); 
            list.add(str); 
            start = i+len+1; 
        } 
        return list; 
    } 

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("abc"); list.add("$$#$");list.add("bde234f@#");
		EncodeAndDecodeStrings instance = new EncodeAndDecodeStrings();
		String encond = instance.encode(list);
		System.out.print(instance.decode(encond));
	}

}
