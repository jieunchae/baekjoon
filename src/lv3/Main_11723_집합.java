package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_11723_С§Че {
	//arr...
	static int M;
	static boolean arr[] = new boolean[21];
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		M = Integer.parseInt(in.readLine());
		StringTokenizer st;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			String order = st.nextToken();
			int num = 0;
			if(!order.equals("all") && !order.equals("empty"))
				num = Integer.parseInt(st.nextToken());
			if(order.equals("add")) {
				arr[num] = true;
			}else if(order.equals("remove")) {
				arr[num] = false;
			}else if(order.equals("check")) {
				if(arr[num]) out.write("1");
				else out.write("0");
				out.newLine();
			}else if(order.equals("toggle")) {
				arr[num] = !arr[num];
			}else if(order.equals("all")) {
				for(int j=1; j<=20; j++) arr[j] = true;
			}else {
				for(int j=1; j<=20; j++) arr[j] = false;
			}
		}
		out.flush();
		out.close();
	}
}
