import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, K, M;
    static List<Integer> kimbabs = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            int kimbab = Integer.parseInt(br.readLine());
            if(kimbab > (2 * K)) {
                kimbabs.add(kimbab - (2 * K));
            } else if (2 * K > kimbab && kimbab > K){
                kimbabs.add(kimbab - K);
            }
        }

        binarySearch();

    }

    static void binarySearch() {

        int start = 1;
        int end = 1000000000;
        int ans = -1;

        while(start <= end) {

            int mid = (start + end) / 2;

            int cnt = 0;
            for(int i = 0; i < kimbabs.size(); i++) {
                cnt += (kimbabs.get(i) / mid);
            }

            if(cnt >= M) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }
}