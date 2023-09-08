import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, max, min;
    static int[] woods;

    public static void main(String[] args) throws IOException {
        input();
        binarySearch();
        System.out.println(min - 1);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        woods = new int[n];
        max = 0;
        min = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            woods[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, woods[i]);
        }
    }

    static void binarySearch(){
        while(min < max) {
            int mid = (max + min) / 2;
            long sum = 0;
            for(int treeHeight : woods){
                if(treeHeight > mid){
                    sum += (treeHeight - mid);
                }
            }
            if(sum < m){
                max = mid;
            }else{
                min = mid + 1;
            }
        }
    }
}