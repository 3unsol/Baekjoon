import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine());

        int start = 0;
        int end = 0;
        long sum = 0;
        long cnt = 0;

        while(true) {

            if(sum > K) {
                cnt += N - end + 1;
                sum -= arr[start++];
            } else if(end >= N) {
                break;
            }else {
                sum += arr[end++];
            }
        }

        System.out.println(cnt);
    }
}