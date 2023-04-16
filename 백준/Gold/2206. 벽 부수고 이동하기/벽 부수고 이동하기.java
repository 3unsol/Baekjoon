import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m, ans;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 맵 사이즈
		n = sc.nextInt();
		m = sc.nextInt();
		// 맵
		map = new int[n][m];
		// 방문처리 (좌표 + 공사 여부)
		visited = new boolean[n][m][2];
		// 맵 입력받기
		for (int r = 0; r < n; r++) {
			String str = sc.next();
			for (int c = 0; c < m; c++) {
				map[r][c] = str.charAt(c) - '0';
			}
		}
		// 도착 못하면 -1
		ans = -1;
		bfs();
		System.out.println(ans);
	}

	// 너비우선탐색
	static void bfs() {
		// 큐에 담을 거 : 좌표, 길이, 공사여부
		Queue<int[]> q = new LinkedList<int[]>();
		// 방문처리
		visited[0][0][0] = true;
		// 큐에 현재 상황 넣기 (시작점, 카운트는 본인 1, 공사 안 함)
		q.offer(new int[] { 0, 0, 1, 0 });
		// 큐가 빌 떄까지
		while (!q.isEmpty()) {
			// 하나 뽑아낸다.
			int[] tmp = q.poll();
			// 걔가 목적지라면 갖고 있는 길이를 넣어줌
			// 큐가 빌 떄까지 도착 못하면 ans는 계속 -1
			if (tmp[0] == n - 1 && tmp[1] == m - 1) {
				ans = tmp[2];
				break;
			}
			// 사방탐색
			for (int dir = 0; dir < 4; dir++) {
				int nr = tmp[0] + dr[dir];
				int nc = tmp[1] + dc[dir];
				// 범위를 넘어갔거나 방문했으면 그만보기
				// 근데! 공사하고 온 애인지 아닌 애인지 판단해서 넣어야 한다. tmp[3]으로.
				if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc][tmp[3]]) {
					continue;
					// 벽이 아니라면 방문처리하고
				} else if (map[nr][nc] == 0) {
					visited[nr][nc][tmp[3]] = true;
					// 큐에 넣어준다. 길이랑 공사여부 들고
					q.offer(new int[] { nr, nc, tmp[2] + 1, tmp[3] });
					// 벽이라면
				} else if (map[nr][nc] == 1) {
					// 공사 안 했을 떄만 본다.
					if (tmp[3] == 0) {
						// 방문 + 공사여부 처리
						visited[nr][nc][1] = true;
						// 길이 늘려주고 공사 했다하고 가져가기
						q.offer(new int[] { nr, nc, tmp[2] + 1, 1 });
					}
				}
			}
		}
	}
}