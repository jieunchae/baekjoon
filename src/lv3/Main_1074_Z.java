package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1074_Z {
	//2의 15승을 간과함..
	static int N;
	static int r,c,num;
	static long ans;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		int twice = (int) Math.pow(2, N);
		
		dfs(0,twice,0,twice);
		
		out.write(Long.toString(ans-1));
		out.flush();
		out.close();
	}
	
	private static void dfs(int start_x, int end_x, int start_y, int end_y) {
		//System.out.println(start_x + " " + end_x + " "+ start_y + " " + end_y);
		int mid_x = (end_x+start_x)/2;
		int mid_y = (end_y+start_y)/2;
		long width = (long)(end_x-start_x);
		long half = width/2;
		if(width==1) {
			ans++;
			return;
		}
		
		if(r<mid_x) {
			if(c<mid_y) {
				dfs(start_x, mid_x, start_y, mid_y);
			}else {	//2번쨰 방문
				ans += half*half;
				dfs(start_x, mid_x, mid_y, end_y);
			}
		}else {
			if(c<mid_y) {
				ans += 2*half*half;;
				dfs(mid_x, end_x, start_y, mid_y);
			}else {
				ans += 3*half*half;
				dfs(mid_x, end_x, mid_y, end_y);
			}
		}
	}

}
