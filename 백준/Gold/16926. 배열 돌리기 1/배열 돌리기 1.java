import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        K = Integer.parseInt(st.nextToken());

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < K; i++) {
            spin();
        }
        print();
    }

    static void spin() {

        // 깊이
        int depth = Math.min(N, M) / 2;

        for(int i = 0; i < depth; i++) {

            // 0: 우, 1: 하, 2: 좌, 3: 상
            int dir = 0;

            // 시작 좌표
            int r = i, c = i;

            // 시작 좌표값 저장
            int tmp = map[r][c];

            while(dir < 4) {

                int nr = r + dr[dir];
                int nc = c + dc[dir];

                if(nr >= i && nc >= i && nr < N - i && nc < M - i) {
                    map[r][c] = map[nr][nc];
                    r = nr; c = nc;
                } else {
                    dir++;
                }
            }

            map[i + 1][i] = tmp;
        }
    }

    static void print() {
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
    }
}