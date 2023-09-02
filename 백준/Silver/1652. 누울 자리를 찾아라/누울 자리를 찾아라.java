import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int n, widthCnt, heightCnt;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        for(int r = 0; r < n; r++){
            String str = br.readLine();
            for(int c = 0; c < n; c++){
                map[r][c] = str.charAt(c);
            }
        }
        widthCounting();
        heightCounting();
        System.out.printf(widthCnt + " " + heightCnt);
    }

    static void widthCounting(){
        widthCnt = 0;
        for(int r = 0; r < n; r++){
            int tmpCnt = 0;
            for(int c = 0; c < n; c++){
                if(map[r][c] == 'X'){
                    if(tmpCnt >= 2){
                        widthCnt++;
                    }
                    tmpCnt = 0;
                }else{
                    tmpCnt++;
                    if(c == n - 1){
                        if(tmpCnt >= 2) {
                            widthCnt++;
                        }
                    }
                }
            }
        }
    }
    static void heightCounting(){
        heightCnt = 0;
        for(int c = 0; c < n; c++){
            int tmpCnt = 0;
            for(int r = 0; r < n; r++){
                if(map[r][c] == 'X'){
                    if(tmpCnt >= 2){
                        heightCnt++;
                    }
                    tmpCnt = 0;
                }else{
                    tmpCnt++;
                    if(r == n - 1){
                        if(tmpCnt >= 2) {
                            heightCnt++;
                        }
                    }
                }
            }
        }
    }
}