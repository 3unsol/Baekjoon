import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int K, cnt, max;
    static int[][] map = new int[5][5];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = -1;
        }

        dfs(0, 0, 1);

        System.out.println(cnt);
    }

    static void dfs(int r, int c, int size) {

        if(r == 4 && c == 4) { // 해빈이 만남
            if(size == 25 - K) { // 사과 수확 다 됐음
                cnt++;
            }
            if(max < size) {
                max = size;
            }
        }

        map[c][r] = -1;

        if(c > 0 && map[c - 1][r] != -1) {
            dfs(r, c - 1, size + 1);
        }
        if(c < 4 && map[c + 1][r] != -1) {
            dfs(r, c + 1, size + 1);
        }
        if(r > 0 && map[c][r - 1] != -1) {
            dfs(r - 1, c, size + 1);
        }
        if(r < 4 && map[c][r + 1] != -1) {
            dfs(r + 1, c, size + 1);
        }

        map[c][r] = 0; // 지나간 자리 원상복구
    }
}