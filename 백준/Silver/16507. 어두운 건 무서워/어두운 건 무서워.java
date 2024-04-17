import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        map = new int[R + 1][C + 1];

        for(int r = 1; r <= R; r++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int c = 1; c <= C; c++) {
                sum += Integer.parseInt(st.nextToken());
                map[r][c] = sum + map[r - 1][c];
            }
        }

        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());

            int sum = map[endR][endC] - map[endR][startC - 1] - map[startR - 1][endC] + map[startR - 1][startC - 1];
            int div = (endR - startR + 1) * (endC - startC + 1);
            System.out.println(sum / div);
        }
    }
}