import java.util.Scanner;

public class Main {

	static int n, m, k, ans, cnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 세로길이
		m = sc.nextInt(); // 가로길이
		k = sc.nextInt(); // 음쓰 개수
		map = new int[n + 1][m + 1]; // 맵
		ans = 0; // 음쓰 최대 크기
		visited = new boolean[n + 1][m + 1]; // 방문 확인
		for (int i = 0; i < k; i++) { // 인접행렬
			map[sc.nextInt()][sc.nextInt()] = 1;
		}
		for (int r = 1; r <= n; r++) {
			for (int c = 1; c <= m; c++) {
				if (!visited[r][c] && map[r][c] == 1) { // 방문 안 했고 1인 애들만
					cnt = 1; // 1이면 일단 크기 1이니까 1로 초기화
					dfs(r, c);
					ans = Math.max(ans, cnt); // 탐색 끝나면 걔한테 연결된 크기 최대값이 나온다.
				}

			}
		}
		System.out.println(ans);
	}

	static void dfs(int r, int c) { // 깊이 우선 탐색
		visited[r][c] = true; // 방문 처리

		for (int dir = 0; dir < 4; dir++) { // 델타
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr < 0 || nr > n || nc < 0 || nc > m || visited[nr][nc] || map[nr][nc] == 0) {
				// 범위, 방문, 크기 체크
				continue;
			}
			// 여기엔 방문 안 한 음쓰 애들만 온다
			cnt++; // 왔다면 크기 늘려주고
			dfs(nr, nc); // 또 탐색
		}
	}
}