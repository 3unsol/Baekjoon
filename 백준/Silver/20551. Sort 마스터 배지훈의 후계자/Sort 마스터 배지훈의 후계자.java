import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      StringBuilder sb = new StringBuilder();
      
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      
      int[] arr = new int[N];
      
      for(int i = 0; i < N; i++) {
          arr[i] = Integer.parseInt(br.readLine());
      }
      
      Arrays.sort(arr);
      
      for(int i = 0; i < M; i++) {
          
          int target = Integer.parseInt(br.readLine());
          
          int start = 0;
          int end = N - 1;
          int mid = 0;
          int ans = -1;
          while(start <= end) {
              
              mid = (start + end) / 2;
              
              if(arr[mid] > target){
                  end = mid - 1;
              } else if(arr[mid] < target){
                  start = mid + 1;
              } else {
                  ans = mid;
                  end = mid - 1;
                  
              }
          }
          sb.append(ans).append("\n");
      }
      System.out.println(sb);
    }
}