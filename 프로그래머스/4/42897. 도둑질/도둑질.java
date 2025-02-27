import java.util.*;

/**
DP 배열을 두 개 만들기
1. 첫 번째 집을 털 경우
2. 첫 번째 집을 안 털 경우 (마지막 집을 털 경우)
**/
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        
        int N = money.length;
        int[] firstDP = new int[N];
        int[] lastDP = new int[N];
        
        // 첫 번째 집 털 때
        firstDP[0] = firstDP[1] = money[0];
        // 첫 번째 집 안 털 때
        lastDP[1] = money[1];
        for(int i = 2; i < N; i++) {
            firstDP[i] = Math.max(firstDP[i - 2] + money[i], firstDP[i - 1]);
            lastDP[i] = Math.max(lastDP[i - 2] + money[i], lastDP[i - 1]);
        }
        
        // 첫 번째 집은 마지막 집 못 턺
        return Math.max(firstDP[N - 2], lastDP[N - 1]);
    }
}