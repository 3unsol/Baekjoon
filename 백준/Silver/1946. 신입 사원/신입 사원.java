import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, cnt;
    static Node[] rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {

            N = Integer.parseInt(br.readLine());
            rank = new Node[N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                rank[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(rank);
            cnt = 1;
            int minInterview = rank[0].interview;

            for(int i = 1; i < N; i++) {
                if(rank[i].interview < minInterview) {
                    cnt++;
                    minInterview = rank[i].interview;
                }
            }

            System.out.println(cnt);
        }
    }

    static class Node implements Comparable<Node> {
        int coverLetter, interview;
        Node(int coverLetter, int interview) {
            this.coverLetter = coverLetter;
            this.interview = interview;
        }

        @Override
        public int compareTo(Node o) {
            return this.coverLetter - o.coverLetter;
        }
    }
}