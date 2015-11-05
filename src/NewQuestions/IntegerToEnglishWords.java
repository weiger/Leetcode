package NewQuestions;

public class IntegerToEnglishWords {

	public static String read(int num){
		
		String res = convert(num%1000);
		
		String[] v = {"thousand", "million", "billon"};
		
		for(int i = 0; i < 3; i++){
			num /= 1000;
			
			res = num%1000 != 0 ? convert(num%1000) + " " + v[i] + " " + res : res;
		}
		
		res = res.trim();
		return res.length() == 0 ? "zero" : res;
		
	}
	
	public static String convert(int num){
		String[] digits = {"","one","two","three","four","five","six","seven","eight",
				"nine","ten","eleven", "twenlve","thirteen","fourteen","fifteen","sixteen",
				"seventeen","eighteen","nineteen"};
		String[] decimals = {"","","twenty","thirty","fourty","fifty","sixty","seventy","eighty","ninety"};
		
		int hundred = num/100, dec = num%100,dig = num%10;
		
		StringBuffer sb = new StringBuffer();
		
		if(dec < 20){
			sb.append(digits[dec]);
		}else{
			sb.append(decimals[dec/10]);
			
			if(dig != 0)
				sb.append(" " + digits[dig]);
			else
				sb.append(" ");
		}
		
		if(hundred > 0 && dec > 0){
			sb.insert(0, digits[hundred] + " hundred " + " ");
		}else if(hundred > 0 && dec <= 0){
			sb.insert(0, digits[hundred] + " hundred");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(read(123456789)); //123,456,789
		System.out.println(read(1));
	}

}
