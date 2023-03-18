import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();
			// 안 겹칠 떄
			if (x2 > p || p2 < x || y2 > q || q2 < y) {
				System.out.println('d');
				// 점일 때
			} else if (x2 == p && y2 == q || x2 == p && q2 == y || p2 == x && q2 == y || p2 == x && y2 == q) {
				System.out.println('c');
				// 선일 때
			} else if (p2 == x || x2 == p || q2 == y || y2 == q) {
				System.out.println('b');
				// 겹칠 때
			} else {
				System.out.println('a');
			}
		}
	}
}
