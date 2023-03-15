import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 색종이 개수
		int n = sc.nextInt();
		// 평면 맵
		int[][] map = new int[1001][1001];
		// 색종이 idx를 크기만큼 맵에 입력
		for (int i = 1; i <= n; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int nr = sc.nextInt();
			int nc = sc.nextInt();

			for (int j = r; j < r + nr; j++) {
				for (int k = c; k < c + nc; k++) {
					map[j][k] = i;
				}
			}
		}
		// 맵에 남아있는 색종이 idx를 세어준다.
		for (int idx = 1; idx <= n; idx++) {
			int cnt = 0;
			for (int j = 0; j < 1001; j++) {
				for (int k = 0; k < 1001; k++) {
					if (map[j][k] == idx) {
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
