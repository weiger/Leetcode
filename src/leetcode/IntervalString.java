package leetcode;

public class IntervalString {
	public static boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s1.length()+s2.length()) 
            return false;    
         
        boolean [][] dp = new boolean [s1.length()+1][s2.length()+1];
        dp[0][0]=true;
        
        for(int i = 1; i<=s1.length(); i++){
            if(s1.charAt(i-1)==s3.charAt(i-1))
                dp[i][0]=true;
        }
        
        for(int i = 1; i<=s2.length() ; i++){
            if(s2.charAt(i-1)==s3.charAt(i-1))
                dp[0][i]=true;
        }
        
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                char c = s3.charAt(i+j-1);
                if(c == s1.charAt(i-1) && dp[i-1][j])
                  dp[i][j] = true;
                  
                if(c == s2.charAt(j-1) && dp[i][j-1])
                  dp[i][j] = true;
            }
        }
        for(int i = 0; i < dp.length;i++){
        	for(int j = 0; j < dp[0].length;j++)
        		System.out.print(dp[i][j] + ",");
        	System.out.print("\n");
        }  
       return dp[s1.length()][s2.length()];
    }
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		
		System.out.println(isInterleave(s1,s2,s3));

	}

}
