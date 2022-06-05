package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q5_15654 {
	// n개에서 m개 뽑기, 순열!
	private static int n, m;
	private static int[] numbers;
	private static int[] arr;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void recur(int cur) {
		if(cur == m) {
			for(int i = 0; i<m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i = 0; i<n; i++) {
			if(!visited[i]) {
				arr[cur] = numbers[i];
				visited[i] = true;
				recur(cur+1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];
		numbers = new int[n];
		visited = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);

		recur(0);
		System.out.println(sb);
	}
}
