import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, sheep, wolf;
    static char[][] map;
    static boolean[][] isVisited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        isVisited = new boolean[R][C];

        for(int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }

        int totalSheep = 0;
        int totalWolf = 0;

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(isVisited[r][c]) continue;
                if(map[r][c] == '.' || map[r][c] == '#') continue;
                sheep = wolf = 0;
                dfs(r, c);
                if(sheep > wolf)
                    totalSheep += sheep;
                else
                    totalWolf += wolf;
            }
        }

        System.out.println(totalSheep + " " + totalWolf);
    }

    static void dfs(int r, int c) {
        isVisited[r][c] = true;

        if(map[r][c] == 'v')
            wolf++;
        if(map[r][c] == 'o')
            sheep++;

        for(int dir = 0; dir < 4; dir++) {

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr < 0 || nr > R || nc < 0 || nc > C || isVisited[nr][nc] || map[nr][nc] == '#') continue;

            isVisited[nr][nc] = true;
            dfs(nr, nc);
        }
    }
}