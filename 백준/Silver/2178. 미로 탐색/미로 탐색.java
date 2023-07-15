import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 행
		m = Integer.parseInt(st.nextToken()); // 열
		map = new int[n][m]; // 맵
		visited = new boolean[n][m]; // 방문처리
		for (int r = 0; r < n; r++) {
			String str = br.readLine(); // 공백 없이 한 줄로 입력 받음
			for (int c = 0; c < m; c++) {
				map[r][c] = str.charAt(c) - '0'; // String을 char로 바꾸고 -'0'해서 int로 바꿈
			}
		}
		visited[0][0] = true; // 시작점 무조건 방문
		bfs(0, 0); // 너비우선탐색
		System.out.println(map[n - 1][m - 1]);
	}
	
	static void bfs(int r, int c) { // 너비우선탐색, 좌표 입력
		Queue<int[]> q = new LinkedList<>(); // 큐 활용
		q.add(new int[] {r, c}); // 큐에 좌표 입력 (class를 만들거나 배열로 만들어서 넣거나)
		while(!q.isEmpty()) { // 큐가 빌 때까지
			int[] tmp = q.poll(); // 맨 앞 꺼냄
			for(int dir = 0; dir < 4; dir++) { // 델타 사방검색
				int nr = tmp[0] + dr[dir]; // 다음 행 좌표
				int nc = tmp[1] + dc[dir]; // 다음 열 좌표
				if(nr < 0 || nc < 0 || nr >= n || nc >= m) { // 범위 벗어나면 넘기기
					continue;
				}
				if(map[nr][nc] == 0 || visited[nr][nc]) { // 벽이거나 방문한 곳은 넘기기
					continue;
				}
				q.add(new int[] {nr, nc}); // 갈 수 있는 곳이면 큐에 넣기
				map[nr][nc] = map[tmp[0]][tmp[1]] + 1; // 이렇게 하나씩 갈 때마다 더해주면 마지막엔 몇 개 지났는지 저장됨. 
				visited[nr][nc] = true; // 방문처리
			}
		}
	}
}
