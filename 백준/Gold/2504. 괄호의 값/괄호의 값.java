import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String order = br.readLine();
        Stack<Character> stack = new Stack<>();

        int ans = 0;
        int tmp = 1;
        boolean flag = true;

        for(int i = 0; i < order.length(); i++) {
            char now = order.charAt(i);

            if(now == '(') {
                stack.push(now);
                tmp *= 2;
            } else if (now == '[') {
                stack.push(now);
                tmp *= 3;
            } else {

                if (now == ')') {
                    if(stack.isEmpty() || stack.peek() != '(') {
                        flag = false;
                        break;
                    }
                    if(order.charAt(i - 1) == '(') {
                        ans += tmp;
                    }
                    stack.pop();
                    tmp /= 2;
                } else if (now == ']') {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        flag = false;
                        break;
                    }
                    if(order.charAt(i - 1) == '[') {
                        ans += tmp;
                    }
                    stack.pop();
                    tmp /= 3;
                } else {
                    flag = false;
                    break;
                }
            }
        }

        if(!flag || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }
}