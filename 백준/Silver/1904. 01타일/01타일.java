import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 15746;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];

        if(N == 1) {
            System.out.println(1);
            return;
        }

        dp[1] = 1l;
        dp[2] = 2l;

        for(int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        System.out.println(dp[N] % MOD);
    }
}