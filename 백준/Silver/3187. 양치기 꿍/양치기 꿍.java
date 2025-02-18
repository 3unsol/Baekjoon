import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int R, C, sheep, wolf;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static boolean[][] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int r = 0; r < R; r++) {
            String str = br.readLine();
            for(int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        isVisited = new boolean[R][C];

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(map[r][c] != '#' && !isVisited[r][c]) {
                    bfs(r, c);
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c));
        isVisited[r][c] = true;

        int sheepCnt = 0;
        int wolfCnt = 0;

        while(!q.isEmpty()) {
            Node now = q.poll();
            if(map[now.r][now.c] == 'k') {
                sheepCnt++;
            } else if(map[now.r][now.c] == 'v') {
                wolfCnt++;
            }
            for(int dir = 0; dir < 4; dir++) {
                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];
                if(canMove(nr, nc) && map[nr][nc] != '#' && !isVisited[nr][nc]) {
                    q.offer(new Node(nr, nc));
                    isVisited[nr][nc] = true;
                }
            }
        }

        if(sheepCnt > wolfCnt) {
            sheep += sheepCnt;
        } else {
            wolf += wolfCnt;
        }
    }
    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}