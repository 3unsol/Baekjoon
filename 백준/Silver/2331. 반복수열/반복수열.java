import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(A);

        while(true) {
            int tmp = list.get(list.size() - 1);

            int result = 0;

            while(tmp != 0) {
                result += (int)Math.pow(tmp % 10, P);
                tmp /= 10;
            }

            if(list.contains(result)) {
                int ans = list.indexOf(result);
                sb.append(ans).append("\n");
                break;
            }

            list.add(result);
        }

        System.out.print(sb);
    }
}