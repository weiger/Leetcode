package Locked;

public class ReadNCharactersGivenRead4 {

	public static int read(char[] buf, int n){
		char[] buffer = new char[4];
		boolean isEnd = false;
		int total = 0,bytes = 0;
		
		while(!isEnd && total < n){
			int size = read4(buffer);
			if(size < 4) isEnd = true;
			
			 bytes= Math.min(n-total, size); // 没有读完， 读完了但是还有剩余空间
			
			for(int i = 0; i < bytes; i++)
				buf[total+i] = buffer[i];
			total += bytes;
		}
		return total;
	}
	
	static int read4(char[] buf){
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
