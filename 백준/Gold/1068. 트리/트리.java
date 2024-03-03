import java.util.*;
import java.io.*;
public class Main {

    static int N, head, cnt;
    static boolean[] isVisited;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N];
        parents = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {

            int parent = Integer.parseInt(st.nextToken());
            parents[i] = parent;

            if(parent == -1) {
                head = i;
            }
        }

        int deleteNum = Integer.parseInt(br.readLine());

        if(deleteNum == head) {
            System.out.println(0);
            return;
        }

        deleteDfs(deleteNum);

        cnt = 0;

        findDfs(head);

        System.out.println(cnt);
    }

    static void deleteDfs(int num) {

        parents[num] = -2;

        for(int i = 0; i < N; i++) {
            if(parents[i] == num) {
                deleteDfs(i);
            }
        }
    }

    static void findDfs(int num) {

        boolean isLeaf = true;
        isVisited[num] = true;

        if(parents[num] != -2) {

            for(int i = 0; i < N; i++) {
                if(parents[i] == num && !isVisited[i]) {
                    findDfs(i);
                    isLeaf = false;
                }
            }

            if(isLeaf) cnt++;
        }

    }
}