import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] points;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        points = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points);

        for(int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(binarySearch(start, end));
        }
    }

    static int binarySearch(int start, int end) {

        int st = 0;
        int ed = N - 1;

        while(st <= ed) {

            int mid = (st + ed) / 2;

            if(points[mid] < start) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }

        int startIndex = st;

        st = 0;
        ed = N - 1;

        while(st <= ed) {

            int mid = (st + ed) / 2;

            if(points[mid] > end) {
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        int endIndex = ed + 1;

        return endIndex - startIndex;
    }
}