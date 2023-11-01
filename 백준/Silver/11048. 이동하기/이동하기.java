import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M + 1];
		for(int r = 1; r <= N; r++){
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= M; c++){
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		for(int r = 1; r <= N; r++){
			for(int c = 1; c <= M; c++){
				map[r][c] = map[r][c] + Math.max(map[r - 1][c], map[r][c - 1]);
			}
		}
		System.out.println(map[N][M]);
	}
}