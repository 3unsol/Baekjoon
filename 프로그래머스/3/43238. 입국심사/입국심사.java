import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        // 이분탐색 (걸리는 시간)
        // 최댓값: 가장 오래걸리는 심사대에서 모두가 검사 받을 때
        Arrays.sort(times);
        
        long start = 0;
        long end = (long)n * times[times.length - 1];
        
        while(start <= end) {
            long mid = (start + end) / 2;
            
            // 주어진 시간 안에 각 심사대에서 받을 수 있는 사람 수
            long sum = 0;
            for(int i = 0; i < times.length; i++) {
                sum += mid / (long)times[i];
                // n명 넘어가면 그만 보기
                if(sum >= n) break;
            }
            
            if(sum < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return start;
    }
}