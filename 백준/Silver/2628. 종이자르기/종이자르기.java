import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int W, H, ans;
    static boolean[] cutW, cutH;

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

        cutH = new boolean[H + 1];
        cutW = new boolean[W + 1];

        cutH[H] = true;
        cutW[W] = true;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken()) == 0) {
                cutH[Integer.parseInt(st.nextToken())] = true;
            }else{
                cutW[Integer.parseInt(st.nextToken())] = true;
            }
        }

    }

    static void find() {

        int prevIndex = 0;
        int maxH = 0;

        for(int i = 1; i < cutH.length; i++){
            if(cutH[i]){
                maxH = Math.max(maxH, i - prevIndex);
                prevIndex = i;
            }
        }

        prevIndex = 0;
        int maxW = 0;

        for(int i = 1; i < cutW.length; i++){
            if(cutW[i]){
                maxW = Math.max(maxW, i - prevIndex);
                prevIndex = i;
            }
        }

        System.out.println(maxW * maxH);
    }
}