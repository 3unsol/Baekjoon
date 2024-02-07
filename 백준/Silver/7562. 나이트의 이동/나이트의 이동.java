import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static int startR, startC, endR, endC;
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            st = new StringTokenizer(br.readLine());
            startR = Integer.parseInt(st.nextToken());
            startC = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endR = Integer.parseInt(st.nextToken());
            endC = Integer.parseInt(st.nextToken());

            bfs();
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startR, startC));
        map[startR][startC] = 1;

        while(!q.isEmpty()) {

            Node now = q.poll();

            if(now.r == endR && now.c == endC) {
                System.out.println(map[endR][endC] - 1);
                return;
            }

            for(int dir = 0; dir < 8; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(canMove(nr, nc) && map[nr][nc] == 0) {
                    q.offer(new Node(nr, nc));
                    map[nr][nc] = map[now.r][now.c] + 1;
                }
            }
        }
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}