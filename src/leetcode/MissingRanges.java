package leetcode;
import java.util.*;

public class MissingRanges {

	public static List<String> missingRange(int[] num, int start,int end){
		List<String> res = new ArrayList<String>();
		
		for(int i = 0; i < num.length;i++){
			int curr = (i == num.length)? end+1:num[i];
			
			if(curr - start >= 2){
				res.add(getRange(start+1,curr-1));
			}
			
			start = curr;
		}
		return res;
		
	}
	
	public static String getRange(int start,int end){
		return start==end? String.valueOf(start) : String.valueOf(start) + "->"+ String.valueOf(end);
	}
	
	public static void main(String[] args) {
		int[] num = {0,1,3,50,75,99};
		List<String> list = missingRange(num,0,99);
		for(String s:list)
			System.out.println(s);

	}

}
