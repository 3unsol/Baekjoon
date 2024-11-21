import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        Set<Integer> B = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            if (B.contains(A[i])) continue;
            list.add(A[i]);
        }

        Collections.sort(list);

        for(int num : list) {
            sb.append(num).append(" ");
        }

        if(list.size() != 0) {
            System.out.println(list.size());
            System.out.print(sb);
        } else {
            System.out.println(0);
        }
    }
}