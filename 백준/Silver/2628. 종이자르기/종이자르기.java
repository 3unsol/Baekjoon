import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int W, H, ans;
    static Integer[] cutW, cutH;

    public static void main(String[] args) throws Exception {
        input();
        find();
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        cutW = new Integer[n + 2];
        cutH = new Integer[n + 2];

        Arrays.fill(cutW, 0);
        Arrays.fill(cutH, 0);

        cutW[0] = H;
        cutH[0] = W;

        int indexW = 1;
        int indexH = 1;

        for(int i = 0; i < n; i++){

            st = new StringTokenizer(br.readLine());

            if(Integer.parseInt(st.nextToken()) == 0){
                cutW[indexW++] = Integer.parseInt(st.nextToken());
            }else{
                cutH[indexH++] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void find(){

        Arrays.sort(cutW);
        Arrays.sort(cutH);

        int maxW = 0;
        int maxH = 0;

        for(int i = cutW.length - 1; i > 0; i--){
            if(cutW[i] == 0) continue;
            maxW = Math.max(maxW, cutW[i] - cutW[i - 1]);
        }

        for(int i = cutH.length - 1; i > 0; i--){
            if(cutH[i] == 0) continue;
            maxH = Math.max(maxH, cutH[i] - cutH[i - 1]);
        }
        
        ans = maxW * maxH;

        System.out.println(ans);
    }
}