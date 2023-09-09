import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static String str, ans;

    public static void main(String[] args) throws IOException {
        input();
        replace();
        print();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
    }

    static void replace(){
        str = str.replaceAll("XXXX", "AAAA");
        ans = str.replaceAll("XX", "BB");
    }

    static boolean check(){
        if(ans.contains("X")){
            return false;
        }
        return true;
    }

    static void print(){
        if(check()){
            System.out.println(ans);
        }
        else{
            System.out.println(-1);
        }
    }
}