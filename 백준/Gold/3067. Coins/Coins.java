import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, target;
    static int[] coins;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {

            N = Integer.parseInt(br.readLine()); // 동전 개수
            coins = new int[N + 1]; // 동전 배열

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) { // dp를 채우기 위해 1부터 시작
                coins[i] = Integer.parseInt(st.nextToken()); // 오름차순으로 제공
            }

            target = Integer.parseInt(br.readLine()); // 만들 금액
            dp = new int[N + 1][target + 1]; // 모든 방법의 수를 저장할 dp 배열

            for(int i = 0; i <= N; i++) {
                dp[i][0] = 1;
            }

            for(int i = 1; i <= N; i++) { // coins[i] 동전을 사용해서
                for(int j = 1; j <= target; j++) { // j 금액을 만들 수 있는 모든 방법
                    dp[i][j] = dp[i - 1][j]; // 이전까지의 동전을 사용했을 때 방법의 수 갖고 오기
                    if(coins[i] <= j) { // 해당 동전이 금액보다 작으면 사용 가능
                        dp[i][j] += dp[i][j - coins[i]]; // 기존에 구해놨던 j값 경우의 수 + (기존에 구해놨던 j - coins[i]값 경우의 수 + coins[i]를 쓰는 경우 1)
                    }
                }
            }

            System.out.println(dp[N][target]);
        }
    }
}