package leetcode;

import java.util.*;

public class PascalTriangle {

	public static List<List<Integer>> generate(int numRows) {
        
		int num = numRows - 1;
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		
		
		list.add(1);
		res.add(list);
		if(num == 0){
			return res;
		}
		
		list = new ArrayList<Integer>();
		list.add(1);
		list.add(1);
		res.add(list);
		if(num == 1){
			return res;
		}
		
		
		for(int i = 2; i <= num; i++){
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(1);
			int sum = 0;
			for(int j = 1; j < i; j++){
				sum = res.get(i-1).get(j) + res.get(i-1).get(j-1);
				temp.add(sum);		
			}			
			temp.add(1);
			res.add(temp);
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> res = generate(10);
		
		for(List<Integer> i : res)
			System.out.println(i);
	}

}
