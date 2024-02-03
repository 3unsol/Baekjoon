import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] dist;
    static boolean[][] isVisited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isVisited = new boolean[N][M];
        dist = new int[N][M];

        for(int r = 0; r < N; r++){
            String str = br.readLine();
            for(int c = 0; c < M; c++){
                map[r][c] = str.charAt(c) - '0';
                dist[r][c] = INF;
            }
        }

        dijkstra();

        System.out.println(dist[N - 1][M - 1]);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));
        dist[0][0] = 0;

        while(!pq.isEmpty()){

            Node now = pq.poll();

            if(isVisited[now.r][now.c]) continue;
            isVisited[now.r][now.c] = true;

            for(int dir = 0; dir < 4; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(!canMove(nr, nc) || isVisited[nr][nc]) continue;

                if(dist[nr][nc] < now.cost + map[nr][nc]) continue;

                pq.offer(new Node(nr, nc, now.cost + map[nr][nc]));
                dist[nr][nc] = now.cost + map[nr][nc];
            }
        }
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    static class Node implements Comparable<Node> {
        int r, c, cost;

        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
}