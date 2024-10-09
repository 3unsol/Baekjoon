import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, T;
    static int[][] scores, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 단원 수
        T = Integer.parseInt(st.nextToken()); // 주어진 시간

        scores = new int[N + 1][2];
        dp = new int[N + 1][T + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            scores[i][0] = Integer.parseInt(st.nextToken()); // 공부 시간
            scores[i][1] = Integer.parseInt(st.nextToken()); // 배점
        }

        for(int i = 1; i <= N; i++) {
            int time = scores[i][0];
            int score = scores[i][1];
            for(int j = 1; j <= T; j++) {
                // score + dp[i - 1][j - time] : i과목을 공부할 때
                // dp[i - 1][j] : i과목을 공부하지 않을 때
                if(time <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - time] + score);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][T]);
    }
}