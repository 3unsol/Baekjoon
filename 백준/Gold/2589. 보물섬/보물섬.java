import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ans;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        String str;

        for(int r = 0; r < N; r++) {
            str = br.readLine();
            for(int c = 0; c < M; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(map[r][c] == 'L') {
                    int tmpAns = bfs(r, c);
                    ans = Math.max(tmpAns, ans);
                }
            }
        }

        System.out.println(ans);
    }

    static int bfs(int r, int c) {

        isVisited = new boolean[N][M];
        int cnt = 0;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c, 0));
        isVisited[r][c] = true;

        while(!q.isEmpty()) {

            Node now = q.poll();
            cnt = now.dist;

            for(int dir = 0; dir < 4; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(canMove(nr, nc) && map[nr][nc] == 'L' && !isVisited[nr][nc]) {
                    q.offer(new Node(nr, nc, now.dist + 1));
                    isVisited[nr][nc] = true;
                }
            }

        }
        
        return cnt;
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
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