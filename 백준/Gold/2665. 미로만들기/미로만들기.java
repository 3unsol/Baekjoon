import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];

        for(int r = 0; r < N; r++){
            String str = br.readLine();
            for(int c = 0; c < N; c++){
                int now = str.charAt(c) - '0';
                if(now == 0) {
                    now = 1;
                }else{
                    now = 0;
                }
                map[r][c] = now;
            }
        }

        bfs();

    }

    static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0));

        while(!pq.isEmpty()){

            Node now = pq.poll();

            if(now.r == N - 1 && now.c == N - 1){
                System.out.println(now.cost);
                return;
            }

            if(isVisited[now.r][now.c]) continue;
            isVisited[now.r][now.c] = true;

            for(int dir = 0; dir < 4; dir++){

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(canMove(nr, nc) && !isVisited[nr][nc]){
                    pq.offer(new Node(nr, nc, now.cost + map[nr][nc]));
                }

            }
        }
    }

    static boolean canMove(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < N;
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