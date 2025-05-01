import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, angle;
    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            angle = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for(int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            if(angle == 360 || angle == -360) {
                sb = new StringBuilder();
                makeAnswer(map);
            } else if(angle < 0) {
                rotate((360 + angle) / 45);
            } else {
                rotate(angle / 45);
            }
        }
    }

    static void rotate(int cnt) {

        sb = new StringBuilder();
        int mid = N / 2;

        for(int i = 0; i < cnt; i++) {
            int[][] newMap = new int[N][N];
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    // 주 대각선 -> 가운데 열
                    if(r == c) {
                        newMap[r][c] = map[mid][c];
                    } else if(r == mid) { // 가운데 열 -> 부 대각선
                        newMap[r][c] = map[N - c - 1][c];
                    } else if(r + c == N - 1) { // 부 대각선 -> 가운데 행
                        newMap[r][c] = map[r][mid];
                    } else if(c == mid) { // 가운데 행 -> 주 대각선
                        newMap[r][c] = map[r][r];
                    } else { // 나머지
                        newMap[r][c] = map[r][c];
                    }
                }
            }
            map = newMap.clone();
        }
        makeAnswer(map);
    }

    static void makeAnswer(int[][] map) {
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N; c++) {
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}