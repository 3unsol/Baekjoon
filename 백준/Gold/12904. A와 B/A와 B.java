import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String T = sc.next();
		// reverse를 쓰기 위해 스트링 빌더 사용
		StringBuilder sbS = new StringBuilder(S);
		StringBuilder sbT = new StringBuilder(T);

		// S를 T로 만들지 말고
		// T를 S로 만들 수 있는지를 본다.
		// S보다 짧아지면 그만 본다.
		while (sbS.length() < sbT.length()) {
			// T 마지막 글자가 A면 뺸다.
			if (sbT.charAt(sbT.length() - 1) == 'A') {
				sbT.deleteCharAt(sbT.length() - 1);
				// 마지막 글자가 B라면 뺴고 뒤집는다.
			} else if (sbT.charAt(sbT.length() - 1) == 'B') {
				sbT.deleteCharAt(sbT.length() - 1);
				sbT.reverse();
			}
		}
		// 비교하기 위해 String으로 바꿔준다.
		if (sbT.toString().equals(sbS.toString())) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}