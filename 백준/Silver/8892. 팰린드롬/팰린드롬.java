import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    
    int t = sc.nextInt();
    
    for(int k = 0; k < t; k++) {
      boolean check = false;
      int n = sc.nextInt();
      String[] arr = new String[n];
      for(int i = 0; i < n; i++) arr[i] = sc.next();

      loop:
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
          if(i == j) continue;
          String str = arr[i] + arr[j];
          String rev = new StringBuilder(str).reverse().toString();
          if(str.equals(rev)) {
            sb.append(str+"\n");
            check = true;
            break loop;
          }
        }
      }
      if(check == false) sb.append(0+"\n");
    }
    
    System.out.println(sb);
  }
}