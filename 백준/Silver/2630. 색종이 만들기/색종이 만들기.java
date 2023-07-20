import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int white, blue;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int r = 0; r < n; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < n; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        white = 0;
        blue = 0;

        divide(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int r, int c, int n){
        if(isBlue(r, c, n)){
            blue++;
        }else if(isWhite(r, c, n)){
            white++;
        }else{
            n = n / 2;
            divide(r, c, n);
            divide(r, c + n, n);
            divide(r + n, c, n);
            divide(r + n, c + n, n);
        }

    }

    public static boolean isBlue(int nr, int nc, int n){
        boolean flag = true;
        for(int r = nr; r < nr + n; r++){
            for(int c = nc; c < nc + n; c++){
                if(map[r][c] == 0){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    public static boolean isWhite(int nr, int nc, int n){
        boolean flag = true;
        for(int r = nr; r < nr + n; r++){
            for(int c = nc; c < nc + n; c++){
                if(map[r][c] == 1){
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}