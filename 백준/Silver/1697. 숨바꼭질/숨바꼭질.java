import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N == K) {
            System.out.println(0);
        } else {
            visited = new int[100001];
            int result = bfs(N);
            System.out.println(result);
        }
    }

    static int bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == K) {
                return visited[curr];
            }
            if (curr - 1 >= 0 && visited[curr - 1] == 0) {
                visited[curr - 1] = visited[curr] + 1;
                q.offer(curr - 1);
            }
            if (curr + 1 <= 100000 && visited[curr + 1] == 0) {
                visited[curr + 1] = visited[curr] + 1;
                q.offer(curr + 1);
            }
            if (curr * 2 <= 100000 && visited[curr * 2] == 0) {
                visited[curr * 2] = visited[curr] + 1;
                q.offer(curr * 2);
            }
        }
        return -1;
    }
}