package leetcode;

public class ComparisonVersion {
	
	 public static int compare(String version1, String version2) {
	        
		String[] ver1 = version1.split("\\.");
		String[] ver2 = version2.split("\\.");
		
		StringBuffer v1 = new StringBuffer();
		for(String str: ver1)
			v1.append(str);
		
		StringBuffer v2 = new StringBuffer();
		for(String str: ver2)
			v2.append(str);

		
		long vNumber1 = Long.valueOf(v1.toString());
		long vNumber2 = Long.valueOf(v2.toString());
		
		if(version1.charAt(0)<version2.charAt(0) || vNumber1 < vNumber2) return -1;
		else if(version1.charAt(0)>version2.charAt(0) ||vNumber1 > vNumber2) return 1;
		
		if(ver1.length >ver2.length) return 1;
		return 0;
					 
	 }

	public static void main(String[] args) {
		String s1= "0.9.9.9.9.9.9.9.9.9.9.9.9";
		String s2 = "1.0";
		long result = compare(s1, s2) ;
		System.out.print(result);

	}

}
