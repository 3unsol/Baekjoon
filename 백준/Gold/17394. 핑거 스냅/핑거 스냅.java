import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, A, B;
    static boolean[] isPrime, isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        makePrime();

        for(int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            if(!checkPrime()) {
                System.out.println(-1);
                continue;
            }

            bfs();

        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        isVisited = new boolean[3000001];
        q.offer(new Node(N, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.num >= A && now.num <= B && !isPrime[now.num]) {
                System.out.println(now.depth);
                return;
            }

            isVisited[now.num] = true;

            if(now.num / 2 > 0 && !isVisited[now.num / 2]) {
                q.offer(new Node(now.num / 2, now.depth + 1));
            }

            if(now.num / 3 > 0 && !isVisited[now.num / 3]) {
                q.offer(new Node(now.num / 3, now.depth + 1));
            }

            if(!isVisited[now.num + 1]) {
                q.offer(new Node(now.num + 1, now.depth + 1));
            }

            if(now.num - 1 > 0 && !isVisited[now.num - 1]) {
                q.offer(new Node(now.num - 1, now.depth + 1));
            }

        }
    }

    static void makePrime() {
        isPrime = new boolean[100001];
        isPrime[0] = isPrime[1] = true;

        for(int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if(isPrime[i]) continue;
            for(int j = i * i; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }
    }

    static boolean checkPrime() {
        for(int i = A; i <= B; i++) {
            if(!isPrime[i]) return true;
        }
        return false;
    }

    static class Node {
        int num, depth;
        Node(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
}