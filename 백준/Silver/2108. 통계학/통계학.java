import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] cnt = new int[8001];
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int median = 10000;
		int mode = 10000;
		for (int i = 0; i < n; i++) {
			int tmp = sc.nextInt();
			cnt[tmp + 4000]++;
			sum += tmp;
			max = Math.max(max, tmp);
			min = Math.min(min, tmp);

		}
		int count = 0; // 중앙값 빈도 누적수
		int mode_max = 0; // 최빈값의 최댓값
		boolean flag = false;

		for (int i = min + 4000; i <= max + 4000; i++) {
			if (cnt[i] > 0) {
				if (count < (n + 1) / 2) {
					count += cnt[i];
					median = i - 4000;
				}
				if (mode_max < cnt[i]) {
					mode_max = cnt[i];
					mode = i - 4000;
					flag = true;
				} else if (mode_max == cnt[i] && flag == true) {
					mode = i - 4000;
					flag = false;
				}
			}
		}
		System.out.println((int) Math.round((double) sum / n));
		System.out.println(median);
		System.out.println(mode);
		System.out.println(max - min);
	}
}