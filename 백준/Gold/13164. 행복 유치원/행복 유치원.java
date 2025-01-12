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
        int[] diff = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(diff);

        long sum = 0;

        for(int i = 0; i < N - K; i++) {
            sum += diff[i];
        }

        System.out.println(sum);
    }
}