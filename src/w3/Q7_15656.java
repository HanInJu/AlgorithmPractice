package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q7_15656 {
	//n개 중 m개 뽑기, 중복허용, 중복순열!
	private static int n, m;
	private static int[] arr;
	private static int[] numbers;
	private static StringBuilder sb = new StringBuilder();

	public static void recur(int cur) {
		if(cur == m) {
			for(int a : arr)  {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i = 0; i<n; i++) {
			arr[cur] = numbers[i];
			recur(cur+1);
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

		recur(0);
		System.out.println(sb);
	}
}
