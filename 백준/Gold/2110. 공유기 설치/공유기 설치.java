import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = arr[N - 1] - arr[0] + 1;
        int mid;

        while(start < end) {

            mid = (start + end) / 2;

            // 공유기 설치 (첫 번째 집은 무조건 설치)
            int cnt = 1;
            int recent = arr[0];

            for(int i = 1; i < N; i++) {
                int locate = arr[i]; // 똑똑똑 안녕하세요
                if(locate - recent >= mid) { // 이 집에 공유기 설치 가능할까여?
                    cnt++; // 네. 설치하겠습니다.
                    recent = locate; // 여기 싸인 부탁드려요
                }
            }

            if(cnt < M) { // 공유기가 남는뎁쇼
                end = mid; // 설치 거리를 줄이거라
            } else { // 같거나 모자랍니다요
                start = mid + 1; // 거리를 늘리면서 최소거리를 최대로 만들거라
            }
        }

        System.out.println(start - 1);
    }
}