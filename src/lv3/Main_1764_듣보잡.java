package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1764_듣보잡 {
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> map = new HashMap<>();
		//듣도 못한 사람
		for(int i=0; i<N; i++) {
			String key = in.readLine();
			map.put(key, 0);
		}
		//보도 못한 사람
		ArrayList<String> list = new ArrayList<>();
		int ans = 0;
		for(int i=0; i<M; i++) {
			String key = in.readLine();
			if(map.containsKey(key)) {
				ans++;
				list.add(key);
			}
		}
		//출력
		Collections.sort(list);
		out.write(Integer.toString(ans));
		out.newLine();
		for(int i=0; i<ans; i++) {
			out.write(list.get(i));
			out.newLine();
		}
		out.flush();
		out.close();
	}

}
