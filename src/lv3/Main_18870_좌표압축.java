package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_18870_��ǥ���� {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		//arr�� �����ؼ� ����??!
		int[] copy = arr.clone();
		Arrays.sort(copy);
	
		//�ʿ� ��ǥ����
		int idx = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			if(!map.containsKey(copy[i])) {
				map.put(copy[i], idx++);
			}
		}
		
		//���
		for(int i=0; i<N; i++) {
			out.write(Integer.toString(map.get(arr[i]))+" ");
		}
		out.flush();
		out.close();
		
		
	}

}
