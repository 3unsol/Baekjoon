import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 색종이 개수
		int n = sc.nextInt();
		// 평면 맵
		int[][] map = new int[100][100];
		// 색종이 크기만큼 맵에 입력
		for (int i = 1; i <= n; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			for (int j = r; j < r + 10; j++) {
				for (int k = c; k < c + 10; k++) {
					map[j][k] = 1;
				}
			}
		}
		// 맵에 남아있는 색종이 넓이를 세어준다.
		int cnt = 0;
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				if (map[j][k] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
