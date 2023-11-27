import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int ans = Integer.MAX_VALUE;
	static int[][] space;
	static int[] dr = {1, 1, 1};
	static int[] dc = {-1, 0, 1};

	public static void main(String[] args) throws Exception {

		input();

		for(int i = 0; i < M; i++){
			dfs(0, i, -1, space[0][i]);
		}

		System.out.println(ans);

	}

	static void dfs(int r, int c, int prevDir, int sum){

		if(r == N - 1){
			if(ans > sum) {
				ans = sum;
			}
			return;
		}

		for(int dir = 0; dir < 3; dir++){

			int nr = r + dr[dir];
			int nc = c + dc[dir];

			if(canMove(nr, nc) && prevDir != dir){
				dfs(nr, nc, dir, sum + space[nr][nc]);
			}
		}
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M  = Integer.parseInt(st.nextToken());

		space = new int[N][M];

		for(int r = 0; r < N; r++){
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < M; c++){
				space[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	}

	static boolean canMove(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < M;
	}
}