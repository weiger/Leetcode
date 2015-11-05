package leetcode;
import java.util.*;

public class LargestNumber {

	public static String largestNumber(int[] num){
		if(num.length == 0)
			return "";
		
		List<String> list = new ArrayList<String>();
		StringBuffer buffer = new StringBuffer();
		
		for(int i : num)
			list.add(String.valueOf(i));
		
		Collections.sort(list, new StringComparision());
		
		for(String l : list)
			buffer.append(l);
		
		String res = buffer.toString();
		
		if(res.length() > 0 && res.charAt(0) == '0')
			return "0";
		
		return res;
		
	}
	
	
	
	public static void main(String[] args) {
		int[] a = {3, 30, 34, 5, 9};
		String res = largestNumber(a);
		System.out.print(res);
	}

}

class StringComparision implements Comparator<String>{
	 public int compare(String a, String b){
		 if(a.length() == b.length())
			 return b.compareTo(a);
		 else{
			 String ab = a + b;
			 String ba = b + 1;
			 
			 return ba.compareTo(ab);
		 }
	 }
}
