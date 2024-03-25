import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 파티장 번호
        N = Integer.parseInt(st.nextToken());
        // 서비스 요청 인원
        M = Integer.parseInt(st.nextToken());
        // 직접 갈 수 있는 시간
        map = new int[N + 1][N + 1];

        // 직접 갈 수 있는 시간을 저장한 맵
        for(int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 경출도
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                if(i == k) continue;
                for(int j = 1; j <= N; j++) {
                    if(j == i || j == k) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        // 요청하신 서비스입니다.
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            if(map[start][end] <= limit) {
                sb.append("Enjoy other party");
            } else {
                sb.append("Stay here");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}