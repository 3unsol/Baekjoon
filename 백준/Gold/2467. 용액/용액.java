import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] solution = new int[N];

        for(int i = 0; i < N; i++){
            solution[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = N - 1;
        int ansIndex1 = start;
        int ansIndex2 = end;
        int dist = Integer.MAX_VALUE;

        while(start < end) {

            int now = solution[start] + solution[end];

            if(dist > Math.abs(now)) {
                dist = Math.abs(now);
                ansIndex1 = start;
                ansIndex2 = end;
                if(dist == 0) break;
            }

            if(now >= 0){
                end--;
            }else{
                start++;
            }
        }

        System.out.println(solution[ansIndex1] + " " + solution[ansIndex2]);
    }
}