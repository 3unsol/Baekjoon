import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, L, W, H;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        double start = 0;
        double end = Math.min(Math.min(L, W), H);

        for(int i = 0; i < 10000; i ++) {

            double mid = (start + end) / 2;

            if((long)(L / mid) * (long)(W / mid) * (long)(H / mid) >= N) {
                start = mid;
            } else {
                end = mid;
            }
        }

        System.out.println(start);
    }
}