import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 색종이 개수
		int n = sc.nextInt();
		// 평면 맵
		int[][] map = new int[101][101];
		// 색종이 크기만큼 맵에 입력
		for (int i = 0; i < n; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();

			for (int j = r; j < r + 10; j++) {
				for (int k = c; k < c + 10; k++) {
					map[j][k] = 1;
				}
			}
		}
		// 둘레...
		// 맞닿아있는 게 0이거나 배열의 끝이면 세어준다.
		int cnt = 0;
		// 그놈의 델타...어휴
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };
		// 맵을 돌면서
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				// 1일 때만 확인
				if (map[i][j] == 1) {
					// 델타 돌면서
					for (int k = 0; k < 4; k++) {
						// 인덱스 알아보기 쉽게 정리
						int nr = i + dr[k];
						int nc = j + dc[k];
						// 내가 1이면서 범위 안에 있고 맞닿아있는 게 0이면 cnt++
						if (nr >= 1 && nr <= 100 && nc >= 1 && nc <= 100 && map[nr][nc] == 0) {
							cnt++;
						}
						// 내가 1이면서 배열 끝이랑 맞닿아있으면 cnt++
						else if (nr < 1 || nr > 100 || nc < 1 || nr > 100) {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
