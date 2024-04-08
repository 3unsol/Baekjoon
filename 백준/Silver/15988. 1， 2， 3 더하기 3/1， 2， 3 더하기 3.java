import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static long[] dp = new long[1000001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }

        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(dp[N]);
        }
    }

}