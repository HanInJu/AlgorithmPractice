package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q9_2529 {
	// 0-9까지 10개에서 부등호+1개 뽑기, 중복불갸
	// 수열들 중 최대값과 최소값을 찾기! : 오름차순으로 진행하므로 최대, 최소 비교할 필요 없이 마지막이 최대, 처음이 최소!
	private static int n, m;
	private static List<String> numbers = new ArrayList<>();
	private static char[] signs;
	private static boolean[] visited;

	public static void recur(int cur, String number) {
		if(cur == m) {
			numbers.add(number);
			return;
		}
		for(int i = 0; i<n; i++) {
			if(cur == 0 || (!visited[i] && isPossible(number.charAt(number.length() - 1) - '0', signs[cur - 1], i))) {
				visited[i] = true;
				recur(cur+1, number+i);
				visited[i] = false;
			}
		}
	}

	public static boolean isPossible(int x, char sign, int y) {
		if(sign == '>') {
			return x > y;
		}
		return x < y;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = 10;
		int k = Integer.parseInt(br.readLine());
		m = k+1;

		visited = new boolean[n];
		signs = new char[k];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<k; i++) {
			signs[i] = st.nextToken().charAt(0);
		}

		recur(0, "");
		System.out.println(numbers.get(numbers.size()-1));
		System.out.println(numbers.get(0));
	}
}
