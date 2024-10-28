import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int r = 0; r < N; r++) {
            String str = br.readLine();
            for(int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c) - '0';
            }
        }

        recur(0, 0, N);

        System.out.println(sb);
    }

    static void recur(int r, int c, int size) {

        if(check(r, c, size)) {
            sb.append(map[r][c]);
            return;
        }

        int newSize = size / 2;

        sb.append("(");
        recur(r, c, newSize);
        recur(r, c + newSize, newSize);
        recur(r + newSize, c, newSize);
        recur(r + newSize, c + newSize, newSize);
        sb.append(")");
    }

    static boolean check(int startR, int startC, int size) {
        for(int r = startR; r < startR + size; r++) {
            for(int c = startC; c < startC + size; c++) {
                if(map[startR][startC] != map[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}