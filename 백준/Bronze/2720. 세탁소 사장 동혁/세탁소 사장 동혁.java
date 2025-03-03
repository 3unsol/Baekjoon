import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] unit = {25, 10, 5, 1};
        while(testCase-- > 0) {
            int cost = Integer.parseInt(br.readLine());
            for(int i = 0; i < 3; i++) {
                sb.append(cost / unit[i] + " ");
                cost %= unit[i];
            }
            sb.append(cost / unit[3] + "\n");
        }
        System.out.println(sb);
    }
}