import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * dfs로 사이클 확인
 * 사이클이 만들어지면 list에 넣기
 */
public class Main {

    static int N;
    static int[] arr;
    static List<Integer> list;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        isVisited = new boolean[N + 1];

        // 1번부터 사이클이 발생하는지 확인
        for(int i = 1; i <= N; i++) {
            isVisited[i] = true;
            dfs(i, i);
            isVisited[i] = false;
        }

        Collections.sort(list);

        System.out.println(list.size());
        for(int num : list) {
            System.out.println(num);
        }
    }

    /**
     * 사이클이 만들어지는지 확인
     * @param num : 현재 값
     * @param target : 시작 값
     */
    static void dfs(int num, int target) {
        if(!isVisited[arr[num]]) {
            isVisited[arr[num]] = true;
            dfs(arr[num], target);
            isVisited[arr[num]] = false;
        }
        // 시작 값을 만났다면 사이클 발생
        if(arr[num] == target) {
            list.add(target);
        }
    }
}