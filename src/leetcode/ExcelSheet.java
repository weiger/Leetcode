package leetcode;

public class ExcelSheet {
	
	public static String convertToTitle(int n) {
        String res="";
        while(n>0){
            res=Character.valueOf((char)('A'+(n-1)%26))+res;
            n=(n-1)/26;
        }
        return res;
    }
	
	
	
	public static void main(String[] args) {
		
		System.out.println(convertToTitle(52));
		
 
	}

}
