import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int depth = Math.min(N, M) / 2;

        for(int i = 0; i < depth; i++) {
            // 각 라인에 있는 요소 개수 만큼 돌면 원점 -> 나머지 연산
            // 변 길이 2N + 2M = (N + M) * 2에서 꼭지점 4개 겹치는 거 빼주기
            int cnt = R % (((N - 2 * i) + (M - 2 * i)) * 2 - 4);
            for(int j = 0; j < cnt; j++) {
                rotate(i);
            }
        }

        print();
    }

    static void rotate(int t) {

        int dir = 0;
        int r = t, c = t;
        int tmp = map[r][c];

        while(dir < 4) {

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr >= t && nc >= t && nr < N - t && nc < M - t) {
                map[r][c] = map[nr][nc];
                r = nr; c = nc;
            } else {
                dir++;
            }
        }

        map[t + 1][t] = tmp;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}