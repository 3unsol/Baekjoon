import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  -1 : 지훈이가 갈 수 있는 곳
 *  -2 : 지훈이가 갈 수 없는 곳
 */

public class Main {

    static int R, C;
    static int[][] map;
    static Queue<Node> jihoonQ = new LinkedList<>();
    static Queue<Node> fireQ = new LinkedList<>();
    static boolean[][] isJihoonVisited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        input();
        fired();
        int result = bfs();
        if(result == -1){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(result);
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        isJihoonVisited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                if (str.charAt(c) == 'J') {
                    map[r][c] = -1;
                    jihoonQ.offer(new Node(r, c, 0));
                    isJihoonVisited[r][c] = true;
                } else if (str.charAt(c) == 'F') {
                    map[r][c] = 0;
                    fireQ.offer(new Node(r, c, 0));
                } else if (str.charAt(c) == '#') {
                    map[r][c] = -2;
                } else {
                    map[r][c] = -1;
                }
            }
        }
    }

    static void fired(){
        while(!fireQ.isEmpty()){
            Node now = fireQ.poll();
            for(int dir = 0; dir < 4; dir++){
                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];
                if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if(map[nr][nc] == -2) continue;
                if(map[nr][nc] >= 0) continue;
                map[nr][nc] = now.depth + 1;
                fireQ.offer(new Node(nr, nc, now.depth + 1));
            }
        }
    }

    static int bfs(){
        while(!jihoonQ.isEmpty()){
            Node now = jihoonQ.poll();
            if(now.r == 0 || now.c == 0 || now.r == R - 1 || now.c == C - 1){
                return now.depth + 1;
            }
            for(int dir = 0; dir < 4; dir++){
                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];
                if(nr < 0 || nr >= R || nc < 0 || nc >= C) return now.depth + 1;
                if(isJihoonVisited[nr][nc]) continue;
                if(map[nr][nc] == -2) continue;
                if(map[nr][nc] != -1 && map[nr][nc] <= now.depth + 1) continue;
                isJihoonVisited[nr][nc] = true;
                jihoonQ.offer(new Node(nr, nc, now.depth + 1));
            }
        }
        return -1;
    }
    public static class Node{
        int r, c, depth;
        public Node(int r, int c, int depth){
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }
}