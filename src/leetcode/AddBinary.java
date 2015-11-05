package leetcode;

public class AddBinary {

	public static String addBinary(String a, String b) {
        
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;
        
        int lenA = a.length()-1;
        int lenB = b.length()-1;
        int count = 0;
        StringBuffer buffer = new StringBuffer();
        
        
        while(lenA >= 0 && lenB >= 0){
             int ca = (int)(a.charAt(lenA) - '0');
             int cb =(int)(b.charAt(lenB) - '0');
            
             int res = count + ca + cb;
            
            if(res == 2){
                buffer.append(0);
                count = 1;
            }else if(res < 2){
                buffer.append(res);
                count = 0;
            }else{
                buffer.append(1);
                count = 1;
            }
            
            lenA--;
            lenB--;
        }
        
        while(lenA >= 0){
            int ca = (int)(a.charAt(lenA) - '0');
            int res = count + ca;
            if(res == 2){
                buffer.append(0);
                count = 1;
            }else{
                buffer.append(res);
                count = 0;
            }
            
            lenA--;
        }
        
         while(lenB >= 0){
            int cb = (int)(b.charAt(lenB) - '0');
            int res = count + cb;
            if(res == 2){
                buffer.append(0);
                count = 1;
            }else{
                buffer.append(res);
                count = 0;
            }
            
            lenB--;
        }
        
        if(count == 1)
            buffer.append(count);
        
        
        
        return buffer.reverse().toString();
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "1010";
		String b = "1011";
		System.out.println(addBinary(a,b));
	}

}
