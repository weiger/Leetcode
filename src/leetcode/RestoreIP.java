package leetcode;
import java.util.*;

public class RestoreIP {

	public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        
        if (s.length()<4||s.length()>12) return res;
        
        StringBuffer sb = new StringBuffer();
        dfs(s,sb,res,0);
        
        return res;
    }
    
    public static void dfs(String s, StringBuffer tmp, List<String> res, int start){
        if (start == 3 && isValid(s)) {
            res.add(tmp.toString() + s);
            return;
        }
        for(int i=1; i<4 && i<s.length(); i++){
            String substr = s.substring(0,i);
            int len = tmp.length();
            if (isValid(substr)){
                dfs(s.substring(i), tmp.append(substr+'.'), res, start+1);
                tmp.delete(len,tmp.length());
            }
        }
    }
    
    public static boolean isValid(String s){
        if (s.charAt(0)=='0') return s.equals("0");
        int num = Integer.parseInt(s);
        return num<=255 && num>0;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(restoreIpAddresses("25525511135"));
	}

}
