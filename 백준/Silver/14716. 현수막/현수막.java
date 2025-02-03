import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dc = {0, -1, 0, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(map[r][c] == 1 && !isVisited[r][c]) {
                    bfs(r, c);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c));
        isVisited[r][c] = true;

        while(!q.isEmpty()){
            Node now = q.poll();
            for(int dir = 0; dir < 8; dir++) {
                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];
                if(canMove(nr, nc) && map[nr][nc] == 1 && !isVisited[nr][nc]) {
                    q.offer(new Node(nr, nc));
                    isVisited[nr][nc] = true;
                }
            }
        }
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    static class Node{
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}