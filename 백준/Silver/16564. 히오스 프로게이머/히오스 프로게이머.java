import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = arr[0];
        int end = arr[0] + K;

        int mid, ans = arr[0];

        while(start <= end) {

            mid = (start + end) / 2;

            long sum = 0;

            int diff;

            for(int i = 0; i < N; i++) {
                diff = mid - arr[i];
                if(diff > 0) {
                    sum += diff;
                }
            }

            if(sum <= K) {
                ans = Math.max(ans, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(ans);
    }
}