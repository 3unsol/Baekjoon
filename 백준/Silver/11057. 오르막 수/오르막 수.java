import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    static int N;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // N : 길이
        dp = new long[N + 1][10]; // r : 길이, c : 마지막 자리수

        Arrays.fill(dp[1], 1); // 길이가 1일 때는 각자 숫자 하나씩이라서 한 개

        // i : 길이, j : 마지막 자리수, k : 이전까지의 개수 더하는 용도
        for(int i = 2; i <= N; i++) {
            for(int j = 0; j <= 9; j++) {
                for(int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
                dp[i][j] %= 10007;
            }
        }

        long sum = 0;
        for(int i = 0; i <= 9; i++) {
            sum += dp[N][i];
        }

        // 10007로 나누기
        System.out.println(sum % 10007);
    }
}