import javax.management.StringValueExp;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        double[] number = new double[N];
        for(int i = 0; i < N; i++) {
            number[i] = Double.parseDouble(br.readLine());
        }
        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char order = str.charAt(i);
            if('A' <= order && order <= 'Z') {
                stack.push(number[str.charAt(i) - 'A']);
            } else {
                if(!stack.isEmpty()) {
                    double first = stack.pop();
                    double second = stack.pop();

                    switch (order) {
                        case '+' :
                            stack.push(second + first);
                            continue;
                        case '-' :
                            stack.push(second - first);
                            continue;
                        case '*' :
                            stack.push(second * first);
                            continue;
                        case '/' :
                            stack.push(second / first);
                    }
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}