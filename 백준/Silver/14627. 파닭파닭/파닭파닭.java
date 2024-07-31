import java.io.*;
import java.util.*;

public class Main {

    static int N, C, maxLength;
    static long sum;
    static int[] greenOnion;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        greenOnion = new int[N];

        for(int i = 0; i < N; i++) {
            greenOnion[i] = Integer.parseInt(br.readLine());
            sum += greenOnion[i];
            if(maxLength < greenOnion[i]) maxLength = greenOnion[i];
        }

        binarySearch();

    }

    static void binarySearch() {

        long start = 1;
        long end = maxLength;

        while(start <= end) {

            long mid = (start + end) / 2;

            int sum = 0;

            for(int i = 0; i < N; i++) {
                sum += greenOnion[i] / mid;
            }

            if(sum >= C) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(sum - (end * C));
    }
}