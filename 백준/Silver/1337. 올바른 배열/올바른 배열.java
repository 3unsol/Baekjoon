import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        int ans = 4;

        while(true) {

            if(end >= N) {
                break;
            }

            if(arr[end] - arr[start] < 5) {
                end++;
                ans = Math.min(ans, 5 - (end - start));
            } else {
                start++;
            }
        }

        System.out.println(ans);
    }
}