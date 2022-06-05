package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1 {
	//n개에서 m개 뽑기, 중복없이 순서 지켜서, 즉 순열!
	private static int n, m;
	private static int[] arr;
	private static boolean[] visited;
	public static void recur(int cur) {
		if(cur == m) {
			for(int i = 0; i<m; i++) {
				System.out.print(arr[i]+1 + " ");
			}
			System.out.println();
			return;
		}

		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				arr[cur] = i;
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
		visited = new boolean[n];

		recur(0);
	}
}
