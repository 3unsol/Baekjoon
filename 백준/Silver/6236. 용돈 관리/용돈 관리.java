import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int min = 0;
        int max = 0;
        
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.max(arr[i], min);
            max += arr[i];
        }

        int mid, count, sum;
        
        while(min < max) {
            
            mid = (max + min) / 2;
            
            sum = 0;
            count = 1;
            
            for(int i = 0; i < N; i++) {
                sum += arr[i];
                if(sum > mid) {
                    sum = arr[i];
                    count++;
                }
            }
            
            if(count > M) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(min);

    }
}