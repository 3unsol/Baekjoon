import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int num;
    static int[][] cost;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        input();
    }
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        cost = new int[num][3];
        dp = new int[num][3];

        StringTokenizer st;
        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        System.out.println(Math.min(Math.min(paint(num - 1, 0), paint(num - 1, 1)), paint(num - 1, 2)));
    }

    static int paint(int n, int color){
        if(dp[n][color] == 0){
            if(color == 0){
                dp[n][0] = Math.min(paint(n - 1, 1), paint(n - 1, 2)) + cost[n][0];
            }else if(color == 1){
                dp[n][1] = Math.min(paint(n - 1, 0), paint(n - 1, 2)) + cost[n][1];
            }else{
                dp[n][2] = Math.min(paint(n - 1, 0), paint(n - 1, 1)) + cost[n][2];
            }
        }
        return dp[n][color];
    }
}
