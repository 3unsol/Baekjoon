import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K, ans;
    static int[] cats;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cats = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cats[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cats);

        twoPoints();

        System.out.println(ans);

    }

    static void twoPoints() {

        int start = 0, end = N - 1;

        while(start < end) {

            if(cats[start] + cats[end] <= K) {
                ans++;
                start++;
                end--;
            } else {
                end--;
            }
        }
    }
}