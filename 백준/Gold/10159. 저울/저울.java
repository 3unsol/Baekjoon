import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            dist[i][i] = 1;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = 1;
            dist[b][a] = -1;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    } else if (dist[i][k] == -1 && dist[k][j] == -1) {
                        dist[i][j] = -1;
                    }
                }
            }
        }

        for(int r = 1; r <= N; r++) {
            int cnt = 0;
            for(int c = 1; c <= N; c++) {
                if(dist[r][c] == 0) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}