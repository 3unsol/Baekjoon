import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[N];

        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int start = 0;
        int end = N - 1;

        int cnt = 0;
        int sum = 0;

        while(start < end) {

            sum = nums[start] + nums[end];

            if(sum >= M) {
                end--;
                if(sum == M) cnt++;
            } else {
                start++;
            }
        }

        System.out.println(cnt);
    }
}