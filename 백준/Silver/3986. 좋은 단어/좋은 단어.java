import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static int N, cnt;
    static Stack<Character> stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            stack = new Stack<>();
            String str = br.readLine();
            if(str.length() % 2 == 1) continue;
            for(int j = 0; j < str.length(); j++) {
                if(stack.isEmpty() || stack.peek() != str.charAt(j)) {
                    stack.push(str.charAt(j));
                } else {
                    stack.pop();
                }
            }
            if(stack.isEmpty()) cnt++;
        }
        System.out.println(cnt);
    }
}