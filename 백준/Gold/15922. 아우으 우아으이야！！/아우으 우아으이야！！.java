import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int end = arr[0][1];
        long length = arr[0][1] - arr[0][0];

        for(int i = 1; i < N; i++) {

            if(arr[i][0] > end) {
                length += arr[i][1] - arr[i][0];
                end = arr[i][1];
            }

            if(arr[i][1] > end) {
                length += arr[i][1] - end;
                end = arr[i][1];
            }
        }

        System.out.println(length);
    }
}