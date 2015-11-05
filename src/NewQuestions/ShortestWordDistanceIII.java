package NewQuestions;

import java.util.*;

public class ShortestWordDistanceIII {

	/*Given a list of words and two words word1 and word2, 
	 * return the shortest distance between these two words in the list.
	 * 
	 * word1 and word2 may be the same and they represent two individual words 
	 * in the list.

	For example,

	Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

	Given word1 = "makes", word2 = "coding", return 1. 
	Given word1 = "makes", word2 = "makes", return 3.

	Note: You may assume word1 and word2 are both in the list.
	 */

	public static int shortestWordDistanceIII(String[] words, String word1, String word2) {
		Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
		
		for(int i = 0; i < words.length; i++){
			if(map.containsKey(words[i]))
				map.get(words[i]).add(i);
			else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(words[i], list);
			}	
		}
		
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		
		int distance = list1.size() > list2.size() ? list1.size()+1 : list2.size()+1;
		
		if(word1.equals(word2)){
			for(int i = 1; i < list1.size();i++){
				distance = Math.min(list1.get(i)-list1.get(i-1), distance);
			}
		}else{
			for(int i = 0; i < list1.size();i++){
				for(int j = 0; j < list2.size(); j++){
					distance = Math.min(Math.abs(list1.get(i)-list2.get(j)), distance);
				}
			}
		}
		return distance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String[] word = new String[0];
		System.out.println(shortestWordDistanceIII(words,"coding","practice"));
		System.out.println(shortestWordDistanceIII(words,"coding","makes"));
		System.out.println(shortestWordDistanceIII(words,"makes","makes"));
	}

}
