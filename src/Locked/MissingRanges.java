package Locked;
import java.util.*;

public class MissingRanges {

	/*Given a sorted integer array where the range of elements are [lower, upper] 
	 * inclusive, return its missing ranges.
	 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, 
	 * return ["2", "4->49", "51->74", "76->99"].	
	 */
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        
        int pre = lower-1;
        
        for(int i = 0; i <= nums.length; i++){
            int cur = i == nums.length ? upper+1 : nums[i];
            if(cur - pre >= 2){
                res.add(getRange(pre+1,cur-1));
            }
            pre = cur;
        }
        return res;
    }
    
    public String getRange(int pre, int end){
        
        return pre == end ? String.valueOf(pre) : String.valueOf(pre) + "->" + String.valueOf(end);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
