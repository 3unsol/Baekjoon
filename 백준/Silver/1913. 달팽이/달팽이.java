import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N, target, targetR, targetC;
    static int[][] map;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        target = Integer.parseInt(br.readLine());
        map = new int[N][N];

        makeSnail();

        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(targetR).append(" ").append(targetC);
        System.out.print(sb);
    }

    static void makeSnail() {

        // 좌표, 방향
        int r = 0, c = 0, dir = 0;
        // 값
        int val = N * N;

        while(true) {

            if(val == target) {
                targetR = r + 1;
                targetC = c + 1;
            }
            if(val == 0) {
                return;
            }

            map[r][c] = val--;

            int nr = r + dr[dir];
            int nc = c + dc[dir];
            int nd = setDirection(nr, nc, dir);

            // 방향 바꾸기
            if(dir != nd) {
                r = r + dr[nd];
                c = c + dc[nd];
                dir = nd;
            } else { // 같으면 그대로
                r = nr;
                c = nc;
            }
        }
    }

    static int setDirection(int nr, int nc, int dir) {
        // 범위 밖
        if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
            dir = (dir + 1) % 4;
        }
        // 이미 자리 차지
        else if(map[nr][nc] != 0) {
            dir = (dir + 1) % 4;
        }
        return dir;
    }
}