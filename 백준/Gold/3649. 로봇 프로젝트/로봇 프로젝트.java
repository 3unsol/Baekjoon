import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCase = "";
        while((testCase = br.readLine()) != null) {

            int nano = Integer.parseInt(testCase) * 10000000;
            int N = Integer.parseInt(br.readLine());

            int[] lego = new int[N];
            for(int i = 0; i < N; i++) {
                lego[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(lego);

            int start = 0;
            int end = N - 1;
            boolean flag = false;

            while(start < end) {

                int sum = lego[start] + lego[end];

                if(sum == nano) {
                    flag = true;
                    break;
                } else if (sum > nano) {
                    end--;
                } else {
                    start++;
                }
            }

            if(flag) System.out.println("yes " + lego[start] + " " + lego[end]);
            else System.out.println("danger");
        }
    }
}