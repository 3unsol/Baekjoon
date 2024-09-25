import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static int[][] map;

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

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < R; i++) {
            int order = Integer.parseInt(st.nextToken());

            switch (order) {
                case 1 : one(); continue;
                case 2 : two(); continue;
                case 3 : three(); continue;
                case 4 : four(); continue;
                case 5 : five(); continue;
                case 6 : six();
            }
        }

        print();
    }

    /**
     * 1. 상하 반전
     */
    static void one() {
        int tmp;
        for(int i = 0; i < N / 2; i++) {
            for(int c = 0; c < M; c++) {
                tmp = map[i][c];
                map[i][c] = map[N - i - 1][c];
                map[N - i - 1][c] = tmp;
            }
        }
    }

    /**
     * 2. 좌우 반전
     */
    static void two() {
        int tmp;
        for(int i = 0; i < M / 2; i++) {
            for(int r = 0; r < N; r++) {
                tmp = map[r][i];
                map[r][i] = map[r][M - i - 1];
                map[r][M - i - 1] = tmp;
            }
        }
    }

    /**
     * 3. 오른쪽으로 90도 회전
     */
    static void three() {
        int tmp = N;
        N = M;
        M = tmp;
        int[][] copyMap = new int[N][M];
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                copyMap[r][c] = map[M - c - 1][r];
            }
        }
        map = copyMap;
    }

    /**
     * 4. 왼쪽으로 90도 회전
     */
    static void four() {
        int tmp = N;
        N = M;
        M = tmp;
        int[][] copyMap = new int[N][M];
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                copyMap[r][c] = map[c][N - r - 1];
            }
        }
        map = copyMap;
    }

    /**
     * 5. 4개로 나눠서 시계 방향 회전
     */
    static void five() {
        int[][] copyMap = new int[N][M];
        swap(copyMap, 0, 0, 0, M / 2);
        swap(copyMap, N / 2, 0, 0, 0);
        swap(copyMap, N / 2,  M / 2, N / 2, 0);
        swap(copyMap, 0, M / 2, N / 2, M / 2);
        map = copyMap;
    }

    /**
     * 6. 4개로 나눠서 반시계 방향 회전
     */
    static void six() {
        int[][] copyMap = new int[N][M];
        swap(copyMap, 0, 0, N / 2, 0);
        swap(copyMap, N / 2, 0, N / 2, M / 2);
        swap(copyMap, N / 2, M / 2, 0, M / 2);
        swap(copyMap, 0, M / 2, 0, 0);
        map = copyMap;
    }

    /**
     * 배열 출력
     */
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

    /**
     * 5, 6 분할 적용
     * @param copyMap (map에서 부분적으로 가져와서 담아주기)
     * @param r1 (부분1 r 좌표) // 가져올 값
     * @param c1 (부분1 c 좌표)
     * @param r2 (부분2 r 좌표) // 담을 위치
     * @param c2 (부분2 c 좌표)
     */
    static void swap(int[][] copyMap, int r1, int c1, int r2, int c2) {
        for(int r = 0; r < N / 2; r++) {
            for(int c = 0; c < M / 2; c++) {
                copyMap[r2 + r][c2 + c] = map[r1 + r][c1 + c];
            }
        }
    }
}