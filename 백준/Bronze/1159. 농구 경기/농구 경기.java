import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[26];
        for(int i = 0; i < N; i++) {
            arr[sc.next().charAt(0) - 'a']++;
        }
        boolean flag = false;
        for(int i = 0; i < 26; i++) {
            if(arr[i] >= 5) {
                flag = true;
                System.out.print((char) (i + 'a'));
            }
        }
        if(!flag) System.out.println("PREDAJA");
    }
}