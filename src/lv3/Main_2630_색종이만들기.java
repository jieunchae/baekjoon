package lv3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2630_색종이만들기 {
	static int N;
	static int[][] map;
	static int white,blue;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cut(0,N,0,N);
		
		out.write(Integer.toString(white));
		out.newLine();
		out.write(Integer.toString(blue));
		out.flush();
		out.close();
		
		
	}
	private static void cut(int s_x, int e_x, int s_y, int e_y) {
		//System.out.println(s_x+" "+e_x+" "+s_y+" "+e_y);
		int color = map[s_x][s_y];
		boolean flag = true;
		
		abc:
		for(int i=s_x; i<e_x; i++) {
			for(int j=s_y; j<e_y; j++) {
				if(map[i][j] != color) {
					flag = false;
					break abc;
				}
			}
		}
		
		if(flag) {
			if(color == 1) blue++;
			else white++;
		}
		else {
			int mid_x = (s_x+e_x)/2;
			int mid_y = (s_y+e_y)/2;
			cut(s_x, mid_x, s_y, mid_y);
			cut(s_x, mid_x, mid_y, e_y);
			cut(mid_x, e_x, s_y, mid_y);
			cut(mid_x, e_x, mid_y, e_y);
		}
		
	}

}
