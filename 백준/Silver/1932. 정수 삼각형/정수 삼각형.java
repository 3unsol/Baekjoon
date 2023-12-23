import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, ans;
    static int[][] triangle;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        input();
        findMaxSum();
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];
        StringTokenizer st;
        for(int r = 0; r < n; r++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c <= r; c++){
                triangle[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n][n];
        dp[0][0] = triangle[0][0];
    }

    static void findMaxSum(){

        for(int r = 1; r < n; r++){
            for(int c = 0; c <= r; c++){
                if(c == 0){
                    dp[r][c] = dp[r - 1][c] + triangle[r][c];
                }else if(c == r){
                    dp[r][c] = dp[r - 1][c - 1] + triangle[r][c];
                }else{
                    dp[r][c] = Math.max(dp[r - 1][c - 1], dp[r - 1][c]) + triangle[r][c];
                }
            }
        }

        for(int i = 0; i < n; i++){
            ans = Math.max(ans, dp[n - 1][i]);
        }

        System.out.println(ans);
    }
}
