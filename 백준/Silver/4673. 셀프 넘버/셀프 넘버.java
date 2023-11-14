import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean[] exist = new boolean[10001];
        for(int i = 1; i < 10; i++){
            exist[i + i] = true;
        }
        for(int i = 10; i < 100; i++){
            int num = i + (i / 10) + (i % 10);
            exist[num] = true;
        }
        for(int i = 100; i < 1000; i++){
            int num = i + (i / 100) + ((i % 100) / 10) + (i % 10);
            exist[num] = true;
        }
        for(int i = 1000; i < 10000; i++){
            int num = i + (i / 1000) + ((i % 1000) / 100) + ((i % 100) / 10) + (i % 10);
            if(num <= 10000){
                exist[num] = true;
            }
        }
        for(int i = 1; i < 10000; i++){
            if(!exist[i]){
                System.out.println(i);
            }
        }
    }
}