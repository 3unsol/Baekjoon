import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점 개수
        n = Integer.parseInt(st.nextToken());
        // 간선 개수
        m = Integer.parseInt(st.nextToken());
        // 인접 행렬
        map = new int[n + 1][n + 1];
        // 방문처리
        visited = new boolean[n + 1];
        // 인접 행렬 입력
        for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }
        // 무리 개수
        int cnt = 0;
        // 모든 정점 확인
        for(int i = 1; i <= n; i++) {
            // 방문 했으면 안 봄
            if (visited[i]) continue;
            dfs(i);
            // 탐색 끝나면 무리 한 개 완성
            cnt++;
        }
        System.out.println(cnt);
    }
    public static void dfs(int i){
        // 방문처리
        visited[i] = true;
        // 인접 행렬 확인 후 탐색 시작
        for(int j = 1; j <= n; j++){
            if(!visited[j] && map[i][j] == 1){
                dfs(j);
            }
        }
    }
}