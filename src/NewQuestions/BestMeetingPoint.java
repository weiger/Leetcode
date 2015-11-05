package NewQuestions;

import java.util.*;

public class BestMeetingPoint {

	public static Queue<Integer> queue = new LinkedList<Integer>();
	
	static class Point{
		int x, y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	// O(n^3)
	public static int getOptimalDistance(int[][] matrix){
		if(matrix.length == 0)
			return 0;
		
		List<Point> points = new ArrayList<>();
		
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[0].length;j++)
				if(matrix[i][j] == 1){
					Point  p1 = new Point(i,j);
					points.add(p1);
				}
		
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				int sum = 0;
				if(matrix[i][j] == 0){
					for(int p = 0; p < points.size();p++){
						sum += Math.abs(i-points.get(p).x) + Math.abs(j-points.get(p).y);
					}
					min = Math.min(min, sum);
				}
			}
		}
		return min;	
	}
	
	// O(n^2)
	public static int getOptimalDistance2(int[][] matrix){
		if(matrix.length == 0)
			return 0;
		
		List<Integer> row = new ArrayList<>();
		List<Integer> col = new ArrayList<>();
		
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[0].length;j++)
				if(matrix[i][j] == 1){
					row.add(i);
					col.add(j);
				}
		
		return getDistance(row) + getDistance(col);
	}
	
	public static int getDistance(List<Integer> list){
		Collections.sort(list);
		int i = 0, j = list.size()-1;
		
		int res = 0;
		while(i < j){
			res += list.get(j--) + list.get(i++);
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		System.out.println(getOptimalDistance2(matrix));
	}

}
