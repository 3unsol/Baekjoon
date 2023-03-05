import java.util.Scanner;

public class Main {
	static int sNum;
	static int pNum;
	static int[] sArr;
	static int[][] pArr;

	static void change(int k, int j) {
		switch (k) {
		case 0:
			sArr[j] = 1;
			break;
		case 1:
			sArr[j] = 0;
			break;
		}
	}

	static void check(int k) {
		change(sArr[k], k);
		int idx = 1;
		while (k - idx >= 1 && k + idx <= sNum) {
			if (sArr[k - idx] == sArr[k + idx]) {
				change(sArr[k - idx], k - idx);
				change(sArr[k + idx], k + idx);
				idx++;
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sNum = sc.nextInt();
		sArr = new int[sNum + 1];
		for (int i = 1; i <= sNum; i++) {
			sArr[i] = sc.nextInt();
		}
		pNum = sc.nextInt();
		pArr = new int[pNum][2];
		for (int i = 0; i < pNum; i++) {
			for (int j = 0; j < 2; j++) {
				pArr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < pNum; i++) {
			if (pArr[i][0] == 1) {
				for (int j = 1; j <= sNum; j++) {
					if (j % pArr[i][1] == 0) {
						change(sArr[j], j);
					}
				}

			} else {
				check(pArr[i][1]);
			}
		}
		for (int i = 1; i <= sNum; i++) {
			System.out.print(sArr[i] + " ");
			if (i % 20 == 0) {
				System.out.println();
			}
		}
	}
}
