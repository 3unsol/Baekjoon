import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] cows = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cows, (o1, o2) -> {
           return o1[0] - o2[0];
        });

        int start = 0;
        for(int i = 0; i < N; i++) {
            if(start <= cows[i][0]) {
                start = cows[i][0] + cows[i][1];
            } else {
                start += cows[i][1];
            }
        }

        System.out.println(start);
    }
}