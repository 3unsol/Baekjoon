import java.util.*;

/**
0. 한 지점에서 모든 지점까지의 최단 거리 -> 다익스트라
1. 간선 정보 List로 저장
2. isVisited 배열에 INF값 초기화
2-1. isVisited 배열에 최단 거리 갱신
3. 최장 최단 거리 개수 세기
**/

class Solution {
    
    static final int INF = Integer.MAX_VALUE;
    static int[] isVisited;
    static List<ArrayList<Integer>> list = new ArrayList<>();
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 최단거리 저장 배열 초기화
        isVisited = new int[n + 1];
        Arrays.fill(isVisited, INF);
        
        // 간선 리스트
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        // 간선 정보 저장
        for(int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            list.get(a).add(b);
            list.get(b).add(a);
        }
            
        dijkstra(1);
        
        int max = 0;
        
        for(int i = 1; i <= n; i++) {
            if(isVisited[i] == INF) continue;
            if(isVisited[i] > max) {
                max = isVisited[i];
                answer = 0;
            }
            if(max == isVisited[i]) answer++;
        }
        
        return answer;
    }
    
    public void dijkstra(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        isVisited[1] = 0;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : list.get(now)) {
                if(isVisited[next] > isVisited[now] + 1) {
                    isVisited[next] = isVisited[now] + 1;
                    q.offer(next);
                }
            }
        }
    }
}