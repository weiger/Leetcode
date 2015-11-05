package NewQuestions;
import java.util.*;

public class Flatten2DVector {

	public List<Integer> list;
	public int index;
	
	public Flatten2DVector(int[][] nums){
		list = new ArrayList<>();
		for(int i = 0; i < nums.length; i++){
			for(int j = 0; j < nums[i].length;j++)
				list.add(nums[i][j]);
		}
		index = 0;
	}
	
	public int next(){
		
		return list.get(index++);
	}
	
	public boolean hasNext(){
		return index < list.size();	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int[][] nums = {{1,2},{3},{4,5,6,7}};
			Flatten2DVector instance = new Flatten2DVector(nums);
			
			while(instance.hasNext()){
				System.out.println(instance.next());
			}
	}

}
