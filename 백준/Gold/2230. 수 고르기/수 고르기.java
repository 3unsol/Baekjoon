import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, min;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        min = 2000000000;

        int start = 0;
        int end = 0;

        while(start <= end && end < N) {

            int diff = arr[end] - arr[start];

            if(diff >= M) {
                min = Math.min(min, diff);
                start++;
            } else {
                end++;
            }
        }
        
        System.out.println(min);
    }
}
