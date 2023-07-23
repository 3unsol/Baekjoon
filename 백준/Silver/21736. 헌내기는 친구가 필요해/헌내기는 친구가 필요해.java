import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int row, col, cnt;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new char[row][col];
        visited = new boolean[row][col];
        cnt = 0;
        int startR = 0;
        int startC = 0;
        for(int r = 0; r < row; r++){
            String str = br.readLine();
            for(int c = 0; c < col; c++){
                map[r][c] = str.charAt(c);
                if(map[r][c] == 'I'){
                    startR = r;
                    startC = c;
                }
            }
        }
        dfs(startR, startC);
        if(cnt == 0) System.out.println("TT");
        else System.out.println(cnt);
    }
    public static void dfs(int r, int c){
        visited[r][c] = true;
        for(int dir = 0; dir < 4; dir++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(nr < 0 || nc < 0 || nr >= row || nc >= col || visited[nr][nc] || map[nr][nc] == 'X') continue;
            else if(map[nr][nc] == 'P') {
                cnt++;
                dfs(nr, nc);
            }
            else {
                dfs(nr, nc);
            }
        }
    }
}