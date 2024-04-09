import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] dist;
    static final int INF = 100001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dist = new int[N + 1][N + 1];

            for(int r = 1; r <= N; r++) {
                for(int c = 1; c <= N; c++) {
                    if(r != c) dist[r][c] = INF;
                }
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                dist[a][b] = dist[b][a] = c;
            }

            for(int k = 1; k <= N; k++) {
                for(int i = 1; i <= N; i++) {
                    if(i == k) continue;
                    for(int j = 1; j <= N; j++) {
                        if(j == i || j == k) continue;
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }

            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] participants = new int[K];

            for(int i = 0; i < K; i++) {
                participants[i] = Integer.parseInt(st.nextToken());
            }

            int min = INF;
            int room = 0;

            for(int i = 1; i <= N; i++) {
                int sum = 0;
                for(int k = 0; k < K; k++) {
                    sum += dist[i][participants[k]];
                }
                if(min > sum) {
                    min = sum;
                    room = i;
                }
            }

            System.out.println(room);

        }
    }
}