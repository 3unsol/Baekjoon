import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] adjArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjArr = new int[N + 1][N + 1];

        for(int r = 1; r <= N; r++) {
            for(int c = 1; c <= N; c++) {
                if(r == c) adjArr[r][c] = 1;
            }
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjArr[a][b] = 1;
        }

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                if(i == k) continue;
                for(int j = 1; j <= N; j++){
                    if(j == k || j == i) continue;
                   if(adjArr[i][k] == 1 && adjArr[k][j] == 1){
                       adjArr[i][j] = 1;
                   }
                }
            }
        }

        int ans = 0;

        for(int i = 1; i <= N; i++){
            int cnt = 0;
            for(int j = 1; j <= N; j++){
                if(i == j) continue;
                if(adjArr[i][j] == 1 || adjArr[j][i] == 1){
                    cnt++;
                }
            }
            if(cnt == N - 1) ans++;
        }

        System.out.println(ans);
    }
}