import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, K;
    static int[][] cogwheels;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        cogwheels = new int[T][8];

        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            for(int j = 0; j < 8; j++) {
                cogwheels[i][j] = str.charAt(j) - '0';
            }
        }

        K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            left(num - 1, -dir);
            right(num + 1, -dir);
            rotate(num, dir);
        }
        print();
    }

    static void left(int num, int dir) {
        if(num < 0) return;
        if(cogwheels[num][2] == cogwheels[num + 1][6]) return;
        left(num - 1, -dir);
        rotate(num, dir);
    }

    static void right(int num, int dir) {
        if(num >= T) return;
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

    static void print() {
        int ans = 0;
        for(int i = 0; i < T; i++) {
            ans += cogwheels[i][0];
        }
        System.out.println(ans);
    }
}