import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Long number = Long.parseLong(br.readLine());

        long start = 0;
        long end = number;
        long answer = 0;

        while(start <= end) {

            long mid = (start + end) / 2;

            if(Math.pow(mid, 2) >= number) {
                end = mid - 1;
                answer = mid;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }
}