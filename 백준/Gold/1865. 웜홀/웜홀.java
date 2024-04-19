import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, W;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++) {

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 지점 개수
            M = Integer.parseInt(st.nextToken()); // 간선 개수
            W = Integer.parseInt(st.nextToken()); // 웜홀 개수

            if(bellmanFord()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }

    static boolean bellmanFord() throws Exception {

        // 간선 + 웜홀 정보
        List<Node> list = new ArrayList<>();

        // 간선 + 웜홀 정보 입력 받기
        for(int i = 0; i < M + W; i++) {

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            if(i >= M) { // 웜홀일 경우 단방향, 시간이 거꾸로 감
                list.add(new Node(start, end, -time));
            }else{ // 간선일 경우 양방향
                list.add(new Node(start, end, time));
                list.add(new Node(end, start, time));
            }
        }

        // 최단 시간 저장
        int[] times = new int[N + 1];

        // 벨만 포드 (모든 지점을 출발지로 두고 탐색)
        for(int start = 1; start <= N; start++) {

            // 최솟값 저장을 위해 최대값으로 채워놓기
            Arrays.fill(times, INF);

            // 자기 자신과의 거리는 0
            times[start] = 0;

            // 음수사이클 확인 플래그
            boolean flag = false;

            // 모든 간선 확인
            for(int i = 1; i <= N; i++) {

                flag = false;

                // 연결된 간선 정보 하나씩 꺼내서 보기
                for(int j = 0; j < list.size(); j++) {

                    // 현재 간선 정보
                    Node now = list.get(j);

                    // 이미 들른 곳이고 지금 저장하려는 값이 더 작다면 음의 사이클
                    if(times[now.start] != INF && times[now.end] > times[now.start] + now.time) {
                        times[now.end] = times[now.start] + now.time;
                        flag = true;

                        if(i == N) {
                            return true;
                        }
                    }
                }

                if(!flag) break;

            }
        }
        return false;
    }
    static class Node {
        int start, end, time;

        Node(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}