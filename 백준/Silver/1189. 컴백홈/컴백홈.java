import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, K, cnt;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for(int r = 0; r < R; r++) {
            String str = br.readLine();
            for(int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        isVisited = new boolean[R][C];
        isVisited[R - 1][0] = true;

        dfs(R - 1, 0, 1);

        System.out.println(cnt);
    }

    static void dfs(int r, int c, int depth) {

        if(r == 0 && c == C - 1 && depth == K) {
            cnt++;
            return;
        }

        for(int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(canMove(nr, nc) && !isVisited[nr][nc]) {
                isVisited[nr][nc] = true;
                dfs(nr, nc, depth + 1);
                isVisited[nr][nc] = false;
            }
        }
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C && map[r][c] != 'T';
    }
}