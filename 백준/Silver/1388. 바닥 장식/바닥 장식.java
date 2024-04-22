import javax.xml.parsers.SAXParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dir = {-1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for(int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        isVisited = new boolean[R][C];

        int cnt = 0;

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(isVisited[r][c]) continue;
                dfs(r, c);
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int r, int c) {

        isVisited[r][c] = true;

        if(map[r][c] == '-') {

            for(int d = 0; d < 2; d++) {

                int nc = c + dir[d];

                if(nc >= 0 && nc < C && !isVisited[r][nc] && map[r][nc] == '-') {
                    dfs(r, nc);
                }
            }
        } else {

            for(int d = 0; d < 2; d++) {

                int nr = r + dir[d];

                if(nr >= 0 && nr < R && !isVisited[nr][c] && map[nr][c] != '-') {
                    dfs(nr, c);
                }
            }
        }
    }
}