import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1][N + 1];

        for(int r = 1; r <= N; r++) {
            dist[r][r] = 0;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());

            dist[before][after] = -1;
            dist[after][before] = 1;
        }

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                if(i == k) continue;
                for(int j = 1; j <= N; j++) {
                    if(j == i || j == k) continue;
                    if(dist[i][k] == -1 && dist[k][j] == -1) {
                        dist[i][j] = -1;
                    }else if(dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dist[a][b]).append("\n");
        }

        System.out.println(sb);
    }
}