import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] map;
    static Coin[] coins = new Coin[2];
    static boolean[][][][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        isVisited = new boolean[N][M][N][M];

        int index = 0;
        for(int r = 0; r < N; r++) {
            String str = br.readLine();
            for(int c = 0; c < M; c++) {
                map[r][c] = str.charAt(c);
                if(map[r][c] == 'o') coins[index++] = new Coin(r, c);
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<twoCoins> q = new ArrayDeque<>();
        q.offer(new twoCoins(coins[0].r, coins[0].c, coins[1].r, coins[1].c, 0));
        isVisited[coins[0].r][coins[0].c][coins[1].r][coins[1].c] = true;

        while(!q.isEmpty()) {

            twoCoins now = q.poll();

            if(now.depth >= 10) break;

            for(int dir = 0; dir < 4; dir++) {
                int nr1 = now.r1 + dr[dir];
                int nc1 = now.c1 + dc[dir];
                int nr2 = now.r2 + dr[dir];
                int nc2 = now.c2 + dc[dir];

                // 벽이면 이동X
                if(canMove(nr1, nc1) && map[nr1][nc1] == '#') {
                    nr1 = now.r1;
                    nc1 = now.c1;
                }
                if(canMove(nr2, nc2) && map[nr2][nc2] == '#') {
                    nr2 = now.r2;
                    nc2 = now.c2;
                }

                int fallCnt = 0;
                if(!canMove(nr1, nc1)) fallCnt++;
                if(!canMove(nr2, nc2)) fallCnt++;

                if(fallCnt == 1) return now.depth + 1;
                else if(fallCnt == 0 && !isVisited[nr1][nc1][nr2][nc2]) {
                    isVisited[nr1][nc1][nr2][nc2] = true;
                    q.offer(new twoCoins(nr1, nc1, nr2, nc2, now.depth + 1));
                }
            }
        }
        return -1;
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    static class twoCoins {
        int r1, c1, r2, c2, depth;
        twoCoins(int r1, int c1, int r2, int c2, int depth) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.depth = depth;
        }
    }
    static class Coin {
        int r, c;
        Coin(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
