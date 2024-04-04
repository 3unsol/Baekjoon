import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static Node[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new Node[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[i] = new Node(start, end);
        }

        // 정렬
        Arrays.sort(arr);

        int start = arr[0].start;
        int end = arr[0].end;
        int length = end - start;

        for(int i = 1; i < N; i++) {

            int nowStart = arr[i].start;
            int nowEnd = arr[i].end;

            // 1. 새로운 시작일 때
            if(end <= nowStart) {
                length += (nowEnd - nowStart);
                start = nowStart;
                end = nowEnd;
                continue;
            }

            // 2. 포함할 때
            if(start <= nowStart){
                // 2-1. 일부만 포함할 때
                if(end < nowEnd) {
                    length += (nowEnd - end);
                    end = nowEnd;
                }
            }
        }

        System.out.println(length);
    }

    static class Node implements Comparable<Node> {
        int start, end;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if(this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
}