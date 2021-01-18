package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_1003_피보나치함수 {
	static int T,N;
	static int[][] dp = new int[41][2];
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(in.readLine());
		
		//처리
		dp[0][0] = 1;
		dp[1][1] = 1;
		for(int i=2; i<=40; i++) {
			dp[i][0] = dp[i-1][0]+dp[i-2][0];
			dp[i][1] = dp[i-1][1]+dp[i-2][1];
		}
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(in.readLine());
			out.write(Integer.toString(dp[N][0])+" "+Integer.toString(dp[N][1]));
			out.newLine();
		}
		
		out.flush();
		out.close();
	}

}
