import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        // 총 카메라 개수
        int answer = 0;
        
        // 마지막 카메라 위치
        int camera = -30000;
        
        // 진출 시간 순으로 정렬
        Arrays.sort(routes, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
            
        // 진출 시간이 빠른 차부터 차례로 탐색
        // 진입 시간이 카메라 위치보다 뒤에 있으면 카메라 추가 설치
        for(int i = 0; i < routes.length; i++) {
            if(routes[i][0] > camera) {
                camera = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}