package leetcode;

public class practice {
	public static int divide(int dividend, int divisor) {
		long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        long result=0;
        
        while (a>=b){
            long c=b;
            int i=0;
            while(c<=a){
                a=a-c;
                c=c<<1;
                result+=1<<i;
                i++;
            }
            
        }
        if (dividend<0&&divisor>0||dividend>0&&divisor<0){
            result=-result;
        }
        return (int)result;
        
    }
	public static void main(String[] args) {
		
		System.out.print(divide(20,-4));

	}

}
