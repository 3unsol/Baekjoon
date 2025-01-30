import java.util.*;
/**
돌 사이의 거리를 기준으로 잡는다.
제거된 돌의 개수를 n과 비교하여 움직임
**/
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // 정렬
        Arrays.sort(rocks);
        
        // 이분탐색
        int start = 1; // 만들 수 있는 돌 사이 최소 거리
        int end = distance; // 만들 수 있는 돌 사이 최대 거리
        
        while(start <= end) {
            
            int mid = (start + end) / 2; // 만들려는 돌 사이 최소 거리
            int prev = 0; // 기준이 되는 돌 위치
            int cnt = 0; // 제거한 돌의 개수
            
            for(int i = 0; i < rocks.length; i++) {
                if(rocks[i] - prev < mid) { // 기준점이 되는 돌과의 거리가 최소 거리보다 짧으면 돌 제거
                    cnt++;
                } else { // 기준점이 되는 돌과의 거리가 최소 거리보다 길면 기준점을 바꿔준다.
                    prev = rocks[i];
                }
            }
            
            if(distance - prev < mid) cnt++; // 기준점에서 도착지점까지의 거리가 최소 거리보다 짧으면 기준점 돌 제거
            
            if(cnt <= n) { // 최소 거리에 맞춰 돌을 제거했을 때 n개보다 적으면 최소거리를 늘린다.
                start = mid + 1;
            } else { // n개보다 많으면 최소 거리를 줄임
                end = mid - 1;
            }
        }
        
        return end;
    }
}