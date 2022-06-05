package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q8_15657 {
	// n개 중 m개 뽑기, 중복 허용, 같은 수 오름차순!
	private static int n, m;
	private static int[] arr;
	private static int[] numbers;
	private static StringBuilder sb = new StringBuilder();

	public static void recur(int cur, int start) {
		if(cur == m) {
			for(int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i = start; i<n; i++) {
			arr[cur] = numbers[i];
			recur(cur+1, i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		numbers = new int[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);

		recur(0, 0);
		System.out.println(sb);
	}
}
