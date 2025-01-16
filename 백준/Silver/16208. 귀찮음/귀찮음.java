import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        long[] arr = new long[N];
        long total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            total += arr[i];
        }
        
        long sum = 0;
        for(int i = 0; i < N; i++) {
            total -= arr[i];
            sum += arr[i] * total;
        }

        System.out.println(sum);
    }
}