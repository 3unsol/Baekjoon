import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R;
    static int[][] dist;
    static int[] value;
    static final int INF = 987654321;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        value = new int[N + 1];
        dist = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= N; c++) {
                if(r == c) {
                    dist[r][c] = 0;
                } else {
                    dist[r][c] = INF;
                }
            }
        }

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[start][end] = dist[end][start] = Math.min(dist[start][end], cost);
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

        int max = 0;

        for(int i = 1; i <= N; i++) {
            int sum = 0;
            for(int j = 1; j <= N; j++) {
                if(dist[i][j] <= M) {
                    sum += value[j];
                }
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}