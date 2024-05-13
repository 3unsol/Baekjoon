import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] scores, result;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        scores = new int[10];
        result = new int[10];
        ans = 0;

        for(int i = 0; i < 10; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        recur(0);
        System.out.println(ans);
    }

    static void recur(int depth) {

        if(depth == 10) {

            int cnt = 0;

            for(int i = 0 ; i < 10; i++) {
                if(scores[i] == result[i]) {
                    cnt++;
                }
            }

            if(cnt >= 5) {
                ans++;
            }
            return;
        }

        for(int i = 0; i < 5; i++) {

            if(depth >= 2 && result[depth - 1] == i + 1 && result[depth - 2] == i + 1) continue;

            result[depth] = i + 1;
            recur(depth + 1);
        }
    }
}