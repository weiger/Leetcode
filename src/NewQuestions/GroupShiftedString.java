package NewQuestions;
import java.util.*;

public class GroupShiftedString {

	public static List<List<String>> groupString(String[] str){
		List<List<String>> res = new ArrayList<>();
		Map<Integer, List<String>> map = new HashMap<>();
		
		for(String s : str){
			int key = 0;
			
			for(int i = 1; i < s.length(); i++){
				key += (s.charAt(i)-s.charAt(i-1)+26)%26; // calculate the total difference between each two consecutive characters
			}
			
			if(!map.containsKey(key)){
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(key, list);
			}else{
				map.get(key).add(s);
			}
		}
		
		for(List<String> list : map.values()){
			Collections.sort(list);
			res.add(list);
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		System.out.println(groupString(str));
	}

}
