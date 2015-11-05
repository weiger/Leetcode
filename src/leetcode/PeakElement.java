package leetcode;

public class PeakElement {
	public int findPeakElement(int[] num){
		int index = 0,max = 0;
		for(int i = 1; i < num.length; i++){
			if(num[i-1] < num[i]){
				max = i;
			    if(num[index] <num[max])
			    	index = max;
			}
		}
		return index;
		
	}
	public static void main(String[] args) {
		PeakElement pe = new PeakElement();
		int[] num = {1,2,3,4,2};
		System.out.println(pe.findPeakElement(num));

	}

}
