import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] dist;
    static int startR, startC, endR, endC;
    static final int INF = 987654321;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        dist = new int[N + 1][M + 1];

        st = new StringTokenizer(br.readLine());
        startR = Integer.parseInt(st.nextToken());
        startC = Integer.parseInt(st.nextToken());
        endR = Integer.parseInt(st.nextToken());
        endC = Integer.parseInt(st.nextToken());

        for(int r = 1; r <= N; r++) {
            String str = br.readLine();
            for(int c = 1; c <= M; c++) {
                char val = str.charAt(c - 1);
                if(val == '*' || val == '0') {
                    map[r][c] = 0;
                } else {
                    map[r][c] = 1;
                }
                dist[r][c] = INF;
            }
        }

        dijkstra();
        System.out.println(dist[endR][endC]);
    }

    static void dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startR, startC, 0));
        dist[startR][startC] = 0;

        while(!pq.isEmpty()) {

            Node now = pq.poll();

//            if(dist[now.r][now.c] < now.cost) {
//                continue;
//            }

            for(int dir = 0; dir < 4; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(canMove(nr, nc)) {
                    if(dist[nr][nc] > dist[now.r][now.c] + map[nr][nc]) {
                        dist[nr][nc] = dist[now.r][now.c] + map[nr][nc];
                        pq.offer(new Node(nr, nc, dist[nr][nc]));
                    }
                }
            }
        }
    }

    static boolean canMove(int r, int c) {
        return r > 0 && c > 0 && r <= N && c <= M;
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