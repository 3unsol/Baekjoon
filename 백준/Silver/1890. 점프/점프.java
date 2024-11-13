import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        dp = new long[N + 1][N + 1];

        for(int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = 1;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i == N && j == N) break;
                if(i + map[i][j] <= N) dp[i + map[i][j]][j] += dp[i][j];
                if(j + map[i][j] <= N) dp[i][j + map[i][j]] += dp[i][j];
            }
        }

        System.out.println(dp[N][N]);
    }
}