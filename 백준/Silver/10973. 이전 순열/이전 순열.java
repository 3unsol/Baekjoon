import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 어디부터 바꿔야 하는지 찾기
        int index = arr.length - 1;
        while(index > 0 && arr[index - 1] <= arr[index]) {
            index--;
        }

        // 첫 번째 수열일 경우
        if(index <= 0) {
            System.out.println(-1);
            return;
        }

        // arr[index] 값보다 커지는 순간 찾기
        int mark = arr.length - 1;
        while(arr[index - 1] <= arr[mark]) {
            mark--;
        }

        // 커지는 순간이랑 자리 바꿈
        swap(index - 1, mark);

        // 그 사이 값 모두 바꿈
        mark = arr.length - 1;
        while(index < mark) {
            swap(index, mark);
            index++;
            mark--;
        }

        // 출력
        for(int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}