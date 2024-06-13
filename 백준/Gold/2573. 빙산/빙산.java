import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, time;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int ans = 0;

        while((cnt = count()) < 2) {

            if(cnt == 0) {
                ans = 0;
                break;
            }
            melting();
            ans++;
        }

        System.out.println(ans);
    }

    /**
     * 빙산 녹이기
     * 미리 녹여버리면 빙산이었던 곳도 바다로 치게 돼서 과하게 녹여버림
     */
    static void melting() {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M]; // 0 && visited == true -> 빙산이었다가 바다가 된 애

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(map[r][c] != 0) {
                    q.offer(new Node(r, c));
                    visited[r][c] = true;
                }
            }
        }

        while(!q.isEmpty()) {

            Node now = q.poll();

            int seaCnt = 0; // 빙산 사방에 있는 바다 개수 저장

            for(int dir = 0; dir < 4; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(canMove(nr, nc) && !visited[nr][nc] && map[nr][nc] == 0) {
                    seaCnt++;
                }
            }

            if(map[now.r][now.c] - seaCnt < 0) {
                map[now.r][now.c] = 0;
            } else {
                map[now.r][now.c] -= seaCnt;
            }
        }
    }

    /**
     * 빙산 개수 세기 -1
     * @return cnt int
     */
    static int count() {
        isVisited = new boolean[N][M];
        int cnt = 0;
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(!isVisited[r][c] && map[r][c] != 0) {
                    bfs(r, c);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * 빙산 개수 세기 -2
     * @param r int
     * @param c int
     */
    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c));

        while(!q.isEmpty()) {

            Node now = q.poll();

            if(!isVisited[now.r][now.c]) {
                isVisited[now.r][now.c] = true;

                for(int dir = 0; dir < 4; dir++) {

                    int nr = now.r + dr[dir];
                    int nc = now.c + dc[dir];

                    if(canMove(r, c) && !isVisited[nr][nc] && map[nr][nc] != 0) {
                        q.offer(new Node(nr, nc));
                    }
                }
            }
        }
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}