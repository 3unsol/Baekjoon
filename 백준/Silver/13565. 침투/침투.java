import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static String answer = "NO";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for(int r = 0; r < N; r++) {
            String str = br.readLine();
            for(int c = 0; c < M; c++) {
                map[r][c] = str.charAt(c) - '0';
            }
        }

        for(int c = 0; c < M; c++) {
            if(answer.equals("YES")) break;
            if(map[0][c] == 1 || isVisited[0][c]) continue;
            dfs(0, c);
        }

        System.out.println(answer);
    }

    static void dfs(int r, int c) {

        if(r == N - 1) {
            answer = "YES";
            return;
        }
        isVisited[r][c] = true;
        for(int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(canMove(nr, nc) && map[nr][nc] == 0 && !isVisited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}