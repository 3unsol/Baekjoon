import java.util.*;

class Solution {
    
    static final int INF = Integer.MAX_VALUE;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[n][m];
        
        // puddles max값 입력
        for(int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1] - 1][puddles[i][0] - 1] = INF;
        }
        
        // dp 배열 채우기
        dp[0][0] = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                
                // paddles면 넘어가기
                if(dp[i][j] == INF) continue;
                
                // 위쪽에서 올 때
                if(i - 1 >= 0 && dp[i - 1][j] != INF) {
                    dp[i][j] += dp[i - 1][j];
                }
                
                // 왼쪽에서 올 때
                if(j - 1 >= 0 && dp[i][j - 1] != INF) {
                    dp[i][j] += dp[i][j - 1];
                }
                
                dp[i][j] %= 1_000_000_007;
            }
            
        }
        return dp[n - 1][m - 1] % 1_000_000_007;
    }
}