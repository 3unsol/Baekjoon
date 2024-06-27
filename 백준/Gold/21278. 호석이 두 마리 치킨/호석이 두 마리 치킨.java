import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, chicken1, chicken2, min;
    static int[][] dist;
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 플로이드 와샬을 위해 INF값으로 초기화
        dist = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(i != j) dist[i][j] = INF;
            }
        }

        // 간선 입력
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = dist[b][a] = 1;
        }

        floydWarshall();
        bruteForce();

        System.out.printf("%d %d %d", chicken1, chicken2, min);
    }

    static void floydWarshall() {

        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                if(k == i) continue;
                for(int j = 1; j <= N; j++) {
                    if(k == j || i == j) continue;
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    static void bruteForce() {

        min = INF;

        for(int i = 1; i < N; i++) { // 첫 번째 치킨집
            for(int j = i + 1; j <= N; j++) { // 두 번째 치킨집
                int sum = 0;
                for(int k = 1; k <= N; k++) { // 모든 집 방문
                    sum += Math.min(dist[i][k], dist[k][j]) * 2; // 더 가까운 치킨집 거리 저장 (왕복)
                }
                if(sum < min) {
                    chicken1 = i;
                    chicken2 = j;
                    min = sum;
                }
            }
        }
    }
}