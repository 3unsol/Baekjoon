import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 개수 저장
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // 2부터 n까지 dp배열 채우기
        for(int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            // 제곱수가 i를 넘어가지 않게
            for(int j = 1; j * j <= i; j++){
                min = Math.min(min, dp[i - (j * j)]);
            }
            dp[i] = min + 1;
        }
        System.out.println(dp[n]);
    }
}