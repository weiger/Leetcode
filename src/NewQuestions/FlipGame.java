package NewQuestions;
import java.util.*;

public class FlipGame {

	public static List<String> flip(String s){
		
		List<String> res = new ArrayList<>();
		
		if(s.length() == 0) return res;
		
		for(int i = 0; i < s.length()-1; i++){
			if(s.subSequence(i, i+2).equals("++")){
				StringBuffer sb = new StringBuffer();
				if(i == 0){
					sb.append("--").append(s.substring(i+2));
				}else if(i < s.length()-1){
					sb.append(s.substring(0,i)).append("--").append(s.substring(i+2));
				}
				res.add(sb.toString());
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(flip("++++"));
		System.out.println(flip("-+++"));
		System.out.println(flip("+--+"));
		System.out.println(flip("+++-"));
	}

}
