import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, startR, startC, d, cnt;
    static int[][] room;
    static boolean[][] isCleaned;
    static final int[] DR = {-1, 0, 1, 0};
    static final int[] DC = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        clean(startR, startC);
        System.out.println(cnt);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];
        isCleaned = new boolean[n][m];
        st = new StringTokenizer(br.readLine());
        startR = Integer.parseInt(st.nextToken());
        startC = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        cnt = 1;
        for(int r = 0; r < n; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < m; c++){
                room[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void clean(int r, int c){
        isCleaned[r][c] = true;
        if(allCleaned(r, c)){
            int nr = r - DR[d];
            int nc = c - DC[d];
            if(canMove(nr, nc)){
                clean(nr, nc);
            }
        }else{
            for(int idx = 0; idx < 4; idx++){
                d = turn(d);
                int nr = r + DR[d];
                int nc = c + DC[d];
                if(canMove(nr, nc) && !isCleaned[nr][nc]){
                    cnt++;
                    clean(nr, nc);
                    break;
                }
            }
        }
    }

    static boolean allCleaned(int r, int c){
        for(int dir = 0; dir < 4; dir++){
            int nr = r + DR[dir];
            int nc = c + DC[dir];
            if(canMove(nr, nc) && !isCleaned[nr][nc]){
                return false;
            }
        }
        return true;
    }

    static int turn(int direction){
        return (direction + 3) % 4;
    }

    static boolean canMove(int r, int c){
        return !(r < 0 || c < 0 || r >= n || c >= m || room[r][c] == 1);
    }
}