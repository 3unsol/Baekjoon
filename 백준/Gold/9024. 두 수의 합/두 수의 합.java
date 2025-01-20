import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            binarySearch();
        }
    }

    static void binarySearch() {

        // 정렬
        Arrays.sort(arr);

        // 두 포인터 (인덱스)
        int start = 0;
        int end = N - 1;

        // 최소 차이
        int min = Integer.MAX_VALUE;

        // 개수
        int ans = 0;

        while(start < end) {

            int sum = arr[start] + arr[end];
            int diff = Math.abs(K - sum);

            // 차이 확인
            if(diff < min) {
                min = diff;
                ans = 1;
            } else if(diff == min){
                ans++;
            }

            // 탐색을 위한 인덱스 변경
            if(sum <= K) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(ans);
    }
}