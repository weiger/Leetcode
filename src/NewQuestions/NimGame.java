package NewQuestions;

public class NimGame {

	public static boolean canWinNim(int n) {
        
        return n%4 != 0;
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canWinNim(6));
	}

}
