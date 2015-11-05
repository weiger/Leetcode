package NewQuestions;

import java.util.*;

public class MeetingRoomII {

	 static class Interval {
	    int start;
	    int end;
	    Interval() { start = 0; end = 0; }
	    Interval(int s, int e) { start = s; end = e; }
	}
	 
	 static Comparator<Interval> comparator = new Comparator<Interval>() {
        public int compare(Interval a, Interval b) { 
            return a.start - b.start;
        }
	 };
	    
	    // Method 1
	    public static int minMeetingRooms1(Interval[] intervals) {
	        if (intervals == null || intervals.length == 0)
	            return 0;
	        Arrays.sort(intervals, comparator);
	        int N = intervals.length;
	        int rooms = 1;
	        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	        minHeap.offer(intervals[0].end);
	        for (int i = 1; i < N; i++) {
	            if (intervals[i].start < minHeap.peek()) {
	                rooms++;
	            } else {
	                minHeap.poll();                
	            }
	            minHeap.offer(intervals[i].end);
	        }
	        return rooms;
	    }
	    
	    // Method 2: https://leetcode.com/discuss/50793/my-python-solution-with-explanation
	    public int minMeetingRooms(Interval[] intervals) {
	        if (intervals == null || intervals.length == 0)
	            return 0;
	        int N = intervals.length;
	        int[] starts = new int[N];
	        int[] ends = new int[N];
	        for (int i = 0; i < intervals.length; i++) {
	            starts[i] = intervals[i].start;
	            ends[i] = intervals[i].end;
	        }
	        Arrays.sort(starts);
	        Arrays.sort(ends);
	        int e = 0, rooms = 0, available = 0;
	        for (int start : starts) {
	            while (ends[e] <= start) {
	                available++;
	                e++;
	            }
	            if (available > 0)
	                available--;
	            else
	                rooms++;
	        }
	        return rooms;
	    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i1 = new Interval(1,5);
		Interval i2 = new Interval(8,9);
		Interval i3 = new Interval(8,9);
		
		Interval[] intervals = {i1,i2,i3};
		
		System.out.println(minMeetingRooms1(intervals));
		
	}

}
