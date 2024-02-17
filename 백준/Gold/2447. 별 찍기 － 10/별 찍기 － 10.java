import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        recur(0, 0, N / 3);

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void recur(int startR, int startC, int size) {

        if (size >= 3) {
            int cnt = 1;

            for (int r = startR; r < startR + size * 3; r += size) {
                for (int c = startC; c < startC + size * 3; c += size) {

                    if (cnt == 5) {

                        for (int nr = r; nr < r + size; nr++) {
                            for (int nc = c; nc < c + size; nc++) {
                                map[nr][nc] = ' ';
                            }
                        }

                    } else {
                        recur(r, c, size / 3);
                    }

                    cnt++;
                }
            }

        } else {
            for (int r = startR; r < startR + 3; r++) {
                for (int c = startC; c < startC + 3; c++) {
                    if (r % 3 == 1 && c % 3 == 1) {
                        map[r][c] = ' ';
                    } else {
                        map[r][c] = '*';
                    }
                }
            }
        }

    }
}