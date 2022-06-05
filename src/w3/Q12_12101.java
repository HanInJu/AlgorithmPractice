package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12_12101 {
	// 1,2,3 중 ?개를 뽑는 경우(합이 N이 되는)의 수 중 오름차순 k번째
	// 중복 허용!
	private static int N, K, count = 0;
	private static int[] arr;
	private static boolean isEnd;
	private static StringBuilder sb = new StringBuilder();

	public static void recur(int cur, int sum) {
		if(sum > N) {
			return;
		}
		if(sum == N) {
			count++;
			if(count == K) {
				for(int j = 0; j<cur; j++) {
					if(j == cur-1) {
						sb.append(arr[j]).append("\n");
					}
					else {
						sb.append(arr[j]).append("+");
					}
				}
				isEnd = true;
			}
			return;
		}

		for(int i = 1; i<=3; i++) {
			sum += i;
			arr[cur] = i;
			recur(cur+1, sum);
			if(isEnd) {
				return;
			}
			sum -= i;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[11];

		recur(0, 0);
		if(sb.toString().equals("")) {
			System.out.println(-1);
		}
		else {
			System.out.println(sb);
		}
	}
}
