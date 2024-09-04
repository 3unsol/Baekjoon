import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N == 0) {
            System.out.println(0);
            return;
        }
        
        st = new StringTokenizer(br.readLine());

        int bag = K;
        int cnt = 1;

        for(int i = 0; i < N; i++) {

            int book = Integer.parseInt(st.nextToken());

            if(bag >= book) {
                bag -= book;
            } else {
                bag = K - book;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}