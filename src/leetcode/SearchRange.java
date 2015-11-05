package leetcode;
import java.util.*;
public class SearchRange {
	public int[] searchRange(int[] A, int target) {
        List<Integer> index = new ArrayList<Integer>();
        searchIndex(A,0,A.length-1,target,index);
        int[] B = new int[2];
        
        if(index.size() != 0){
            B[0] = index.get(0);
            B[1] = index.get(index.size()-1);
            return B;
        }
        
        return B;
    }
    
    public void searchIndex(int[] num, int start,int end,int target, List<Integer> list){
        while(start <= end){
            int mid = (start+end)/2;
            
            if(num[mid] == target){
                list.add(mid);
                searchIndex(num,start,mid-1,target,list);
                searchIndex(num,mid+1,end,target,list);
                break;
            }else if(num[mid] < target){
                start = mid+1;
            }else{
                end = mid -1;
            }
        }
        Collections.sort(list);
    }
	public static void main(String[] args) {
		int[] A = {5, 7, 7, 8, 8, 10};
		SearchRange sr = new SearchRange();
		int[] res = new int[2];
		res = sr.searchRange(A, 8);
		for(int i : res)
			System.out.println(i);
	}

}
