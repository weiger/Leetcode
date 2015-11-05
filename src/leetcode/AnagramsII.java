package leetcode;
import java.util.*;

public class AnagramsII {
	
	public static void main(String[] args) {
		String a = "abc";
		String b = "abbc";
		Map<String, String> map = new HashMap<String, String>();
		map.put(a, a);
		//map.put(b, b);
		System.out.println(map.containsKey(b));

	}

}
