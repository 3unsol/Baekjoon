import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int gameCnt = Integer.parseInt(br.readLine());
        int[] scores = new int[gameCnt];

        for(int i = 0; i < gameCnt; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;

        for(int i = gameCnt - 1; i > 0; i--) {
            if(scores[i] <= scores[i - 1]) {
                cnt += scores[i - 1] - scores[i] + 1;
                scores[i - 1] = scores[i] - 1;
            }
        }

        System.out.println(cnt);
    }
}