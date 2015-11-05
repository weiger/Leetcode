package leetcode;

public class RegularExpressionMatching {

	public static boolean isMatch(String s, String p) {
        int height = s.length(),width = p.length();
        boolean[][] dp = new boolean[height + 1][width + 1];
        dp[0][0] = true;
        for(int i = 1; i <= width; i++){
            if(p.charAt(i - 1) == '*') dp[0][i] = dp[0][i - 2];
        }
        for(int i = 1; i <= height; i++){
            for(int j = 1; j <= width; j++){
                char sChar = s.charAt(i - 1);                
                char pChar = p.charAt(j - 1);
                if(sChar == pChar || pChar == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(pChar == '*'){
                    if(sChar != p.charAt(j - 2) && p.charAt(j - 2) != '.'){
                        dp[i][j] = dp[i][j - 2];
                    }else{
                        dp[i][j] =  dp[i][j - 2] | dp[i - 1][j];
                    }
                }
            }
        }
        
        for(int i = 0; i <= height;i++){
        	for(int j = 0; j <= width;j++){
        		System.out.print(dp[i][j] + "   ");
        	}
        	System.out.println();
        }
        
        return dp[height][width];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isMatch("aab","c*a*b");
	}

}
