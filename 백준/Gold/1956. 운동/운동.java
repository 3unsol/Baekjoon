import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int V, E;
    static int[][] dist;
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1][V + 1];

        for(int r = 1; r <= V; r++) {
            for(int c = 1; c <= V; c++) {
                if(r == c) {
                    dist[r][c] = 0;
                } else {
                    dist[r][c] = INF;
                }
            }
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[a][b] = cost;
        }

        for(int k = 1; k <= V; k++) {
            for(int i = 1; i <= V; i++) {
                if(i == k) continue;
                for(int j = 1; j <= V; j++) {
                    if(j == i || j == k) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int ans = INF;

        for(int r = 1; r <= V; r++) {
            for(int c = r; c <= V; c++) {
                if(r != c) {
                    ans = Math.min(dist[r][c] + dist[c][r], ans);
                }
            }
        }

        if(ans == INF) {
            System.out.println(-1);
        }else {
            System.out.println(ans);
        }
    }
}