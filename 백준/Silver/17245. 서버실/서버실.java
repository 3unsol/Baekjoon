import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int max = 0;
        long total = 0;

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[r][c]);
                total += map[r][c];
            }
        }

        int left = 0;
        int right = max;
        int min = max;

        while(left < right) {

            int mid = (right + left) / 2;

            long sum = 0;

            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    if(map[r][c] <= mid) {
                        sum += map[r][c];
                    } else {
                        sum += mid;
                    }
                }
            }

            if(((double) sum / total) >= 0.5) {
                min = mid;
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(min);
    }
}