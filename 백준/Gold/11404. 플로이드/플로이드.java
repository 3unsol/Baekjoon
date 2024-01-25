import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] dist;
    static final int INF = 987654321; // Integer.MAX_VALUE로 하면 안 됨

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        dist = new int[n + 1][n + 1];

        // 본인과의 비용응 0, 나머지는 최대값으로 설정
        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= n; c++) {
                if (r == c) {
                    dist[r][c] = 0;
                } else {
                    dist[r][c] = INF;
                }
            }
        }

        // 들어오는 비용과 이미 적혀있는 비용 비교해서 최솟값으로 갱신
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], cost);
        }

        // k: 경유할 노드 번호, i: 시작 노드, j: 도착 노드
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) dist[i][j] = 0;
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}