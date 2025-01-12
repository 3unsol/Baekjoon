import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 요청 시간 순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        
        // 대기 큐
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        
        // 작업을 시작할 수 있는 시간
        int startTime = jobs[0][0];
        
        // 총 작업 시간
        int totalSum = 0;
        
        // 현재 작업중인 인덱스
        int index = 0;
        
        // 중복으로 넣는 거 방지
        boolean[] isUsed = new boolean[jobs.length];
        
        // 요청시간 순으로 모든 작업 확인
        while(index < jobs.length) {
            
            // 작업중에 요청이 들어온 작업들 대기 큐에 넣기
            for(int i = index; i < jobs.length; i++) {
                if(!isUsed[i] && startTime >= jobs[i][0]) {
                    q.offer(jobs[i]);
                    isUsed[i] = true;
                }
            }
            
            if(!q.isEmpty()) {  
                // 작업할 거 빼기
                int[] now = q.poll();

                // 반환 시간 계산
                totalSum += startTime - now[0] + now[1];

                // 작업이 끝났을 때 시간
                startTime += now[1];

                // 완료한 작업 개수
                index++;
            } else { // 큐가 비었다!
                startTime = jobs[index][0];
            }
        }
        
        answer = totalSum / jobs.length;
        
        return answer;
    }
}