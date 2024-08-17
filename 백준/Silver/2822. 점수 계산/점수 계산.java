import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node[] nodes = new Node[8];
        for(int i = 0; i < 8; i++) {
            nodes[i] = new Node(i + 1, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(nodes);

        int sum = 0;
        int[] idx = new int[5];

        for(int i = 0; i < 5; i++) {
            sum += nodes[i].score;
            idx[i] = nodes[i].index;
        }

        Arrays.sort(idx);

        System.out.println(sum);
        for(int i = 0; i < 5; i++) {
            System.out.print(idx[i] + " ");
        }
    }

    static class Node implements Comparable<Node> {
        int index, score;
        Node(int index, int score) {
            this.index = index;
            this.score = score;
        }
        @Override
        public int compareTo(Node o) {
            return o.score - this.score;
        }
    }
}