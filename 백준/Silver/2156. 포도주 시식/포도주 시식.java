import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] wine, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        wine = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        findMax();

        System.out.println(dp[N]);
    }

    static void findMax() {

        dp = new int[N + 1];
        dp[1] = wine[1];

        if(N >= 2) {

            dp[2] = dp[1] + wine[2];

            for(int i = 3; i <= N; i++) {
                dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + wine[i]), dp[i - 3] + wine[i - 1] + wine[i]);
            }
        }
    }
}