import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, enemy, my;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        isVisited = new boolean[M][N];

        for(int r = 0; r < M; r++) {
            String str = br.readLine();
            for(int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(isVisited[r][c]) continue;
                int result = bfs(r, c);
                if(map[r][c] == 'W') {
                    my += result * result;
                }else {
                    enemy += result * result;
                }
            }
        }

        System.out.println(my + " " + enemy);
    }

    static int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c));
        isVisited[r][c] = true;
        int sum = 1;

        while(!q.isEmpty()) {

            Node now = q.poll();

            for(int dir = 0; dir < 4; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(canMove(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == map[r][c]) {
                    q.offer(new Node(nr, nc));
                    isVisited[nr][nc] = true;
                    sum++;
                }
            }
        }
        return sum;
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < M && c < N;
    }
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;

        }
    }
}