import java.util.*;

/**

식 전체를 작은 부분으로 쪼개서 계산

dp[시작 인덱스][끝 인덱스][0 : 최솟값 / 1 : 최댓값]
시작 인덱스 ~ 끝 인덱스 범위의 연산 최솟값, 최댓값 저장하는 배열
답은 DP[0][arr.length][1]에 모이게 된다.
**/

class Solution {
    public int solution(String arr[]) {
        
        
        int n = arr.length / 2 + 1; // 숫자 개수
        int op = arr.length - n; // 기호 개수
        
        int[] numbers = new int[n]; // 숫자 배열
        String[] operations = new String[op]; // 기호 배열
        
        // 숫자, 기호 구분해서 배열에 담아주기
        int numbersIndex = 0; // 숫자 인덱스
        int operationsIndex = 0; // 기호 인덱스
        for(int i = 0; i < arr.length; i++) {
            if(i % 2 == 0) {
                numbers[numbersIndex++] = Integer.parseInt(arr[i]);
            } else {
                operations[operationsIndex++] = arr[i];
            }
        }
        
        // DP 배열
        int[][][] dp = new int[n + 1][n + 1][2];
        
        // i ~ i까지는 자기 자신만이 유일한 값
        for(int i = 0; i < n; i++) {
            dp[i][i][0] = numbers[i];
            dp[i][i][1] = numbers[i];
        }
        
        for(int len = 1; len < n; len++) { // 범위 길이 (start부터 len만큼)
            for(int start = 0; start < n; start++) { // 시작
                
                int end = start + len; // 끝
                if(end >= n) break; // 범위 벗어나면 그만
                
                int max = Integer.MIN_VALUE; // 최댓값
                int min = Integer.MAX_VALUE; // 최솟값
                
                for(int i = start; i < end; i++) { // 기호 배열의 인덱스(i)를 기준으로 나누어서 계산
                    // 기호가 덧셈이라면
                    if(operations[i].equals("+")) {
                        max = Math.max(max, dp[start][i][1] + dp[i + 1][end][1]); // 최댓값+최댓값
                        min = Math.min(min, dp[start][i][0] + dp[i + 1][end][0]); // 최솟값+최솟값
                    } else { // 뺄셈이라면
                        max = Math.max(max, dp[start][i][1] - dp[i + 1][end][0]); // 최댓값-최솟값
                        min = Math.min(min, dp[start][i][0] - dp[i + 1][end][1]); // 최솟값-최댓값
                    }
                }
                
                dp[start][end][0] = min;
                dp[start][end][1] = max;
            }
        }
        
        return dp[0][n - 1][1];
    }
}