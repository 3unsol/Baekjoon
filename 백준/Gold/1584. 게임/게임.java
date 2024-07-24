import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int SIZE = 501;
    static int WARNING = 1;
    static int DEATH = -1;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        map = new int[SIZE][SIZE];
        isVisited = new boolean[SIZE][SIZE];


        int N = Integer.parseInt(br.readLine());
        // 위험구역 표시
        input(N, WARNING);

        int M = Integer.parseInt(br.readLine());
        // 죽음구역 표시
        input(M, DEATH);

        // 탐색
        System.out.println(bfs());
    }

    static void input(int N, int value) throws Exception {

        for(int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int X1 = Integer.parseInt(st.nextToken());
            int Y1 = Integer.parseInt(st.nextToken());
            int X2 = Integer.parseInt(st.nextToken());
            int Y2 = Integer.parseInt(st.nextToken());

            for(int r = Math.min(X1, X2); r <= Math.max(X1, X2); r++) {
                for(int c = Math.min(Y1, Y2); c <= Math.max(Y1, Y2); c++) {
                    map[r][c] = value;
                }
            }
        }
    }

    static int bfs() {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        isVisited[0][0] = true;
        map[0][0] = 0;

        while(!pq.isEmpty()) {

            Node now = pq.poll();

            if(now.r == SIZE - 1 && now.c == SIZE - 1) {
                return now.cost;
            }

            for(int dir = 0; dir < 4; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(canMove(nr, nc) && !isVisited[nr][nc] && map[nr][nc] != DEATH) {
                    pq.offer(new Node(nr, nc, now.cost + map[nr][nc]));
                    isVisited[nr][nc] = true;
                }
            }
        }

        return -1;
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < SIZE && c < SIZE;
    }
    static class Node implements Comparable<Node> {
        int r, c, cost;
        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}