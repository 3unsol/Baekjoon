import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, cnt;
    static int[][] map;
    static boolean[][] isTop;
    static int[] dr = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dc = {0, -1, 0, 1, -1, 1, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        isTop = new boolean[N][M];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(!isTop[r][c] && map[r][c] != 0) {
                    bfs(r, c);
                }
            }
        }

        System.out.println(cnt);
    }

    static void bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] isVisited = new boolean[N][M];
        List<Node> list = new ArrayList<>();
        q.offer(new Node(r, c));
        isVisited[r][c] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();
            for(int dir = 0; dir < 8; dir++) {
                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];
                if(!canMove(nr, nc) || isVisited[nr][nc]) continue;

                if(map[r][c] < map[nr][nc]) {
                    return;
                } else if(map[r][c] == map[nr][nc]) {
                    q.offer(new Node(nr, nc));
                    list.add(new Node(nr, nc));
                }
                isVisited[nr][nc] = true;
            }
        }

        for(Node now : list) {
            isTop[now.r][now.c] = true;
        }
        cnt++;
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
