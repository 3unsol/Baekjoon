import java.util.Scanner;

public class Main {

	static int m, n;
	static int[][] adjList;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static boolean[][] visited;

	static void dfs(int r, int c) {
		visited[r][c] = true;
		for (int dir = 0; dir < 4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr < 0 || nr >= n || nc < 0 || nc >= m)
				continue;
			else if (adjList[nr][nc] == 0)
				continue;
			else if (visited[nr][nc])
				continue;
			dfs(nr, nc);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			m = sc.nextInt();
			n = sc.nextInt();
			int k = sc.nextInt();
			adjList = new int[n][m];
			visited = new boolean[n][m];
			int a = 0;
			int b = 0;
			for (int i = 0; i < k; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				adjList[b][a] = 1;
			}
			int cnt = 0;
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < m; c++) {
					if (adjList[r][c] != 0 && !visited[r][c]) {
						dfs(r, c);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
