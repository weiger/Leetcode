package NewQuestions;

public class StrobogrammaticNumber {

	/*
	A strobogrammatic number is a number that looks the same 
	when rotated 180 degrees (looked at upside down).

	Write a function to determine if a number is strobogrammatic. 
	The number is represented as a string.
	
	For example,

	the numbers "69", "88", and "818" are all strobogrammatic.
	*/
	
	
	public static boolean isStrobogrammatic(String num){
		
		for(int i = 0; i <= num.length()/2; i++){
			char c1 = num.charAt(i);
			char c2 = num.charAt(num.length()-1-i);
			
			if(!getStrobogrammatic(c1,c2))
				return false;
		}
		return true;
	}
	
	public static boolean getStrobogrammatic(char a, char b){
		switch(a){
		case '1' : return b == '1';
		case '6' : return b == '9';
		case '8' : return b == '8';
		case '9' : return b == '6';
		case '0' : return b == '0';
		default : return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isStrobogrammatic("69"));
	}

}
