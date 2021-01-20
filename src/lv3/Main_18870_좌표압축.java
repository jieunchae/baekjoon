package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_18870_좌표압축 {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		//arr를 복사해서 정렬??!
		int[] copy = arr.clone();
		Arrays.sort(copy);
	
		//맵에 좌표압출
		int idx = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			if(!map.containsKey(copy[i])) {
				map.put(copy[i], idx++);
			}
		}
		
		//출력
		for(int i=0; i<N; i++) {
			out.write(Integer.toString(map.get(arr[i]))+" ");
		}
		out.flush();
		out.close();
		
		
	}

}
