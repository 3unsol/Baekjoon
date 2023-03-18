import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
//		str = str.toUpperCase();
		int[] cnt = new int[26];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				int num = str.charAt(i) - 65;
				cnt[num]++;
			} else {
				int num = str.charAt(i) - 97;
				cnt[num]++;
			}
		}
		int max = -1;
		char ans = '?';
		for (int i = 0; i < 26; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
				ans = (char) (i + 65);
			} else if (cnt[i] == max) {
				ans = '?';
			}
		}
		System.out.println(ans);
	}
}
