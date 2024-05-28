import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<Node>[] adjList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            adjList[start].add(new Node(end, value));
            adjList[end].add(new Node(start, value));
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            sb.append(bfs(node1, node2)).append("\n");
        }

        System.out.print(sb);

    }

    static int bfs(int node1, int node2) {
        boolean[] isVisited = new boolean[N + 1];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(node1, 0));
        isVisited[node1] = true;

        int dist = 0;

        while(!q.isEmpty()) {

            Node now = q.poll();

            if(now.number == node2) {
                dist = now.value;
                break;
            }

            for(Node n : adjList[now.number]) {
                if(!isVisited[n.number]) {
                    q.offer(new Node(n.number, now.value + n.value));
                    isVisited[n.number] = true;
                }
            }
        }

        return dist;

    }

    static class Node {
        int number, value;
        Node(int number, int value) {
            this.number = number;
            this.value = value;
        }
    }
}