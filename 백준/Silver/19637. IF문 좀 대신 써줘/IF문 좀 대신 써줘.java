import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] level = new String[N];
        int[] value = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            level[i] = st.nextToken();
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {

            int num = Integer.parseInt(br.readLine());

            int start = 0;
            int end = N - 1;
            int mid = 0;

            while(start <= end) {

                mid = (start + end) / 2;

                if(value[mid] < num) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            sb.append(level[start]).append("\n");
        }

        System.out.println(sb);
    }
}