import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] dp;
    static final int MOD = 9901;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // i번째 줄에, 0 : 둘다 안 놓음, 1 : 왼쪽에 놓음, 2 : 오른쪽에 놓음
        dp = new int[N + 1][3];

        // 2칸만 있을 때는 모든 방법이 1개씩
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for(int i = 2; i <= N; i++) {

            // i열에 사자를 안 놓는 경우 (어느 쪽이든 영향 안 받음)
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            // i열 왼쪽에 사자를 놓는 경우 (바로 위에 놓는 거 불가)
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            // i열 오른쪽에 사자를 놓는 경우 (바로 위에 놓는 거 불가)
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % MOD);
    }
}