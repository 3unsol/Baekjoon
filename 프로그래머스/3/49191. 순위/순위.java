import java.util.*;
/**
n명의 선수가 자신의 순위를 알려면 n-1명의 순위를 알아야 함
플로이드 와샬 (3중 for문
-모든 정점 간 최단 거리
-경유지를 거쳐가는 최단 거리
-경 출 도 (i : 경유지, j : 출발지, k : 도착지)
**/
class Solution {
    
    static int[][] scores;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        // 승패 정보 입력
        scores = new int[n][n];
        for(int i = 0; i < results.length; i++) {
            int winner = results[i][0] - 1;
            int loser = results[i][1] - 1;
            scores[winner][loser] = 1;
            scores[loser][winner] = -1;
        }
       
        // 플로이드 와샬로 모든 정점 간의 정보 입력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;
                for(int k = 0; k < n; k++) {
                    if(j == k) continue;
                    // i가 k 이기고 k가 j 이기면 i가 j 이김
                    if(scores[i][k] == 1 && scores[k][j] == 1) {
                        scores[i][j] = 1;
                        scores[j][i] = -1;
                    }
                    // i가 k한테 지고 k가 j한테 지면 i가 j한테 짐
                    if(scores[i][k] == - 1 && scores[k][j] == -1) {
                        scores[i][j] = -1;
                        scores[j][i] = 1;
                    }
                }
            }
        }
        
        // 0이 아닌 개수 세기
        for(int i = 0; i < n; i++) {
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(i != j && scores[i][j] != 0) {
                    cnt++;
                }
            }
            if(cnt == n - 1) answer++;
        }
        return answer;
    }
}