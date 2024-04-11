import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int W, H;
    static int[][] map;
    static boolean[][] isVisited;
    static Queue<Node> q;
    static Queue<Node> fire;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            isVisited = new boolean[H][W];
            q = new LinkedList<>();
            fire = new LinkedList<>();

            for(int r = 0; r < H; r++) {
                String str = br.readLine();
                for(int c = 0; c < W; c++) {
                    char sign = str.charAt(c);

                    // 상근이
                    if(sign == '@') {
                        q.offer(new Node(r, c, 0));
                        isVisited[r][c] = true;
                        map[r][c] = -1;

                        // 불
                    }else if(sign == '*'){
                        map[r][c] = 0;
                        fire.offer(new Node(r, c, 0));

                        // 벽
                    }else if(sign == '#') {
                        map[r][c] = -2;

                        // 길
                    }else {
                        map[r][c] = -1;
                    }
                }
            }

            fired();

            int result = bfs();

            if(result == -1) {
                System.out.println("IMPOSSIBLE");
            }else {
                System.out.println(result);
            }

        }
    }

    static void fired() {
        while(!fire.isEmpty()) {

            Node now = fire.poll();

            for(int dir = 0; dir < 4; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                // 이동 불가
                if(!canMove(nr, nc)) continue;
                // 벽
                if(map[nr][nc] == -2) continue;
                // 이미 간 곳
                if(map[nr][nc] >= 0) continue;

                // 맵에 불이 몇 초에 퍼지는지 저장
                map[nr][nc] = now.dist + 1;
                fire.offer(new Node(nr, nc, now.dist + 1));
            }
        }
    }

    static int bfs() {
        while(!q.isEmpty()) {

            Node now = q.poll();

            if(now.r == 0 || now.c == 0 || now.r == H - 1 || now.c == W - 1) {
                return now.dist + 1;
            }

            for(int dir = 0; dir < 4; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                // 끝쪽
                if(nr < 0 || nr >= H || nc < 0 || nc >= W) return now.dist + 1;
                // 이미 들른 곳
                if(isVisited[nr][nc]) continue;
                // 벽
                if(map[nr][nc] == -2) continue;
                // 나보다 먼저 불이 번진 곳
                if(map[nr][nc] != -1 && map[nr][nc] <= now.dist + 1) continue;

                isVisited[nr][nc] = true;
                q.offer(new Node(nr, nc, now.dist + 1));
            }
        }
        return -1;
    }
    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < H && c < W;
    }
    static class Node {
        int r, c, dist;
        Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}