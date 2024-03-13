import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] map;
    static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                if(str.charAt(j) == 'Y') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = INF;
                }
            }
        }

        for(int k = 0; k < N; k++) {
            for(int i = 0; i < N; i++) {
                if(i == k) continue;
                for(int j = 0; j < N; j++) {
                    if(j == i || j == k) continue;
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        int max = 0;

        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 || map[i][j] == 2) {
                    if(i != j) cnt++;
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}