import java.util.*;

// https://jyeonnyang2.tistory.com/247 (참고)

class Solution {
    
    static int answer;
    static int[][] map = new int[101][101];
    static boolean[][] isVisited = new boolean[101][101];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // map에 사각형 정보 입력
        // 사각형 내부 : 1
        // 외부 테두리 : 2
        for(int i = 0; i < rectangle.length; i++) {
            
            // map과 좌표값을 2배로 하는 이유
            // 11 좌표 -> 2차원 배열로 입력하면서
            // 11 이런 모양이 나왔을 때 최단거리가 더 짧게 나오게 됨
            // 1  map 크기를 2배로 늘려서 좌표 사이의 거리를 표현
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            for(int y = y1; y <= y2; y++) {
                for(int x = x1; x <= x2; x++) {
                    // 이미 어떤 사각형의 내부라면 넘어감
                    if(map[y][x] == 1) continue;
                    // 사각형 내부라고 표시
                    map[y][x] = 1;
                    // 테두리일 때
                    if(y == y1 || y == y2 || x == x1 || x == x2) {
                        map[y][x] = 2;
                    }
                }
            }
        }
        
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        
        return answer;
    }
    
    static void bfs(int x, int y, int itemX, int itemY) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(y, x, 0));
        isVisited[y][x] = true;
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            // 아이템 줍줍
            if(now.y == itemY && now.x == itemX) {
                answer = now.depth / 2;
                return;
            }
            // 사방탐색
            for(int dir = 0; dir < 4; dir++) {
                int ny = now.y + dy[dir];
                int nx = now.x + dx[dir];
                // 테두리일 때만 이동 가능
                if(canMove(ny, nx) && map[ny][nx] == 2 && !isVisited[ny][nx]) {
                    q.offer(new Node(ny, nx, now.depth + 1));
                    isVisited[ny][nx] = true;
                }
            }
        }
    }
    
    static boolean canMove(int y, int x) {
        return y >= 0 && x >= 0 && y < map.length && x < map[0].length;
    }
    
    static class Node {
        int y, x, depth;
        Node(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}