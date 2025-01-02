import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 0;

        int start = 0;
        int end = 0;
        int[] cnt = new int[100001];

        // 배열 끝까지 확인
        while(end < N) {
            // 배열 범위 안에 있고 다음 숫자 넣어도 K개 이하일 때
            while(end < N && cnt[arr[end]] + 1 <= K) {
                // 수열에 넣어주고 카운트 늘려주기
                cnt[arr[end]]++;
                end++;
            }
            // 현재 수열 길이
            int tmpLength = end - start;
            maxLength = Math.max(maxLength, tmpLength);
            // start 포인터 앞으로 이동
            cnt[arr[start]]--;
            start++;
        }

        System.out.println(maxLength);
    }
}