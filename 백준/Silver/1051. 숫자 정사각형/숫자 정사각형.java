import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        String str;

        for(int r = 0; r < N; r++) {
            str = br.readLine();
            for(int c = 0; c < M; c++) {
                map[r][c] = str.charAt(c) - '0';
            }
        }

        int size = Math.min(N, M);
        boolean flag = false;

        while(size > 1) {

            for(int r = 0; r <= N - size; r++) {
                for(int c = 0; c <= M - size; c++) {
                    if(isSquare(r, c, size - 1)) {
                        System.out.println(size * size);
                        return;
                    }
                }
            }
            size--;
        }

        System.out.println(1);
    }

    static boolean isSquare(int r, int c, int size) {
        return map[r][c] == map[r + size][c] && map[r][c] == map[r][c + size] && map[r][c] == map[r + size][c + size];
    }

}