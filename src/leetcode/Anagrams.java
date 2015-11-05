package leetcode;

import java.util.*;

public class Anagrams {

	 public static List<String> anagrams(String[] strs) {
	       List<String> list = new ArrayList<String>();
	       
	       if(strs == null)
	            return list;
	        
	        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();  
	        
	        for(int i = 0; i<strs.length; i++){
	            char[] element = strs[i].toCharArray();
	            Arrays.sort(element);
	            String str = new String(element);
	            
	            if(map.containsKey(str)){
	                map.get(str).add(strs[i]);
	            }else{
	                ArrayList<String> temp = new ArrayList<String>();
	                temp.add(strs[i]);
	                map.put(str,temp);
	            }
	        }
	        
	        Iterator ite = map.values().iterator();
	        while(ite.hasNext()){
	            ArrayList<String> item = (ArrayList<String>)ite.next(); 
	            if(item.size()>1){
	                list.addAll(item);
	            }
	        }
	       return list; 
	    }

	
	public static void main(String[] args) {
		
		String[] S = {"abc","bca","bac","bbb","bbca","abcb"};
		List<String> list = anagrams(S);
		
		for(String str : list)
			System.out.println(str);

	}

}
