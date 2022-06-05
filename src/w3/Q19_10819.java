package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19_10819 {
	// 앞에서 뒤를 뺀 절대값의 합이 최대가 되도록 배열하라 : 순열!
	private static int N, max = -987654321;
	private static int[] numbers;
	private static int[] arr;
	private static boolean[] visited;

	public static void recur(int cur) {
		if(cur == N) { // n개 다 골랐으면 멈춰!
			max = Math.max(max, calculate());
			return;
		}

		for(int i = 0; i<N; i++) {
			if(!visited[i]) {
				arr[cur] = numbers[i];
				visited[i] = true;
				recur(cur+1);
				visited[i] = false;
			}
		}
	}

	public static int calculate() {
		int result = 0;
		for(int i = 0; i<N-1; i++) {
			result += Math.abs(arr[i] - arr[i+1]);
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		arr = new int[N];
		visited = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		recur(0);
		System.out.println(max);
	}
}
