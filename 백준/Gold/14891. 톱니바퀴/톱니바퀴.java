import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 1번 2 != 2번 6, 2번 2 != 3번 6, 3번 2 != 4번 6
     * 회전하기 전 톱니바퀴로 비교해야 함 -> 재귀 이용
     */

    static int[][] cogwheels;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        cogwheels = new int[4][8];

        for(int r = 0; r < 4; r++) {
            String str = br.readLine();
            for(int c = 0; c < 8; c++) {
                cogwheels[r][c] = str.charAt(c) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            order(num, dir);
        }
        calc();
    }

    static void order(int num, int dir) {
        left(num - 1, -dir);
        right(num + 1, -dir);
        rotate(num, dir);
    }

    static void left(int num, int dir) {
        if(num < 0) return;
        if(cogwheels[num][2] == cogwheels[num + 1][6]) return;
        left(num - 1, -dir);
        rotate(num, dir);
    }

    static void right(int num, int dir) {
        if(num > 3) return;
        if(cogwheels[num - 1][2] == cogwheels[num][6]) return;
        right(num + 1, -dir);
        rotate(num, dir);
    }

    static void rotate(int num, int dir) {
        if(dir == 1) {
            int tmp = cogwheels[num][7];
            for(int i = 7; i > 0; i--) {
                cogwheels[num][i] = cogwheels[num][i - 1];
            }
            cogwheels[num][0] = tmp;
        } else {
            int tmp = cogwheels[num][0];
            for(int i = 0; i < 7; i++) {
                cogwheels[num][i] = cogwheels[num][i + 1];
            }
            cogwheels[num][7] = tmp;
        }
    }

    static void calc() {
        for(int i = 0; i < 4; i++) {
            ans += Integer.parseInt(String.valueOf(cogwheels[i][0])) * Math.pow(2, i);
        }
        System.out.println(ans);
    }
}