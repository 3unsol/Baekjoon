import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {

            int num = Integer.parseInt(st.nextToken());

            if(stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new Node(i, num));
            } else {
                while(true) {

                    if(stack.isEmpty()) {
                        sb.append("0 ");
                        stack.push(new Node(i, num));
                        break;
                    }

                    if(stack.peek().height > num) {
                        sb.append(stack.peek().index).append(" ");
                        stack.push(new Node(i, num));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(sb);
    }
    static class Node {
        int index, height;
        Node(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}