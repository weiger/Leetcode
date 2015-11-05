package leetcode;
import java.util.*;

public class TwoSum {
	
	public static void main(String[] args) {
		TwoSumDesign ts = new TwoSumDesign();
		ts.add(1);
		ts.add(3);
		ts.add(5);
		
		System.out.println(ts.find(8));

	}

}

class TwoSumDesign{
	List<Integer> list = new ArrayList<Integer>();
	public void add(int number){
		list.add(number);
	}
	
	public boolean find(int target){
		int len = list.size();
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i = 0; i < len; i++){
			Integer e = map.get(target - list.get(i));
			
			if(e != null){
				return true;
			}else{
				map.put(list.get(i), i);
			}
		}
		return false;
	}
}
