import java.util.*;

/**
answer : 모든 트럭이 다리를 건너는데 걸리는 시간
bridge_length : 올라갈 수 있는 트럭 개수
weight : 견딜 수 있는 무게
truck_weights : 트럭이 오는 순서대로 무게
**/

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 다리 큐
        Queue<Integer> bridge = new ArrayDeque<>();
        
        // 현재 다리 위 무게
        int now = 0;
        
        // 트럭 다리에 올리기
        for(int i = 0; i < truck_weights.length; i++) {
            
            while(true) {
                
                answer++;
                
                // 다리가 비었다면 트럭 올리기
                if(bridge.isEmpty()) {
                    bridge.offer(truck_weights[i]);
                    now += truck_weights[i];
                    break;
                    
                    // 다리가 꽉 찼다
                } else if(bridge.size() == bridge_length) {
                    now -= bridge.poll();
                    answer--;
                } else {
                    // 아직 올라갈 수 있을 때
                    if(now + truck_weights[i] <= weight) {
                        bridge.offer(truck_weights[i]);
                        now += truck_weights[i];
                        break;
                        
                        // 못 올라갈 때
                    } else {
                        // 시간의 경과를 위해 0 넣어주기
                        bridge.offer(0);
                    }
                }
                
                
            } 
        }
        
        // 마지막 트럭이 다리를 지나가는 시간 더해주기
        answer += bridge_length;
        
        return answer;
    }
}