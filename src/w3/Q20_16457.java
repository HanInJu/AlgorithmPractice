package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q20_16457 {
	// k개 중 n개를 골라야 하고, 각각의 m개의 퀘스트에서는 k개의 스킬을 써야 한다.
	// 조합!
	// m개의 퀘스트 개수가 최대가 되도록!
	private static int N, M, K, max = -1;
	private static int[][] skillSet;
	private static List<Integer> skillList = new ArrayList<>();
	private static int[] arr;

	public static void recur(int cur, int start) {
		if(cur == N) {
			max = Math.max(max, countQuests());
			return;
		}

		for(int i = start; i < skillList.size(); i++) {
			arr[cur] = skillList.get(start);
			recur(cur+1, i+1);
		}
	}

	public static int countQuests() {
		int result = 0;
		int count;
		for(int i = 0; i < M; i++) {
			count = 0;
			for(int j = 0; j < K; j++) {
				for(int k = 0; k < N; k++) {
					if(arr[k] == skillSet[i][j]) {
						count++;
						break;
					}
				}
			}
			if(count == K) {
				result++;
			}
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		skillSet = new int[M][K];
		arr = new int[N];

		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<K; j++) {
				skillSet[i][j] = Integer.parseInt(st.nextToken());
				if(!skillList.contains(skillSet[i][j])) {
					skillList.add(skillSet[i][j]);
				}
			}
		}

		recur(0, 0);
		System.out.println(max);
	}
}
