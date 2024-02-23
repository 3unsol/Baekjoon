import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        isVisited = new boolean[M][N];

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());

            for(int c = startC; c < endC; c++) {
                for(int r = startR; r < endR; r++) {
                    map[c][r] = 1;
                }
            }
        }

        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        for(int r = 0; r < M; r++) {
            for(int c = 0; c < N; c++) {
                if(!isVisited[r][c] && map[r][c] == 0) {
                    list.add(bfs(r, c));
                    cnt++;
                }
            }
        }

        Collections.sort(list);
        System.out.println(cnt);
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    static int bfs(int r, int c) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c));
        isVisited[r][c] = true;
        int dist = 1;

        while(!q.isEmpty()){

            Node now = q.poll();

            for(int dir = 0; dir < 4; dir++) {
                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if(canMove(nr, nc) && !isVisited[nr][nc] && map[nr][nc] == 0) {
                    q.offer(new Node(nr, nc));
                    isVisited[nr][nc] = true;
                    dist++;
                }
            }
        }

        return dist;
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