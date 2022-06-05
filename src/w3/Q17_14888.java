package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17_14888 {
	// N-1개 줄세우기! 중복 가능 - 중복순열!
	private static int N, min = 987654321, max = -987654321;
	private static int[] numbers;
	private static int[] operators; // + - * /
	private static int[] arr; // 선택한 연산자 배열

	public static void recur(int cur) {
		if(cur == N-1) {
			int result = calculate();
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}

		for(int i = 0; i<4; i++) { // 연산자 4개 중 선택
			if(operators[i] >= 1) { // 남은 연산자의 수가 1보다 크거나 같아야 함
				arr[cur] = i;
				operators[i]--;
				recur(cur+1);
				operators[i]++;
			}
		}
	}

	public static int calculate() {
		int result = numbers[0];
		for(int i = 1; i<numbers.length; i++) {
			switch (arr[i-1]) {
				case 0:
					result += numbers[i];
					break;
				case 1:
					result -= numbers[i];
					break;
				case 2:
					result *= numbers[i];
					break;
				case 3:
					if (result < 0) {
						result = -(Math.abs(result) / (numbers[i]));
					} else if (numbers[i] < 0) {
						result = -((result) / Math.abs(numbers[i]));
					} else {
						result /= numbers[i];
					}
					break;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N-1];
		operators = new int[4];
		numbers = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}

		recur(0);
		System.out.println(max);
		System.out.println(min);
	}
}
