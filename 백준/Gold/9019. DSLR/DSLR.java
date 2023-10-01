import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int a, b;
    static boolean[] isVisited;
    static String[] command;

    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int t = 1; t <= testCase; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            isVisited = new boolean[10000];
            command = new String[10000];
            Arrays.fill(command, "");
            bfs(a);
        }
    }

    static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        isVisited[n] = true;
        while(!q.isEmpty() && !isVisited[b]){
            int tmp = q.poll();
            int D = (2 * tmp) % 10000;
            int S = tmp == 0 ? 9999 : tmp - 1;
            int L = (tmp % 1000) * 10 + (tmp / 1000);
            int R = (tmp % 10) * 1000 + (tmp / 10);

            if(!isVisited[D]){
                q.offer(D);
                isVisited[D] = true;
                command[D] = command[tmp] + "D";
            }
            if(!isVisited[S]){
                q.offer(S);
                isVisited[S] = true;
                command[S] = command[tmp] + "S";
            }
            if(!isVisited[L]){
                q.offer(L);
                isVisited[L] = true;
                command[L] = command[tmp] + "L";
            }
            if(!isVisited[R]){
                q.offer(R);
                isVisited[R] = true;
                command[R] = command[tmp] + "R";
            }
        }
        System.out.println(command[b]);
    }
}