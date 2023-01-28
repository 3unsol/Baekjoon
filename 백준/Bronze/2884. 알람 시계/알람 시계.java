import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int m = sc.nextInt();

		// 시간 분 입력값 받기
		// m이 45보다 작으면
		// h-1, (60+m)-45
		// m이 45보다 크거나 같으면
		// h, m-45

		if (h != 0 && m < 45) {
			System.out.println((h - 1) + " " + ((60 + m) - 45));
		}
		if (m >= 45) {
			System.out.println(h + " " + (m - 45));
		}
		if (h == 0 && m < 45) {
			System.out.println(23 + " " + ((60 + m) - 45));
		}
	}
}