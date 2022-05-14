package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Q11_15593 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		List<Time> times = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			times.add(new Time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) - 1));
		}

		int answer = 0;
		int[] visited = new int[1001];

		for(int i = 0; i < times.size(); i++) {
			int time = 0;

			for(int j = 0; j < times.size(); j++) {
				if(j == i) {
					continue;
				}
				for(int k = times.get(j).start; k <= times.get(j).end; k++) {
					if(visited[k] == 0) {
						visited[k] = 1;
						time++;
					}
				}
			}

			answer = Math.max(answer, time);
			Arrays.fill(visited, 0);
		}

		System.out.println(answer);
	}

	static class Time {
		int start;
		int end;

		public Time(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
