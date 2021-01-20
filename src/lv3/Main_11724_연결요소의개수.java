package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {
	static int N,M;
	static boolean[] check;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i=0; i<=N; i++) list.add(new ArrayList<Integer>());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.get(start).add(end);
			list.get(end).add(start);
		}
		check = new boolean[N+1];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int ans = 0;
		for(int i=1; i<=N; i++) {
			if(!check[i]) {
				check[i] = true;
				q.add(i);
				while(!q.isEmpty()) {
					int now = q.poll();
					for(int j=0; j<list.get(now).size(); j++) {
						int next = list.get(now).get(j);
						if(!check[next]) {
							q.add(next);
							check[next] = true;
						}
					}
				}
				ans++;
			}
		}
		out.write(Integer.toString(ans));
		out.flush();
		out.close();
	}

}
