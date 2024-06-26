import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, cnt;
    static int[] rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {

            N = Integer.parseInt(br.readLine());
            rank = new int[N + 1];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                rank[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            cnt = 1;
            int minInterview = rank[1];

            for(int i = 2; i <= N; i++) {
                if(rank[i] <= minInterview) {
                    cnt++;
                    minInterview = rank[i];
                }
            }

            System.out.println(cnt);
        }
    }
}