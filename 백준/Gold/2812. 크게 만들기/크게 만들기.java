import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String number = br.readLine();

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++) {

            int now = number.charAt(i) - '0';

            while(K > 0 && !stack.isEmpty() && now > stack.peek()) {
                stack.pop();
                K--;
            }

            stack.push(now);
        }

        while(K > 0 && !stack.isEmpty()) {
            stack.pop();
            K--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : stack) {
            sb.append(i);
        }

        System.out.print(sb);
    }
}