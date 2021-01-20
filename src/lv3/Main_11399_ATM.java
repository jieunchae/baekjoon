package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11399_ATM {
	static int N;
	static int arr[];
	static int dp[];
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		//Ã³¸®
		Arrays.sort(arr);
		//System.out.println(Arrays.toString(arr));
		int sum = arr[0];
		for(int i=1; i<N; i++) {
			arr[i] = arr[i-1] + arr[i];
			sum += arr[i];
		}
		out.write(Integer.toString(sum));
		out.flush();
		out.close();
	}

}
