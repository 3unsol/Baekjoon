import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[][] map;
    static final int HORIZON = 0;
    static final int VERTICAL = 1;
    static final int DIAGONAL = 2;
    static int ans;

    static Node start = new Node(HORIZON, 0, 1);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < N; c++) {
                if(Integer.parseInt(st.nextToken()) == 1){
                    map[r][c] = true;
                }
            }
        }

        bfs();

        System.out.println(ans);
    }

    static void bfs(){

        Queue<Node> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){

            Node now = q.poll();

            if(now.r == N - 1 && now.c == N - 1) {
                ans++;
            }

            int nr = now.r + 1;
            int nc = now.c + 1;

            if(canMove(nr, nc) && !map[nr][nc] && !map[now.r][nc] && !map[nr][now.c]) {
                q.offer(new Node(DIAGONAL, nr, nc));
            }

            if(now.direction == HORIZON) {

                if(canMove(now.r, nc) && !map[now.r][nc]) {
                    q.offer(new Node(HORIZON, now.r, nc));
                }

            } else if(now.direction == VERTICAL) {

                if(canMove(nr, now.c) && !map[nr][now.c]) {
                    q.offer(new Node(VERTICAL, nr, now.c));
                }

            } else {

                if(canMove(now.r, nc) && !map[now.r][nc]) {
                    q.offer(new Node(HORIZON, now.r, nc));
                }

                if(canMove(nr, now.c) && !map[nr][now.c]) {
                    q.offer(new Node(VERTICAL, nr, now.c));
                }

            }
        }
    }

    static boolean canMove(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < N && nc < N;
    }

    static class Node {
        int direction, r, c;

        Node(int direction, int r, int c) {
            this.direction = direction;
            this.r = r;
            this.c = c;
        }
    }
}