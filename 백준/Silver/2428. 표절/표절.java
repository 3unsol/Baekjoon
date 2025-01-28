import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] files = new int[N];
        for(int i = 0; i < N; i++) {
            files[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(files);
        int start = 0;
        int end = 0;
        long ans = 0;
        while(start < N) {
            while(true) {
                if(end >= N - 1) break;
                if(files[start] < files[end + 1] * 0.9) break;
                else end++;
            }
            ans += end - start;
            start++;
        }
        System.out.println(ans);
    }
}