import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr, leftDP, rightDP;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS();
        LDS();

        int max = 0;

        for(int i = 0; i < N; i++) {
            int sum = leftDP[i] + rightDP[i];
            max = Math.max(max, sum);
        }

        System.out.println(max - 1);
    }

    static void LIS() {
        leftDP = new int[N];

        for(int i = 0; i < N; i++) {
            leftDP[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && leftDP[i] < leftDP[j] + 1) {
                    leftDP[i] = leftDP[j] + 1;
                }
            }
        }
    }

    static void LDS() {
        rightDP = new int[N];

        for(int i = N - 1; i >= 0; i--) {
            rightDP[i] = 1;
            for(int j = N - 1; j > i; j--) {
                if(arr[i] > arr[j] && rightDP[i] < rightDP[j] + 1) {
                    rightDP[i] = rightDP[j] + 1;
                }
            }
        }
    }
}