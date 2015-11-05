package leetcode;
import java.util.*;

public class LongestTwoDistinct {
	public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Queue<Character> queue = new LinkedList<Character>();
        int i = 0;
        int maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            while (queue.contains(s.charAt(j))) {
                queue.poll();
                i++;
            }
            queue.offer(s.charAt(j));
            maxLength = Math.max(j - i + 1, maxLength);
        }
        return maxLength;
    }
	
	public static void main(String[] args) {
		System.out.print(lengthOfLongestSubstring("eceba"));

	}

}
