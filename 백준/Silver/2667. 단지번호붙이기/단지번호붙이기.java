import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, cnt;
    static int[][] map;
    static List<Integer> result = new ArrayList<>();
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 단지 크기
        n = Integer.parseInt(br.readLine());
        // 단지 입력
        map = new int[n][n];
        for (int r = 0; r < n; r++) {
            String str = br.readLine();
            for (int c = 0; c < n; c++) {
                map[r][c] = str.charAt(c) - '0';
            }
        }
        visited = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!visited[r][c] && map[r][c] == 1) {
                    dfs(r, c);
                    result.add(cnt);
                    cnt = 0;
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static void dfs(int r, int c) {
        cnt++;
        visited[r][c] = true;
        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (nr < 0 || nc < 0 || nr >= n || nc >= n || visited[nr][nc]) continue;
            if (map[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }
}