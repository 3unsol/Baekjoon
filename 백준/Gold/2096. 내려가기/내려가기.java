import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map, maxDP, minDP;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        maxDP = new int[N][3];
        minDP = new int[N][3];

        for(int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());

        }

        if(N == 1) {
            System.out.print(Math.max(Math.max(map[0][0], map[0][1]), map[0][2]) + " ");
            System.out.println(Math.min(Math.min(map[0][0], map[0][1]), map[0][2]));
            return;
        }

        for(int i = 0; i < 3; i++) {
            maxDP[0][i] = minDP[0][i] = map[0][i];
        }

        for(int i = 1; i < N; i++) {

            minDP[i][0] = map[i][0] + Math.min(minDP[i - 1][0], minDP[i - 1][1]);
            maxDP[i][0] = map[i][0] + Math.max(maxDP[i - 1][0], maxDP[i - 1][1]);
            minDP[i][2] = map[i][2] + Math.min(minDP[i - 1][1], minDP[i - 1][2]);
            maxDP[i][2] = map[i][2] + Math.max(maxDP[i - 1][1], maxDP[i - 1][2]);
            minDP[i][1] = map[i][1] + Math.min(Math.min(minDP[i - 1][0], minDP[i - 1][1]), minDP[i - 1][2]);
            maxDP[i][1] = map[i][1] + Math.max(Math.max(maxDP[i - 1][0], maxDP[i - 1][1]), maxDP[i - 1][2]);

            if(i == N - 1) {
                System.out.print(Math.max(Math.max(maxDP[i][0], maxDP[i][1]), maxDP[i][2]) + " ");
                System.out.println(Math.min(Math.min(minDP[i][0], minDP[i][1]), minDP[i][2]));
            }
        }
    }
}