import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            // 스택이 비어있지 않고, 스택에 있는 인덱스에 해당하는 숫자가 지금 숫자보다 작으면
            // 해당 인덱스에 지금 숫자 넣어주고 스택에서 빼주기
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }
            // 스택이 비어있거나 해당 인덱스의 숫자가 지금 숫자보다 크면
            // 지금 숫자의 인덱스 넣어주기
            stack.push(i);
        }

        // 스택에 남아있는 인덱스들은 제일 큰 수거나 뒤에 숫자가 업는 애들
        while(!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}