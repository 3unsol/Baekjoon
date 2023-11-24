import java.awt.peer.ListPeer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static String password;
	public static void main(String[] args) throws Exception {
		input();
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){

			password = br.readLine();

			if(password.equals("end"))
				return;

			if(check()){
				System.out.println("<" + password + "> is acceptable.");
			}else {
				System.out.println("<" + password + "> is not acceptable.");
			}
		}
	}

	static boolean check(){

		boolean hasVowel = false;

		// 자모음 3개 연속 X
		for(int i = 0; i < password.length(); i++){

			char alphabet = password.charAt(i);

			// 모음 들었니?
			if(isVowel(alphabet)) hasVowel = true;


			// 같은 문자 2개 연속?
			if(i > 0){
				char prev = password.charAt(i - 1);

				if(prev == alphabet){
					if(alphabet != 'e' && alphabet != 'o') return false;
				}
			}

			// 자모음 3개 가능?
			if(i > 1){
				char prev = password.charAt(i - 1);
				char prev2 = password.charAt(i - 2);

				if(isVowel(alphabet)){

					if(isVowel(prev) && isVowel(prev2))
						return false;
				}

				else {
					if(!isVowel(prev) && !isVowel(prev2))
						return false;
				}
			}
		}

		return hasVowel;
	}

	static boolean isVowel(char alphabet) {
		return(alphabet == 'a' || alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u');
	}
}