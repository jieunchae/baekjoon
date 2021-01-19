package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2606_¿ú¹ÙÀÌ·¯½º {
	static int N,M;
	static int ans;
	static boolean[] check;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		for(int i=0; i<=N; i++) list.add(new ArrayList<Integer>());
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list.get(start).add(end);
			list.get(end).add(start);
		}
		
		//DFS
		check = new boolean[N+1];
		check[1] = true;
		dfs(1);
		out.write(Integer.toString(ans));
		out.flush();
		out.close();
		
	}
	private static void dfs(int now) {
		for(int j=0; j<list.get(now).size(); j++) {
			int next = list.get(now).get(j);
			if(!check[next]) {
				check[next] = true;
				ans++;
				dfs(next);
			}
		}
	}

}
