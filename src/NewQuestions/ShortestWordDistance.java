package NewQuestions;

public class ShortestWordDistance {

	/*
	 * Given a list of words and two words word1 and word2, 
	 * return the shortest distance between these two words in the list.
	   For example,
	   Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
       Given word1 = "coding", word2 = "practice", return 3. 
       Given word1 = "makes", word2 = "coding", return 1.
	 * 
	 * 
	 * You may assume that word1 does not equal to word2, 
	 * and word1 and word2 are both in the list.
	 */
	
	
	public static int shortestDistance(String[] words, String word1, String word2){
		if(words.length == 0) return 0;
		if(word1.length() == 0 || word2.length() == 0) return 0;
		
		int index1 = -1, index2 = -1;
		int distance = words.length+1;;
		
		for(int i = 0; i < words.length; i++){
			if(words[i] == word1)
				index1 = i;
			
			if(words[i] == word2)
				index2 = i;
			
			if(index1 != -1 && index2 != -1)
				distance = Math.min(distance, Math.abs(index1 - index2));
		}
		return distance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		String[] word = new String[0];
		System.out.println(shortestDistance(words,"coding","practice"));
		System.out.println(shortestDistance(words,"coding","makes"));
		System.out.println(shortestDistance(words,"","practice"));
		System.out.println(shortestDistance(words,"coding",""));
		System.out.println(shortestDistance(words,"",""));
		System.out.println(shortestDistance(word,"coding","practice"));
	}

}
