import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] names = new String[N];
        StringBuilder list = new StringBuilder();
        for(int i = 0; i < N; i++){
            names[i] = br.readLine();
            list.append(names[i]);
        }

        Arrays.sort(names);
        StringBuilder incre = new StringBuilder();
        for(int i = 0; i < N; i++){
            incre.append(names[i]);
        }

        StringBuilder decre = new StringBuilder();
        Arrays.sort(names, Collections.reverseOrder());
        for(int i = 0; i < N; i++){
            decre.append(names[i]);
        }

        if(list.toString().equals(incre.toString())){
            System.out.println("INCREASING");
        }else if(list.toString().equals(decre.toString())){
            System.out.println("DECREASING");
        }else{
            System.out.println("NEITHER");
        }
    }
}