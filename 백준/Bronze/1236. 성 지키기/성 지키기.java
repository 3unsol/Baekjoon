import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];

        String str;
        for(int r = 0; r < R; r++) {
            str = br.readLine();
            for(int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        int row = 0;
        for(int r = 0; r < R; r++) {
            boolean flag = true;
            for(int c = 0; c < C; c++) {
                if(map[r][c] == 'X') {
                    flag = false;
                    break;
                }
            }
            if(flag) row++;
        }

        int col = 0;
        for(int c = 0; c < C; c++) {
            boolean flag = true;
            for(int r = 0; r < R; r++) {
                if(map[r][c] == 'X') {
                    flag = false;
                    break;
                }
            }
            if(flag) col++;
        }

        System.out.println(Math.max(row, col));
    }
}