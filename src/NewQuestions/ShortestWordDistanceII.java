package NewQuestions;

import java.util.*;

public class ShortestWordDistanceII {

	
	/*This is a follow up of Shortest Word Distance. 
	 * The only difference is now you are given the list of 
	 * words and your method will be called repeatedly many times 
	 * with different parameters. How would you optimize it? 
	 
	Design a class which receives a list of words in the constructor, 
	and implements a method that takes two words word1 and word2 and 
	return the shortest distance between these two words in the list. 

	For example, 
	Assume that words = ["practice", "makes", "perfect", "coding", "makes"]. 

	Given word1 = “coding”, word2 = “practice”, return 3. 
	Given word1 = "makes", word2 = "coding", return 1. 

	Note: 
	You may assume that word1 does not equal to word2, and word1 and word2 
	are both in the list. 
	 */	
	
	// 两步；1.将所有的word和对应的index存入hashmap中  2. 声明distance方法，计算最小差 o(n^2)
	
	Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
	
	public ShortestWordDistanceII(String[] words){
		for(int i = 0; i < words.length; i++){
			if(map.containsKey(words[i]))
				map.get(words[i]).add(i);
			else{
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(words[i], list);
			}
		}
	}
	
	public int shortestII(String word1, String word2){
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		
		int distance = list1.size() > list2.size() ? list1.size()+1 : list2.size()+1 ;
		
		for(int i = 0; i < list1.size(); i++){
			for(int j = 0; j < list2.size(); j++){
				distance = Math.min(distance, Math.abs(list1.get(i)-list2.get(j))); 
			}
		}
		return distance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		
		ShortestWordDistanceII distance = new ShortestWordDistanceII(words);
		
		System.out.println(distance.shortestII("makes", "coding"));
	}

}
