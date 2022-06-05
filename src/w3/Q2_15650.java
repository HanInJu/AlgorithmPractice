package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2_15650 {
	//n개에서 m개 뽑기, 중복 없이 오름차순만! 즉 순열인데 오름차순!
	private static int n,m;
	private static int[] arr;

	public static void recur(int cur, int start) {
		if(cur == m) {
			for(int i = 0; i<m; i++) {
				System.out.print((arr[i]+1) + " ");
			}
			System.out.println();
			return;
		}

		for(int i = start; i<n; i++) {
			arr[cur] = i;
			recur(cur+1, i+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];

		recur(0, 0);
	}
}
