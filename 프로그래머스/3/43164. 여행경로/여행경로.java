import java.util.*;

class Solution {
    
    static boolean[] isVisited;
    static List<String> result;
    
    public String[] solution(String[][] tickets) {
        
        isVisited = new boolean[tickets.length];
        result = new ArrayList<>();
        
        // 완전탐색
        dfs("ICN", "ICN", 0, tickets);
        
        // 사전순 정렬
        Collections.sort(result);
        
        // 젤 앞에 있는 경로
        String[] answer = result.get(0).split(" ");
        
        return answer;
    }
    
    // 모든 공항을 방문하기 위해 완전탐색
    // 출발지, 경로, 깊이, 티켓배열
    static void dfs(String start, String sum, int depth, String[][] tickets) {
        // 모두 들렀다
        if(depth == tickets.length) {
            // 만들어진 경로 list에 추가
            result.add(sum);
            return;
        }
        
        // 이동
        for(int i = 0; i < tickets.length; i++) {
            // 출발지에서 갈 수 있고 아직 방문 안 한 곳
            if(tickets[i][0].equals(start) && !isVisited[i]) {
                isVisited[i] = true;
                dfs(tickets[i][1], sum + " " + tickets[i][1], depth + 1, tickets);
                isVisited[i] = false;
            }
        }
    }
}