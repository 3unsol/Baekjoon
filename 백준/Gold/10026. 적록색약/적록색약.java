import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, cnt, dalto;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        input();
        district();
        daltonism();
        System.out.println(cnt + " " + dalto);
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;
        dalto = 0;
        map = new char[N][N];
        for(int r = 0; r < N; r++){
            String str = br.readLine();
            for(int c = 0; c < N; c++){
                map[r][c] = str.charAt(c);
            }
        }
    }
    static void district(){
        isVisited = new boolean[N][N];
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(!isVisited[r][c] && map[r][c] == 'R'){
                    findRed(r, c);
                    cnt++;
                }else if(!isVisited[r][c] && map[r][c] == 'B'){
                    findBlue(r, c);
                    cnt++;
                }else if(!isVisited[r][c] && map[r][c] == 'G'){
                    findGreen(r, c);
                    cnt++;
                }
            }
        }
    }
    static void daltonism(){
        isVisited = new boolean[N][N];
        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                if(!isVisited[r][c]){
                    if(map[r][c] == 'R' || map[r][c] == 'G') {
                        findRedGreen(r, c);
                        dalto++;
                    }
                    else if(map[r][c] == 'B'){
                        findBlue(r, c);
                        dalto++;
                    }
                }
            }
        }
    }
    static void findRed(int r, int c){
        isVisited[r][c] = true;
        for(int dir = 0; dir < 4; dir++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(isPossible(nr, nc) && !isVisited[nr][nc] && map[nr][nc] =='R'){
                findRed(nr, nc);
            }
        }
    }
    static void findBlue(int r, int c){
        isVisited[r][c] = true;
        for(int dir = 0; dir < 4; dir++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(isPossible(nr, nc) && !isVisited[nr][nc] && map[nr][nc] =='B'){
                findBlue(nr, nc);
            }
        }
    }
    static void findGreen(int r, int c){
        isVisited[r][c] = true;
        for(int dir = 0; dir < 4; dir++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(isPossible(nr, nc) && !isVisited[nr][nc] && map[nr][nc] =='G'){
                findGreen(nr, nc);
            }
        }
    }
    static void findRedGreen(int r, int c){
        isVisited[r][c] = true;
        for(int dir = 0; dir < 4; dir++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(isPossible(nr, nc) && !isVisited[nr][nc]){
                if(map[nr][nc] == 'R' || map[nr][nc] == 'G'){
                    findRedGreen(nr, nc);
                }
            }
        }
    }
    static boolean isPossible(int nr, int nc){
        if(nr < 0 || nc < 0 || nr >= N || nc >= N){
            return false;
        }else{
            return true;
        }
    }
}