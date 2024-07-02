import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, startR, startC, endR, endC;
    static boolean[][] isVisited;
    static int[] dr = {-2, -2, 0, 0, 2, 2};
    static int[] dc = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        startR = Integer.parseInt(st.nextToken());
        startC = Integer.parseInt(st.nextToken());
        endR = Integer.parseInt(st.nextToken());
        endC = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    static int bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        isVisited = new boolean[N][N];

        pq.offer(new Node(startR, startC, 0));
        isVisited[startR][startC] = true;

        while(!pq.isEmpty()){

            Node now = pq.poll();

            if(now.r == endR && now.c == endC) {
                return now.depth;
            }

            for(int dir = 0; dir < 6; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(canMove(nr, nc) && !isVisited[nr][nc]) {
                    pq.offer(new Node(nr, nc, now.depth + 1));
                    isVisited[nr][nc] = true;
                }
            }
        }

        return -1;
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    static class Node implements Comparable<Node> {
        int r, c, depth;
        Node(int r, int c, int depth) {
            this.r = r;
            this.c = c;
            this.depth = depth;
        }

        @Override
        public int compareTo(Node o) {
            return this.depth - o.depth;
        }
    }
}