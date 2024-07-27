import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static long[] time;
    static long maxTime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 심사대 개수
        M = Integer.parseInt(st.nextToken()); // 인원수

        time = new long[N]; // 각 심사대마다 걸리는 시간

        for(int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(br.readLine());
            maxTime = Math.max(maxTime, time[i]); // 심사대 중 가장 오래 걸리는 시간
        }

        Arrays.sort(time);

        binarySearch(); // 이진탐색
    }

    static void binarySearch() {

        long start = 0;
        long end = maxTime * M; // 가장 오래 걸리는 심사대에서 모두 심사를 받을 때가 최댓값

        while(start <= end) {

            long mid = (start + end) / 2; // 걸리는 시간
            long sum = 0;

            for(int i = 0; i < N; i++) {
                sum += mid / time[i]; // 각 심사대에서 시간 안에 받을 수 있는 최대 인원수 합
                if(sum >= M) break;
            }

            if(sum < M) { // 인원수 부족
                start = mid + 1; // 시간 늘려
            } else { // 인원수 됨 or 넘음
                end = mid - 1; // 시간 줄여
            }
        }

        System.out.println(start);
    }
}