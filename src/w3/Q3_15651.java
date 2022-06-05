package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3_15651 {
	//n개에서 m개 뽑기, 중복 허용 순서 지켜서, 중복순열
	private static int n, m;
	private static int[] arr;
	private static StringBuilder sb = new StringBuilder();

	public static void recur(int cur) {
		if(cur == m) {
			for(int i = 0; i<m; i++) {
				sb.append(arr[i] + 1).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i = 0; i<n; i++) {
			arr[cur] = i;
			recur(cur+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[m];

		recur(0);
		System.out.println(sb);
	}
}
