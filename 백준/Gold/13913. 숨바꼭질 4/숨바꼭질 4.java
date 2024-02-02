import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] parents, isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isVisited = new int[200001];
        parents = new int[200001];

        bfs();
        System.out.println(isVisited[K] - 1);

        Stack<Integer> stack = new Stack<>();

        int idx = K;

        while(idx != N) {
            stack.push(idx);
            idx = parents[idx];
        }

        stack.push(idx);

        while(!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        isVisited[N] = 1;

        while(!q.isEmpty()) {

            int now = q.poll();

            if(now - 1 >= 0 && isVisited[now - 1] == 0) {
                q.offer(now - 1);
                isVisited[now - 1] = isVisited[now] + 1;
                parents[now - 1] = now;
            }
            if(now + 1 < 200001 && isVisited[now + 1] == 0) {
                q.offer(now + 1);
                isVisited[now + 1] = isVisited[now] + 1;
                parents[now + 1] = now;
            }
            if(now * 2 < 200001 && isVisited[now * 2] == 0) {
                q.offer(now * 2);
                isVisited[now * 2] = isVisited[now] + 1;
                parents[now * 2] = now;
            }

        }

        if(isVisited[K] != 0) return;
    }
}