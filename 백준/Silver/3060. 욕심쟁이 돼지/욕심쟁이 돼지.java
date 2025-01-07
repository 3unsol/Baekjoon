import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++) {

            int N = Integer.parseInt(br.readLine());
            long sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 6; i++) {
                sum += Integer.parseInt(st.nextToken());
            }

            int ans = 1;

            while(true) {
                if(sum > N) {
                    System.out.println(ans);
                    break;
                }
                sum *= 4;
                ans++;
            }
        }
    }
}