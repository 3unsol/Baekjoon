import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static long[] arr, cnt;
    static boolean[] isOddNumber;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        cnt = new long[M];

        st = new StringTokenizer(br.readLine());

        long ans = 0;

        for(int i = 1; i <= N; i++) {
            arr[i] = (arr[i - 1] + Integer.parseInt(st.nextToken()) ) % M;
            if(arr[i] == 0) {
                ans++;
            }
            cnt[(int) arr[i]]++;
        }

        for(int i = 0; i < M; i++) {
            if(cnt[i] > 1) {
                ans += (cnt[i] * (cnt[i] - 1) / 2);
            }
        }
        System.out.println(ans);
    }
}