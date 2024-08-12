import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K, cnt;
    static int[] tmp;
    static int result = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, N - 1);

        System.out.println(result);
    }

    static void mergeSort(int[] arr, int start, int end) {

        if(cnt > K) return;

        if(start < end) {
            int mid = (start + end) / 2;

            mergeSort(arr, start, mid);
            mergeSort(arr,mid + 1, end);

            merge(arr, start, mid, end);
        }
    }

    static void merge(int[] arr, int start, int mid, int end) {

        int st = start;
        int ed = mid + 1;
        int idx = 0;

        while(st <= mid && ed <= end) {

            if(arr[st] <= arr[ed]) {
                tmp[idx++] = arr[st++];
            } else {
                tmp[idx++] = arr[ed++];
            }
        }

        if(st > mid) {
            while(ed <= end) {
                tmp[idx++] = arr[ed++];
            }
        } else {
            while(st <= mid) {
                tmp[idx++] = arr[st++];
            }
        }

        st = start;
        idx = 0;

        while(st <= end) {
            cnt++;
            if(cnt == K) {
                result = tmp[idx];
                break;
            }
            arr[st++] = tmp[idx++];
        }
    }
}