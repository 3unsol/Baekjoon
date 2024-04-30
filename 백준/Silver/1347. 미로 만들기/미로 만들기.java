import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1. map크기를 최대로 만들어놓고 그 안에서 움직이도록 함...
 * 2. 경곗값을 그때그때 갱신해서 맵 크기를 구함...
 */
public class Main {

    static int[][] map = new int[101][101];
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        // 중앙에서 시작
        int r = 50;
        int c = 50;
        map[r][c] = 1;

        // 0: 북, 1: 동, 2: 남, 3: 서
        int dir = 2;

        // 맵 경계
        int maxR = 50;
        int maxC = 50;
        int minR = 50;
        int minC = 50;

        for(int i = 0; i < N; i++) {

            char now = str.charAt(i);

            if(now == 'L'){ // 왼쪽으로 회전

                dir--;
                if(dir == -1) dir = 3;

            }else if(now == 'R'){ // 오른쪽으로 회전

                dir = (dir + 1) % 4;

            }else if(now == 'F'){ // 직진

                r += dr[dir];
                c += dc[dir];
                map[r][c] = 1;

                // 경곗값 갱신
                maxR = Math.max(maxR, r);
                maxC = Math.max(maxC, c);
                minR = Math.min(minR, r);
                minC = Math.min(minC, c);
            }
        }

        for(int i = minR; i <= maxR; i++) {
            for(int j = minC; j <= maxC; j++) {
                if(map[i][j] == 1) {
                    System.out.print('.');
                } else {
                    System.out.print('#');
                }
            }
            System.out.println();
        }
    }
}