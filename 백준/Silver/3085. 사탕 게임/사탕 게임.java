import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N, max;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for(int r = 0; r < N; r++) {
            String str = br.readLine();
            for(int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        for(int r = 0; r < N; r++) {
            for(int c = 0; c < N - 1; c++) {
                swap(r, c, r, c + 1);
                find();
                swap(r, c + 1, r, c);
            }
        }

        for(int r = 0; r < N - 1; r++) {
            for(int c = 0; c < N; c++) {
                swap(r, c, r + 1, c);
                find();
                swap(r + 1, c, r, c);
            }
        }

        System.out.println(max);
    }

    static void swap(int r, int c, int x, int y) {
        char tmp = map[r][c];
        map[r][c] = map[x][y];
        map[x][y] = tmp;
    }

    static void find() {
        for (int r = 0; r < N; r++) {
            int cnt = 1;
            for(int c = 0; c < N - 1; c++) {
                if(map[r][c] == map[r][c + 1]) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 1;
                }
            }
        }

        for(int r = 0; r < N; r++) {
            int cnt = 1;
            for(int c = 0; c < N - 1; c++) {
                if(map[c][r] == map[c + 1][r]) {
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    cnt = 1;
                }
            }
        }
    }
}