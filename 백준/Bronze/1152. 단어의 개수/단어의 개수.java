import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				cnt++;
			}
		}
		if (str.charAt(0) != ' ' && str.charAt(str.length() - 1) != ' ') {
			cnt++;
		}
		if (str.charAt(0) == ' ' && str.charAt(str.length() - 1) == ' ') {
			cnt--;
		}
		System.out.println(cnt);
	}

}
