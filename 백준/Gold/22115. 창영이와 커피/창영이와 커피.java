import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] coffee;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coffee = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            coffee[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[K + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for(int i = 0; i < N; i++) {
            // 중복 방지를 위해 역순으로 확인한다
            for(int j = K; j >= 0; j--) {
                // 현재 커피를 마실 수 있고, 현재 커피의 카페인을 뺀 값을 만들 수 있을 때
                if(j - coffee[i] >= 0 && dp[j - coffee[i]] != 100001) {
                    dp[j] = Math.min(dp[j], dp[j - coffee[i]] + 1);
                }
            }
        }

        if(dp[K] == 100001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[K]);
        }
    }
}