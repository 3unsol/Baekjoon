import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 1000000000;
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][10]; // r: 자리수, c: 0~9 값

        // 한 자리 수는 1개씩 가능
        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1l;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= 9; j++) {

                if(j == 0) {
                    dp[i][j] = dp[i - 1][1] % mod;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        long ans = 0;
        for(int i = 0; i <= 9; i++) {
            ans += dp[N][i];
        }

        System.out.println(ans % mod);
    }
}