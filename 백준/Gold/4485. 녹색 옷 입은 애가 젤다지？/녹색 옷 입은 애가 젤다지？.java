import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 4485 녹색 옷 입은 애가 젤다지?
 * 
 * BFS / 다익스트라 / 최단경로
 * 
 * N * N 맵 0, 0 에서 n-1, n-1 까지 이동 칸에 적힌 숫자만큼 금액 감소 금액 감소를 최소화하는 경로 찾기
 * 
 * isVisited 배열을 int로 만들어서 방문할 때마다 숫자 늘려주기!
 */

public class Main {

	static int n;
	static int[][] map;
	static int[][] isVisited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		input();
	}

	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = 0;
		while (true) {
			// map 크기
			n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}
			// map 입력값
			map = new int[n][n];
			isVisited = new int[n][n];
			for (int r = 0; r < n; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < n; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
					// 방문배열 최대수로 채워놓기
					isVisited[r][c] = Integer.MAX_VALUE;
				}
			}
			testCase++;
			System.out.println("Problem " + testCase + ": " + bfs());
		}

	}

	static int bfs() {
		// cost가 작은 값이 가장 앞으로 올 수 있도록 우선순위 큐 사용
		PriorityQueue<Node> pq = new PriorityQueue<>();
		// 해당 좌표 q에 넣기
		pq.offer(new Node(0, 0, map[0][0]));
		// 시작칸은 자기 값
		isVisited[0][0] = map[0][0];
		// q가 빌 때까지
		while (!pq.isEmpty()) {
			// 제일 앞에 있는 좌표 빼서
			Node now = pq.poll();
			// 4방향 다 확인
			for (int dir = 0; dir < 4; dir++) {
				int nr = now.r + dr[dir];
				int nc = now.c + dc[dir];
				// 범위 안에 있고 방문하지 않았다면 (방문배열 값이 지금 넣으려는 cost보다 크다면 작은 값으로 바꿔주기)
				if (canMove(nr, nc) && isVisited[nr][nc] > isVisited[now.r][now.c] + map[nr][nc]) {
					// 방문처리 배열에 해당 좌표까지 오는 데 들인 금액 저장
					isVisited[nr][nc] = isVisited[now.r][now.c] + map[nr][nc];
					// pq에 넣기
					pq.offer(new Node(nr, nc, isVisited[nr][nc]));
				}
			}
		}
		return isVisited[n - 1][n - 1];
	}

	// 범위 확인
	static boolean canMove(int r, int c) {
		return !(r < 0 || c < 0 || r >= n || c >= n);
	}

	// 좌표 클래스 생성
	// Comaparable impl 받고 override 해서 return 값에 this.cost - o.cost
	static class Node implements Comparable<Node> {
		int r;
		int c;
		int cost;

		public Node(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}
}
