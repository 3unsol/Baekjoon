import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] map = new boolean[101][101];
		for(int i = 0; i < 4; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int r = x1; r < x2; r++){
				for(int c = y1; c < y2; c++){
					map[r][c] = true;
				}
			}
		}
		int ans = 0;
		for(int r = 1; r <= 100; r++){
			for(int c = 1; c <= 100; c++){
				if(map[r][c]){
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}