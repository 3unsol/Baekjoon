import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, T;
    static long ans;
    static ArrayList<Long> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            long S = Integer.parseInt(st.nextToken());
            long I = Integer.parseInt(st.nextToken());
            long C = Integer.parseInt(st.nextToken());

            for(int j = 0; j < C; j++) {
                list.add(S + (I * j));
            }
        }

        Collections.sort(list);

        if(list.get(0) >= T) ans = list.get(0) - T; // 젤 먼저 오는 버스보다 먼저 도착할 때
        else if (list.get(list.size() - 1) < T) ans = -1; // 젤 늦게 오는 버스도 못 탈 때
        else {
            long start = 0;
            long end = list.size() - 1;
            long mid = (start + end) / 2;

            while(start < end) {

                mid = (start + end) / 2;

                if(list.get((int)mid) == T) {
                    System.out.println(0);
                    return;
                } else if (list.get((int)mid) > T) {
                    end = mid;
                } else {
                    start = mid + 1;
                }

            }
            ans = list.get((int) end) - T;
        }
        System.out.println(ans);
    }
}