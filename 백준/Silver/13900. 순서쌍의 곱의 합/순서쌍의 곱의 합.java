import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];

        long sum = 0;

        arr[0] = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            arr[i] = now + arr[i - 1];
            sum += arr[i - 1] * now;
        }

        System.out.println(sum);
    }
}