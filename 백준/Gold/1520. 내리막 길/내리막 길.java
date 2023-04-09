import java.util.Scanner;

public class Main {

	static int m, n;
	static int[][] map;
	static int[][] dp;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int dfs(int r, int c) {
		if (r == m - 1 && c == n - 1) {
			return 1;
		}
		if (dp[r][c] != -1) {
			return dp[r][c];
		}
		if (dp[r][c] == -1) {
			dp[r][c] = 0;
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
					continue;
				}
				if (map[r][c] > map[nr][nc]) {
					dp[r][c] += dfs(nr, nc);
				}
			}
		}
		return dp[r][c];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[m][n];
		dp = new int[m][n];
		for (int r = 0; r < m; r++) {
			for (int c = 0; c < n; c++) {
				map[r][c] = sc.nextInt();
				dp[r][c] = -1;
			}
		}
		int ans = dfs(0, 0);
		System.out.println(ans);
	}
}
