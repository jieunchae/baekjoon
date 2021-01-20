package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1620_나는야포켓몬마스터 {
	static int N,M;
	static String[] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new String[N+1];
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=1; i<=N; i++) {
			arr[i] = in.readLine();
			map.put(arr[i], i);
		}
		
		//문제
		for(int i=0; i<M; i++) {
			String now = in.readLine();
			if(now.charAt(0) >= '0' && now.charAt(0) <= '9') {	//숫자
				out.write(arr[Integer.parseInt(now)]);
			}else {
				out.write(Integer.toString(map.get(now)));
			}
			out.newLine();
		}
		out.flush();
		out.close();
		
		
		

	}

}
