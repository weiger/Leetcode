package NewQuestions;
import java.util.*;

public class MeetingRooms {

	/*
	 * Given an array of meeting time intervals consisting of start and 
	 * end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could 
	 * attend all meetings.
	
	For example,

	Given [[0, 30],[5, 10],[15, 20]], return false.
	 */
	
	static class Interval {
		int start;
		int end;
		//Interval() { start = 0; end = 0; }
		Interval(int s, int e){ 
			start = s; end = e; 
		}
	 }
	
	public static boolean canAttendMeetings(Interval[] intervals){
		if(intervals.length == 0) 
			return false;
		
		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return i1.start - i2.start;
			}
		});
		
		for(int i = 1; i < intervals.length; i++){
			if(intervals[i-1].end > intervals[i].start)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Interval interval1 = new Interval(0,30);
		Interval interval2 = new Interval(5,10);
		Interval interval3 = new Interval(15,20);
		Interval[] intervals = {interval1, interval2, interval3};
		
		System.out.println(canAttendMeetings(intervals));
	}

}
