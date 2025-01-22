import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 집 정렬
        Arrays.sort(arr);

        // 이분탐색
        int start = 1; // 공유기 설치 최소 간격
        int end = arr[N - 1] - arr[0] + 1; // 공유기 설치 최대 간격

        while(start <= end) {

            // 만드려는 최소 거리
            int mid = (start + end) / 2;
            // 설치한 공유기 개수
            int cnt = 1;
            // 공유기 설치한 집
            int prev = arr[0];

            for(int i = 1; i < N; i++) {
                // 만드려는 최소 거리보다 집이 멀리 있으면 공유기 설치
                if(arr[i] - prev >= mid) {
                    cnt++;
                    prev = arr[i];
                }
            }

            // 공유기 설치 개수가 적으면 최소 거리 줄이기
            if(cnt < C) {
                end = mid - 1;
            } else { // 같거나 많으면 최소 거리를 늘려본다.
                start = mid + 1;
            }
        }
        // start는 초과할 때의 값을 가지고 있어서 -1
        System.out.println(start - 1);
    }
}