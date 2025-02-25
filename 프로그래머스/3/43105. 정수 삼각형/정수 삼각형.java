class Solution {
    
    static int N;
    static int[][] dp;
    
    public int solution(int[][] triangle) {
        int answer = 0;
        
        N = triangle.length; // 삼각형의 높이
        dp = new int[N][N]; // dp 배열
        
        // 왼쪽값 미리 저장하기
        dp[0][0] = triangle[0][0];
        for(int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
        }
        
        // dp배열 채우기
        for(int i = 1; i < N; i++) {
            for(int j = 1; j <= i; j++) {
                // 왼쪽값에서 내려왔을 때, 오른쪽 값에서 내려왔을 때 비교
                dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
            }
        }
        
        // 가장 아랫줄에서 제일 큰 값
        for(int i = 0; i < N; i++) {
            answer = Math.max(dp[N - 1][i], answer);
        }
        
        return answer;
    }
}