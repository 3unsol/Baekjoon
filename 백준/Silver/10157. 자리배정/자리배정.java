import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int C, R, K;
    static boolean[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new boolean[R][C];

        K = Integer.parseInt(br.readLine());

        if(K > C * R) {
            System.out.println(0);
            return;
        }

        int cnt = 0;
        int dir = 0;
        int r = R - 1;
        int c = 0;

        while(++cnt != K) {

            map[r][c] = true;
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr < 0 || nc < 0 || nr >= R || nc >= C || map[nr][nc]) {
                dir = ++dir % 4;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }
            r = nr;
            c = nc;
        }

        System.out.println((c + 1) + " " + (R - r));
    }
}