package NewQuestions;
import java.util.*;

public class PalindromePermutationII {
	/*
	Given a string s, return all the palindromic permutations (without duplicates) 
	of it. Return an empty list if no palindromic permutation could be form.

	For example:

	Given s = "aabb", return ["abba", "baab"].

	Given s = "abc", return [].

	Hint:

	If a palindromic permutation exists, we just need to generate the first half 
	of the string.
	To generate all distinct permutations of a (half of) string, use a similar 
	approach from: Permutations II or Next Permutation.
	*/
	
	
	public static List<String> getAllPalindromePermutation(String s){
		List<String> res = new ArrayList<String>();
		
		if(s.length() == 0) return res;
		
		int[] count = new int[256];
		int odd = 0;
		
		for(int i = 0; i < s.length(); i++){
			count[s.charAt(i)]++;
			
			if(count[s.charAt(i)]%2 == 1)
				odd++;
			else 
				odd--;				
		}
		
		if(odd > 1) 
			return res;
		
		
		boolean[] visited = new boolean[s.length()];
		StringBuffer sb = new StringBuffer();
		dfs(s.toCharArray(),0,visited,sb,res);
		return res;
	}
	
	public static void dfs(char[] s, int start, boolean[] visited, StringBuffer sb, List<String> res){
		if(sb.length() == s.length){
			if(isPalindrome(sb.toString()) && !res.contains(sb.toString())){
				res.add(sb.toString());
				return ;
			}
		}
		
		for(int i = start; i < s.length; i++){
			if(!visited[i]){
				sb.append(s[i]);
				visited[i] = true;
				dfs(s,start,visited,sb,res);
				sb.deleteCharAt(sb.length()-1);
				visited[i] = false;
			}
		}
	}
	
	public static boolean isPalindrome(String s){
		String sb = new StringBuffer(s).reverse().toString();
		
		return s.equals(sb);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = getAllPalindromePermutation("aabb");
		System.out.println(res);
		
		List<String> res1 = getAllPalindromePermutation("aab");
		System.out.println(res1);
		
		List<String> res2 = getAllPalindromePermutation("ab");
		System.out.println(res2);
		
		List<String> res3 = getAllPalindromePermutation("abc");
		System.out.println(res3);
	}

}
