import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] lessons;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lessons = new int[N];

        int max = 0;
        int total = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, lessons[i]);
            total += lessons[i];
        }

        int start = max;
        int end = total;
        int mid;
        int ans = Integer.MAX_VALUE;

        while(start <= end) {

            mid = (start + end) / 2;

            int cnt = check(mid);

            if(cnt <= M) {
                ans = Math.min(ans, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(ans);
    }

    static int check(int mid) {

        int cnt = 1;
        int now = 0;

        for(int i = 0; i < N; i++) {

            if(mid < lessons[i]) {
                return 0;
            }

            if(now + lessons[i] > mid) {
                cnt++;
                now = lessons[i];
                if (cnt > M) {
                    return cnt;
                }
            } else {
                    now += lessons[i];
                }
            }
        return cnt;
    }
}