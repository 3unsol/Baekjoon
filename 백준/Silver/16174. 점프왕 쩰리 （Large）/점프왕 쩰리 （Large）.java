import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N][N];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0));
        isVisited[0][0] = true;

        while(!q.isEmpty()) {

            Node now = q.poll();

            if(map[now.r][now.c] == -1) {
                System.out.println("HaruHaru");
                return;
            }

            for(int dir = 0; dir < 2; dir++) {

                int nr = now.r + dr[dir] * map[now.r][now.c];
                int nc = now.c + dc[dir] * map[now.r][now.c];

                if(nr >= N || nc >= N || nr < 0 || nc < 0 || isVisited[nr][nc]) continue;

                isVisited[nr][nc] = true;
                q.offer(new Node(nr, nc));
            }
        }

        System.out.println("Hing");

    }

    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}