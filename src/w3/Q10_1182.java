package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10_1182 {
	// n개에서 m개 뽑기인데 그 경우(수열의 합이 S가 되는)의 수를 세어야 함, 중복 불가! 조합!!!
	private static int N, S, answer = 0;
	private static int[] numbers;

	public static void recur(int sum, int start) {
		if(start == N) { // 마지막까지 가 봐야 한다...!
			return;
		}
		for(int i = start; i < N; i++) {
			sum += numbers[i];
			if(sum == S) {
				answer++;
			}
			recur(sum, i+1);
			sum -= numbers[i];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		numbers = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		recur(0, 0);
		System.out.println(answer);
	}
}
