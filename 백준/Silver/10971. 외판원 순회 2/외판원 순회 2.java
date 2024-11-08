import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, ans;
    static int[][] cost;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        isVisited = new boolean[N];
        ans = Integer.MAX_VALUE;

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            isVisited[i] = true;
            dfs(i, i, 0, 0);
        }
        System.out.println(ans);
    }

    /**
     * 브루트포스
     * @param start 시작 노드
     * @param now 현재 노드
     * @param depth 깊이
     * @param sum 비용
     */
    static void dfs(int start, int now, int depth, int sum) {

        if(depth == N - 1) { // 모든 노드 다 돌았을 때
            if(cost[now][start] != 0) { // 현재 노드가 시작 노드와 연결되어 있으면
                sum += cost[now][start]; // 현재 비용 저장
                ans = Math.min(ans, sum); // 최소 비용
            }
            return;
        }

        // 모든 노드 탐색
        for(int i = 0; i < N; i++) {
            // 아직 방문 안 했고 현재 노드와 연결 되어 있을 때
            if(!isVisited[i] && cost[now][i] != 0) {
                isVisited[i] = true;
                dfs(start, i, depth + 1, sum + cost[now][i]);
                isVisited[i] = false;
            }
        }
    }
}