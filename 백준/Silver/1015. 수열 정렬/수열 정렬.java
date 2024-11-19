import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        int[] rank = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.num - o2.num;
            }
        });
        for(int i = 0; i < N; i++) {
            rank[arr[i].index] = i;
        }
        for(int i = 0; i < N; i++) {
            System.out.print(rank[i] + " ");
        }
    }

    static class Node {
        int index, num;
        Node(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }
}