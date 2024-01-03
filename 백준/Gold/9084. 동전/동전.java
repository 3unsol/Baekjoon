import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int coinCnt, target;
    static int[] coins;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++){
            input();
            findAnswer();
            System.out.println(dp[coinCnt][target]);
        }
    }

    static void input() throws Exception {

        coinCnt = Integer.parseInt(br.readLine());
        coins = new int[coinCnt + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= coinCnt; i++){
            coins[i] = Integer.parseInt(st.nextToken());
        }

        target = Integer.parseInt(br.readLine());

        dp = new int[coinCnt + 1][target + 1];
    }

    static void findAnswer() {

        for(int i = 0; i <= coinCnt; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= coinCnt; i++){
            for(int j = 1; j <= target; j++){

                dp[i][j] = dp[i - 1][j];

                if(j >= coins[i]){
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }
    }
}