import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[101][101];

        int r1, c1, r2, c2;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());

            for(int r = r1; r <= r2; r++) {
                for(int c = c1; c <= c2; c++) {
                    map[r][c]++;
                }
            }
        }

        int cnt = 0;

        for(int r = 0; r < 101; r++) {
            for(int c = 0; c < 101; c++) {
                if(map[r][c] > M) cnt++;
            }
        }

        System.out.println(cnt);
    }
}