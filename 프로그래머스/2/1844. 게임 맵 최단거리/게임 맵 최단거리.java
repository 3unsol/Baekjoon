import java.util.*;

// 모든 경로 탐색 : dfs
// 최단 거리 탐색 : bfs

class Solution {
    
    static int[][] map;
    static int N, M;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int answer = -1;
    
    public int solution(int[][] maps) {
        
        map = maps;
        N = maps.length;
        M = maps[0].length;
        isVisited = new boolean[N][M];
        
        bfs(0, 0);
        
        return answer;
    }
    
    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c, 1));
        isVisited[r][c] = true;
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            if(now.r == N - 1 && now.c == M - 1) {
                answer = now.depth;
                return;
            }
            for(int dir = 0; dir < 4; dir++) {
                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];
                if(canMove(nr, nc) && map[nr][nc] == 1 && !isVisited[nr][nc]) {
                    q.offer(new Node(nr, nc, now.depth + 1));
                    isVisited[nr][nc] = true;
                }
            }
        }
        
    }
    
    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
    
    static class Node {
        int r, c, depth;
        Node(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
}