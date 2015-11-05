package Locked;

public class ReverseWordsinaStringII {

	/*
	 * Given an input string, reverse the string word by word. 
	 * A word is defined as a sequence of non-space characters.
	 * The input string does not contain leading or trailing spaces 
	 * and the words are always separated by a single space.

		For example,
		Given s = "the sky is blue", return "blue is sky the".
	 */
	
	public void reverseWords(char[] s) {
        if(s.length == 0) return ;
        
        reverse(s,0,s.length-1);
        
        int pre = 0;
        
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                reverse(s,pre,i-1);
                pre = i+1;
            }
        } 
        
        reverse(s,pre,s.length-1);
    }
    
    public void swap(char[] s, int i, int j){
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
    
    public void reverse(char[] s, int i, int j){
        while(i <= j){
            swap(s,i++,j--);
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseWordsinaStringII instance = new ReverseWordsinaStringII();
		String words = "the sky is blue";
		char[] s = words.toCharArray();
		instance.reverseWords(s);
		System.out.println(new String(s));
	}

}
