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
		
		int[][] arr = new int[N + 1][M + 1];
		for(int r = 1; r <= N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken()) + arr[r - 1][c] + arr[r][c - 1] - arr[r - 1][c - 1];
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
		
			int sum = arr[endR][endC] - arr[endR][startC - 1] - arr[startR - 1][endC] + arr[startR - 1][startC - 1];
			
			System.out.println(sum);
		}
	}

}