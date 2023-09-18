import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int A, B, C, D, E, time;
    public static void main(String[] args) throws IOException {
        input();
        calc();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        D = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        time = 0;
    }
    static void calc(){
        while(A < 0){
            A++;
            time += C;
        }
        if(A == 0){
            time += D;
        }
        while(A < B){
            A++;
            time += E;
        }
        if(A == B){
            System.out.println(time);
        }
    }
}