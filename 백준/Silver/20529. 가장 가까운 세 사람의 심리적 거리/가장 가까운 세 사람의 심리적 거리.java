import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, min;
    static String[] types;

    public static void main(String[] args) throws IOException {
        input();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int t = 1; t <= testCase; t++) {
            n = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            types = new String[n];
            for(int i = 0; i < n; i++){
                types[i] = st.nextToken();
            }
            if(n >= 33){
                System.out.println(0);
                continue;
            }
            calc();
            System.out.println(min);
        }
    }

    static void calc(){
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    int tmp = 0;
                    char[] a = types[i].toCharArray();
                    char[] b = types[j].toCharArray();
                    char[] c = types[k].toCharArray();
                    for(int idx = 0; idx < 4; idx++){
                        if(a[idx] != b[idx]){
                            tmp++;
                        }
                        if(b[idx] != c[idx]){
                            tmp++;
                        }
                        if(a[idx] != c[idx]){
                            tmp++;
                        }
                    }
                    if(min > tmp){
                        min = tmp;
                    }
                    if(min == 0){
                        break;
                    }
                }
            }
        }
    }
}