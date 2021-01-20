package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_9095_123더하기 {
	static int T,N;
	static int[] dp = new int[11];	//최대 10,,,
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		//dp 배열 먼저 만들고
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4; i<=10; i++) dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
		
		T = Integer.parseInt(in.readLine());
		for(int test_case=1; test_case<=T; test_case++) {
			N = Integer.parseInt(in.readLine());
			out.write(Integer.toString(dp[N]));
			out.newLine();
		}
		out.flush();
		out.close();
	}
}
