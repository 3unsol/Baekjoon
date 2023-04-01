import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int n; // 정점의 개수
	static int[][] graph; // 인접행렬
	static boolean[] visited; // 방문했는지 확인할 배열
	static Queue<Integer> q = new LinkedList<Integer>(); // bfs에서 쓸 queue

	// dfs : 깊이우선탐색
	// d : 현재 내가 탐색할 노드
	static void dfs(int d) {
		// 노드를 탐색했다고 설정
		visited[d] = true;
		// 탐색했다고 출력한다.
		System.out.print(d + " ");
		// 정점을 돌면서
		for (int i = 1; i <= n; i++) {
			// 정점이 d와 연결되어 있고 아직 방문하지 않았다면
			if (graph[d][i] == 1 && !visited[i]) {
				// 그 정점을 탐색한다.
				dfs(i);
			}
		}
	}

	// bfs : 너비우선탐색
	// d : 현재 내가 탐색할 노드
	static void bfs(int d) {
		// 탐색할 노드를 q에 넣어준다.
		q.add(d);
		// 탐색했다고 설정
		visited[d] = true;
		// queue가 빌 때까지
		while (!q.isEmpty()) {
			// 확인할 값을 뽑아낸다.
			int curr = q.poll();
			// 출력한다.
			System.out.print(curr + " ");
			// 정점을 돌면서
			for (int i = 1; i <= n; i++) {
				// 현재 확인할 값과 연결 되어있고 아직 방문하지 않은 값을
				if (graph[curr][i] == 1 && !visited[i]) {
					// 큐에 넣어주고
					q.add(i);
					// 방문했다고 설정
					visited[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 정점의 개수
		int m = sc.nextInt(); // 간선의 개수
		int v = sc.nextInt(); // 탐색을 시작할 곳

		graph = new int[n + 1][n + 1]; // 1부터니까 크기를 1 키워서 만들어준다.
		visited = new boolean[n + 1]; // 불린배열도 마찬가지

		int a = 0; // 좌표 입력을 받기 위한 변수
		int b = 0; // 좌표 입력을 받기 위한 변수

		for (int i = 1; i <= m; i++) { // 간선의 개수만큼 실행
			a = sc.nextInt(); // 좌표값을 입력 받는다.
			b = sc.nextInt(); // 좌표값을 입력 받는다.
			graph[a][b] = graph[b][a] = 1; // 연결되어 있다면 1을 입력해준다.
		}

		dfs(v); // 깊이우선탐색 실행
		System.out.println(); // 개행
		for(int i = 1; i <= n; i++) { // 깊이우선탐색이 끝나면 불린 배열을 초기화 해준다.
			visited[i] = false;
		}
		bfs(v); // 너비우선탐색 실행
	}
}
