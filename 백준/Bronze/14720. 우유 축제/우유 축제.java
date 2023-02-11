import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 우유 개수
		int num = sc.nextInt();

		// 우유 배열에 넣기
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		int temp = 0;
		int sum = 0;
		for (int i = 0; i < num; i++) {
			if (arr[i] == temp) {
				sum++;
				if (temp == 0) {
					temp = 1;
				} else if (temp == 1) {
					temp = 2;
				} else if (temp == 2) {
					temp = 0;
				}
			}
		}
		System.out.println(sum);
	}
}
