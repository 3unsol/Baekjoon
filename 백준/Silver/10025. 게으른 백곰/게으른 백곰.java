import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 1000001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()) * 2 + 1;

        int[] ice = new int[INF];

        int gram, index;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gram = Integer.parseInt(st.nextToken());
            index = Integer.parseInt(st.nextToken());
            ice[index] = gram;
        }

        int sum = 0;
        int max = 0;

        for(int i = 0; i < INF; i++) {

            if(i - K >= 0) {
                sum -= ice[i - K];
            }

            sum += ice[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}