import java.util.*;
/**
Heap : 우선순위 큐를 위해 만들어진 자료구조
느슨한 정렬 상태
->부모 노드의 키 값이 자식 노드의 키 값보다 늘 크다(작다)

1. 스코빌 지수가 가장 낮은 음식 2개
2. 가장 낮은 스코빌 지수 + (두 번째로 낮은 스코빌 지수 * 2)

(참고)
루프문에서 heap.peek이 K 이상일 때, answer를 더하지 않고 즉시 0을 리턴하는가
heap의 size가 2보다 작아 루프에서 탈출했을 때, heap.peek이 K 이상인지 확인 후 answer를 return 하는가
**/
class Solution {
    public int solution(int[] scoville, int K) {
        
        // 섞은 횟수
        int answer = 0;
        
        // 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 우선순위 큐에 스코빌 지수 전부 넣기
        for(int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        
        while(pq.size() > 1) {
            
            int first = pq.poll();
            
            if(first >= K) {
                return answer;
            }
            
            int second = pq.poll();
            
            pq.offer(first + (second * 2));
            
            answer++;
        }
        
        if(pq.poll() >= K) return answer;
        
        return -1;
    }
}