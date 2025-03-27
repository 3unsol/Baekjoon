import java.util.*;

/**
우선순위 내림차순
id = [0, 1, 2, 3]
pr = [2, 1, 3, 2]
pq = [(2, 3), (0, 2), (3, 2), (1, 1)]

pr = [1, 1, 9, 1, 1, 1]
pq = [9, 1, 1, 1, 1, 1]
**/

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        // 우선순위 큐 (내림차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 우선순위 큐에 넣기
        for(int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
        }

        while(!pq.isEmpty()) {
            // 우선순위 높은 프로세스 찾기
            for(int i = 0; i < priorities.length; i++) {
                // pq.peek() : 지금 실행될 프로세스 (우선순위 높음)
                // == priorities[i] : 지금 실행될 프로세스 찾기
                if(pq.peek() == priorities[i]) {
                    // 프로세스 실행
                    pq.poll();
                    // 실행한 프로세스 개수
                    answer++;
                    // 찾으려는 프로세스 발견
                    if(i == location) return answer;
                }
            }
            
        }
        
        return answer;
    }
}