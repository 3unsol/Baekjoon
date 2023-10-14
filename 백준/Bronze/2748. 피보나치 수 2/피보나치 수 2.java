import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        long[] dp = new long[n + 1];
        dp[1] = 1;
        if(n >= 2){
            dp[2] = 1;
            for(int i = 3; i <= n; i++){
                dp[i] = dp[i - 2] + dp[i - 1];
            }
        }
        System.out.println(dp[n]);
    }

}