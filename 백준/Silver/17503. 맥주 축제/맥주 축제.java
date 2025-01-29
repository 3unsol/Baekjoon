import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Node[] beer = new Node[K];
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            beer[i] = new Node(v, c);
        }

        // 도수 오름차순 정렬
        Arrays.sort(beer, ((o1, o2) -> (o1.c - o2.c)));

        // 선호도 합
        int sum = 0;
        // 최고 도수
        int ans = -1;
        // 우선순위 큐 : 선호도 담을 것, 크기가 N 이상이면 앞에서 하나 뺌
        Queue<Integer> pq = new PriorityQueue<>();
        // 모든 맥주를 볼 거임
        for(Node node : beer) {
            // 도수 낮은 순으로 선호도를 pq에 넣어
            pq.offer(node.v);
            // 현재 맥주의 선호도를 넣었을 때의 합
            sum += node.v;
            // pq에 N개 이상 들어가있으면 앞에서부터 하나 뺌
            if(pq.size() > N) {
                sum -= pq.poll();
            }
            // pq에 N개 있고 합이 M보다 크고나 같으면 조건 만족
            // 현재 도수가 최고 도수니까 답에 넣고 반복문 멈춤
            if(pq.size() == N && sum >= M) {
                ans = node.c;
                break;
            }
        }
        System.out.println(ans);
    }

    static class Node {
        int v, c;
        Node(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}