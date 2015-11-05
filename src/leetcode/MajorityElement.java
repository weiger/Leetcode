package leetcode;

import java.util.*;

public class MajorityElement {
	
	public static int majorityElement(int[] num) {
        
		Arrays.sort(num);
		
		int count = 1;
		int max = 0;
		int index = 0;
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i = 0; i<num.length;i++){			
			Integer element = map.get(num[i]);
			
			if(element != null){
				count++;
				if(max < count){
					max = count;
					index = i;
				}
			}else{
				map.put(num[i], i);	
				count = 1;
			}			
		}
		
		return num[index];
    }
	
	public static void main(String[] args) {
		
		int[] array = {1,2,3,4,2,2,3,5,3,4,3,3,5};
		System.out.print(majorityElement(array));

	}

}
