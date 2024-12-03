import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static Node[] lessons;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        lessons = new Node[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lessons[i] = new Node(start, end);
        }

        Arrays.sort(lessons, (Comparator.comparingInt(node -> node.start)));

        pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            Node now = lessons[i];

            if(!pq.isEmpty() && pq.peek() <= now.start) {
                pq.poll();
            }

            pq.offer(now.end);
        }

        System.out.println(pq.size());
    }

    static class Node {
        int start, end;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}