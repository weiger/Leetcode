package leetcode;

public class ReverseStringII {
	public static void reverseWords(char[] s) {
		
       int len = s.length-1, start = 0;
       boolean space = false;
       for(char e : s){
    	   if(e == ' '){
    		   space = true;
    		   break;
    	   }
       }
       if(space){
	       for(int i = 0; i <= len; i++){
	    	   if(s[i] == ' '){
	    		   swap(s,start,i-1);
	    		   start = i+1;
	    	   }
	    	   if(i==len){
	    		   swap(s,start,len);
	    	   }
	       }
	       
	    	  swap(s,0,len);

       }
      
    }
	
	public static void swap(char[] s, int start, int end){
		while(start <= end){
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		char[] c = {'t','h','e','s','k','y','i','s','b','l','u','e'};
		char[] a = "hello world!".toCharArray();
		reverseWords(a);
		System.out.println(new String(a));
	}

}
