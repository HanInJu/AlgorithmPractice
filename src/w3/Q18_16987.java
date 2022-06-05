package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q18_16987 {
	// N개의 계란 중 가장 많은 계란을 깨야 함 : 중복 가능하지만 깨진 계란이면 안됨 : 중복순열
	// 부딪힌 계란의 무게만큼 서로 내구도가 깎인다. 내구도가 0 이하이면 깨짐
	private static int N, max = 0;
	private static Egg[] eggs;

	public static void recur(int cur, int brokenEgg) {
		if(cur == eggs.length) {
			max = Math.max(max, countBrokenEgg());
			return;
		}

		Egg current, opposite;
		if(eggs[cur].durability <= 0 || brokenEgg == N-1) {
			recur(cur+1, brokenEgg);
			return;
		}

		for(int i = 0; i<eggs.length; i++) { // 칠 계란을 고른다.
			if(i == cur) continue; 			 // 이미 들고 있는 계란은 칠 수 없다.
			if(eggs[i].durability > 0) { 	 // 고른 계란이 깨지지 않은 계란이라면,
				current = eggs[cur];
				opposite = eggs[i];

				hit(current, opposite); 	 // 친다.
				recur(cur + 1, countBrokenEgg());
				recover(current, opposite);  // 안 친 상태로 회복시킨다.
			}
		}
	}

	public static void hit(Egg current, Egg opposite) {
		opposite.durability -= current.weight;
		current.durability -= opposite.weight;
	}

	public static void recover(Egg current, Egg opposite) {
		opposite.durability += current.weight;
		current.durability += opposite.weight;
	}

	public static int countBrokenEgg() {
		int brokenEgg = 0;
		for(Egg egg : eggs) {
			if(egg.durability <= 0) {
				brokenEgg++;
			}
		}
		return brokenEgg;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		eggs = new Egg[N];

		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		recur(0, 0);
		System.out.println(max);
	}

	static class Egg {
		int durability;
		int weight;

		public Egg(int d, int w) {
			this.weight = w;
			this.durability = d;
		}
	}
}
