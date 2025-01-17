import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {
            long N = Long.parseLong(br.readLine());

            long start = 0;
            long end = 1_000_000_000l;
            long result = 0;

            while(start <= end) {

                long mid = (start + end) / 2;
                long sum = (mid * (mid + 1)) / 2;

                // N에 대한 등차수열의 합은 N보다 작을 수밖에 없음
                // 등차수열의 합이 N보다 작을 때를 찾아 Math.max(mid, result)
                if(sum <= N) {
                    result = Math.max(mid, result);
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}