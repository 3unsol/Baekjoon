import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, maxHeight, cnt, maxCount;
	static int[][] map;
	static boolean[][] isVisited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		input();

		for(int height = 0; height <= maxHeight; height++){
			cnt = 0;
			isVisited = new boolean[N][N];

			for(int r = 0; r < N; r++){
				for (int c = 0; c < N; c++) {
					if(!isVisited[r][c] && map[r][c] > height){
						dfs(r, c, height);
						cnt++;
					}
				}
			}
			maxCount = Math.max(maxCount, cnt);
		}
		System.out.println(maxCount);
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for(int r = 0; r < N; r++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c++){
				int height = Integer.parseInt(st.nextToken());
				map[r][c] = height;
				maxHeight = Math.max(maxHeight, height);
			}
		}
	}

	static void dfs(int r, int c, int height){

			isVisited[r][c] = true;

			for(int dir = 0; dir < 4; dir++){

				int nr = r + dr[dir];
				int nc = c + dc[dir];

				if(canMove(nr, nc) && !isVisited[nr][nc] && map[nr][nc] > height){
					dfs(nr, nc, height);
				}

			}
	}

	static boolean canMove(int r, int c){
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}