import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N + 1][N + 1];
		for(int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken()) + map[r - 1][c] + map[r][c - 1] - map[r - 1][c - 1];
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
			
			int sum = map[endR][endC] - map[endR][startC - 1] - map[startR - 1][endC] + map[startR - 1][startC - 1];
			System.out.println(sum);
		}
	}
}