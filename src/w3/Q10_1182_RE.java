package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10_1182_RE {
	// n개에서 m개 뽑기인데 그 경우(수열의 합이 S가 되는)의 수를 세어야 함, 중복 불가! 조합!!!
	private static int N, S, answer2 = 0;
	private static int[] numbers;

	public static void recur2(int sum, int start) {
		if(sum == S) {
			answer2++;
			if(start == N) { // 마지막까지 가 봐야 한다...!
				return;
			}
		}
		for(int i = start; i < N; i++) {
			sum += numbers[i];
			recur2(sum, i+1);
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

		recur2(0,0);
		if(S == 0) { // 합이 0이면 아무것도 더하지 않아도 바로 sum == S 조건을 만족하므로 공집합 제외
			answer2 -= 1;
		}
		System.out.println(answer2);
	}
}
